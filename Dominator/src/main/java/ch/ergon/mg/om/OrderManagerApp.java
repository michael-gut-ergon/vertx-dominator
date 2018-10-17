package ch.ergon.mg.om;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.flywaydb.core.Flyway;
import org.yaml.snakeyaml.Yaml;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.ext.dropwizard.DropwizardMetricsOptions;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;

public class OrderManagerApp {
	public static final Logger LOGGER = LoggerFactory.getLogger(OrderManagerApp.class);
	public static Configuration CONF;
	public static DbUtil DB;

	public static void main(String[] args) {
		LOGGER.info("OrderManagerApp start...");
		try {
			CONF = loadConfiguration(args[1]);
			DB = new DbUtil(CONF);
		
			// flyway migration on startup
	        Flyway flyway = new Flyway();
	        Database dbConf = CONF.getDatabase();
			flyway.setDataSource(dbConf.getUrl(), dbConf.getUsername(), dbConf.getPassword());
			flyway.setSchemas(dbConf.getSchema());
			LOGGER.info("  Flyway Database "+dbConf.getUrl()+" / "+dbConf.getSchema());
			LOGGER.info("  Flyway Migrate "+flyway.getBaselineVersion().getVersion()+" > "+flyway.getTarget().getVersion());
			flyway.migrate();
			
			// Vert.x startup 
			ClusterManager mgr = new HazelcastClusterManager();
			// Metrics
			VertxOptions options = new VertxOptions().setClusterManager(mgr);
			DropwizardMetricsOptions metrics = new DropwizardMetricsOptions();
			metrics.setEnabled(true);
			metrics.setJmxEnabled(true);
			options.setMetricsOptions(metrics);
						
			Vertx.clusteredVertx(options, res -> {
				if (res.succeeded()) {
					Vertx vertx = res.result();
				  	vertx.deployVerticle(new OrderManagerVerticle(), stringAsyncResult -> {
				  		System.out.println("OrderManagerVerticle deployment complete");
				  	});
				  	vertx.deployVerticle(new HttpServerVerticle(), stringAsyncResult -> {
				  		System.out.println("HttpServerVerticle deployment complete");
				  	});
				} else {
					// failed!
					LOGGER.error("OrderManager cluster manager start failed");
				}
			});
		} catch (IOException e) {
			LOGGER.error("OrderManager start exception ");
			e.printStackTrace();
		}
    }
	
	public static Configuration loadConfiguration(String confFile) throws IOException {
		LOGGER.info("Loading configuration file "+confFile);
		Yaml yaml = new Yaml();  
        InputStream in = Files.newInputStream(Paths.get(confFile));
        return yaml.loadAs(in, Configuration.class);
	}

}
