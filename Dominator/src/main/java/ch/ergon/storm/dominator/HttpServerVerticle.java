package ch.ergon.storm.dominator;

import ch.ergon.storm.dominator.controller.CustomerController;
import ch.ergon.storm.dominator.controller.FactoryController;
import ch.ergon.storm.dominator.controller.ProductController;
import ch.ergon.storm.dominator.controller.ServiceController;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;


public class HttpServerVerticle extends AbstractVerticle {
	public static final Logger LOGGER = LoggerFactory.getLogger(HttpServerVerticle.class);
	private HttpServer httpServer = null;

    @Override
    public void start(Future<Void> startFuture) throws Exception {
    	LOGGER.info("HttpServerVerticle starting... ");
    	Router router = Router.router(vertx);

    	String restURL = "/"+ DominatorApp.CONF.getServiceDomain()+"/"+ DominatorApp.CONF.getApiVersion();
    	LOGGER.info("HttpServerVerticle REST URL "+restURL);
    	// Service
    	router.get(restURL+"/services").handler(ServiceController::getAll);
    	router.get(restURL+"/service/:id").handler(ServiceController::getService);
    	router.route(restURL+"/service*").handler(BodyHandler.create());
    	router.post(restURL+"/services").handler(ServiceController::addService);
    	router.delete(restURL+"/service/:id").handler(ServiceController::deleteService);
    	// Product
    	router.get(restURL+"/products").handler(ProductController::getAll);
    	router.get(restURL+"/product/:id").handler(ProductController::getProduct);
    	// Customer
    	router.get(restURL+"/customers").handler(CustomerController::getAll);
    	router.get(restURL+"/customer/:id").handler(CustomerController::getCustomer);
    	// Factory
    	router.get(restURL+"/factories").handler(FactoryController::getAll);
    	router.get(restURL+"/factory/:id").handler(FactoryController::getFactory);
    	
    	// Web content
    	router.route("/*").handler(StaticHandler.create(DominatorApp.CONF.getWebRoot()).setCachingEnabled(false));
    	
    	vertx
    		.createHttpServer()
    		.requestHandler(router::accept)
    		.listen(config().getInteger("http.port", DominatorApp.CONF.getServerPort()),
    			result -> {
    				if (result.succeeded()) {
    					startFuture.complete();
    				} else {
    					startFuture.fail(result.cause());
    				}
    			}
    		);
    }
    
    @Override
    public void stop() throws Exception {
        System.out.println("HttpServerVerticle stopped.");
        httpServer.close();
    }

}
