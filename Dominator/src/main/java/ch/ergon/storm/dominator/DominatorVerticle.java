package ch.ergon.storm.dominator;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class DominatorVerticle extends AbstractVerticle {

	@Override
    public void start(Future<Void> startFuture) {
		System.out.println("DominatorVerticle starting...");
		vertx.eventBus().publish("billItem", "billitem-123456789");
		vertx.eventBus().send("cdr", "cdr-1111");
		vertx.eventBus().send("udr", "udr-2222");
		System.out.println("Send events");
		vertx.eventBus().send("cdr", "cdr-1112");
		vertx.eventBus().send("cdr", "cdr-1113");
		vertx.eventBus().send("udr", "udr-2223");
		
        System.out.println("DominatorVerticle started!");
    }

    @Override
    public void stop() throws Exception {
        System.out.println("DominatorVerticle stopped.");
    }

}
