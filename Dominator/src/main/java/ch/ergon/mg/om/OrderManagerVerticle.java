package ch.ergon.mg.om;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class OrderManagerVerticle extends AbstractVerticle {

	@Override
    public void start(Future<Void> startFuture) {
		System.out.println("OrderManagerVerticle starting...");
		vertx.eventBus().publish("billItem", "billitem-123456789");
		vertx.eventBus().send("cdr", "cdr-1111");
		vertx.eventBus().send("udr", "udr-2222");
		System.out.println("Send events");
		vertx.eventBus().send("cdr", "cdr-1112");
		vertx.eventBus().send("cdr", "cdr-1113");
		vertx.eventBus().send("udr", "udr-2223");
		
        System.out.println("OrderManagerVerticle started!");        
    }

    @Override
    public void stop() throws Exception {
        System.out.println("OrderManagerVerticle stopped.");
    }

}
