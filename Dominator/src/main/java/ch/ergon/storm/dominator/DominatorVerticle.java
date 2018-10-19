package ch.ergon.storm.dominator;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class DominatorVerticle extends AbstractVerticle {

	@Override
	public void start(Future<Void> startFuture) {
		System.out.println("DominatorVerticle starting...");
		vertx.eventBus().publish("domination", "France");
		vertx.eventBus().send("attack", "Belgium");
		vertx.eventBus().send("occupiy", "Luxembourg");
		System.out.println("DominatorVerticle started!");
	}

	@Override
	public void stop() throws Exception {
		System.out.println("DominatorVerticle stopped.");
	}

}
