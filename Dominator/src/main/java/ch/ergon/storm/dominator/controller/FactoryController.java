package ch.ergon.storm.dominator.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import ch.ergon.storm.dominator.DominatorApp;
import ch.ergon.storm.dominator.jooq.enums.ServiceState;
import ch.ergon.storm.dominator.jooq.tables.pojos.Factory;
import ch.ergon.storm.dominator.jooq.tables.pojos.Service;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

public class FactoryController {

	public static void getAll(RoutingContext routingContext) {
		List<Factory> customers = DominatorApp.DB.getFactories();
		
		routingContext.response()
			.putHeader("content-type", "application/json; charset=utf-8")
			.end(Json.encodePrettily(customers));
	}
	
	public static void getFactory(RoutingContext routingContext) {
		Factory customer = new Factory();
		
		String id = routingContext.request().getParam("id");
		if (id == null) {
			routingContext.response().setStatusCode(400).end();
		} else {
			Integer idAsInteger = Integer.valueOf(id);
			customer = DominatorApp.DB.getFactory(idAsInteger);
			routingContext.response()
				.putHeader("content-type", "application/json; charset=utf-8")
				.end(Json.encodePrettily(customer));
		}
	}
	
	public static void addFactory(RoutingContext routingContext) {
		final Service service = Json.decodeValue(routingContext.getBodyAsString(), Service.class);
		//routingContext.getCookie(name);
		Integer id = DominatorApp.DB.createService(service, "ws");
		service.setId(id);
		
		routingContext.response()
			.setStatusCode(201)
			.putHeader("content-type", "application/json; charset=utf-8")
			.end(Json.encodePrettily(service));
	}
	
	public static void deleteFactory(RoutingContext routingContext) {
		String id = routingContext.request().getParam("id");
		if (id == null) {
			routingContext.response().setStatusCode(400).end();
		} else {
			Integer idAsInteger = Integer.valueOf(id);
			Service service = DominatorApp.DB.getService(idAsInteger);
			if (service != null) {
				Date now = new Date();
				service.setState(ServiceState.CANCELLED);
				service.setValidUntil(new Timestamp(now.getTime()));
				DominatorApp.DB.updateService(service, "ws");
			} else {
				routingContext.response().setStatusCode(400).end();
			}
		}
		routingContext.response().setStatusCode(204).end();
	}
	
}
