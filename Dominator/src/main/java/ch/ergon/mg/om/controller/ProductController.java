package ch.ergon.mg.om.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import ch.ergon.mg.om.OrderManagerApp;
import ch.ergon.mg.om.jooq.enums.ServiceState;
import ch.ergon.mg.om.jooq.tables.pojos.Product;
import ch.ergon.mg.om.jooq.tables.pojos.Service;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

public class ProductController {

	public static void getAll(RoutingContext routingContext) {
		List<Product> products = OrderManagerApp.DB.getProducts();
		
		routingContext.response()
			.putHeader("content-type", "application/json; charset=utf-8")
			.end(Json.encodePrettily(products));
	}
	
	public static void getProduct(RoutingContext routingContext) {
		Product product = new Product();
		
		String id = routingContext.request().getParam("id");
		if (id == null) {
			routingContext.response().setStatusCode(400).end();
		} else {
			Integer idAsInteger = Integer.valueOf(id);
			product = OrderManagerApp.DB.getProduct(idAsInteger);
			routingContext.response()
				.putHeader("content-type", "application/json; charset=utf-8")
				.end(Json.encodePrettily(product));
		}
	}
	
	public static void addProduct(RoutingContext routingContext) {
		final Service service = Json.decodeValue(routingContext.getBodyAsString(), Service.class);
		//routingContext.getCookie(name);
		Integer id = OrderManagerApp.DB.createService(service, "ws");
		service.setId(id);
		
		routingContext.response()
			.setStatusCode(201)
			.putHeader("content-type", "application/json; charset=utf-8")
			.end(Json.encodePrettily(service));
	}
	
	public static void deleteProduct(RoutingContext routingContext) {
		String id = routingContext.request().getParam("id");
		if (id == null) {
			routingContext.response().setStatusCode(400).end();
		} else {
			Integer idAsInteger = Integer.valueOf(id);
			Service service = OrderManagerApp.DB.getService(idAsInteger);
			if (service != null) {
				Date now = new Date();
				service.setState(ServiceState.CANCELLED);
				service.setValidUntil(new Timestamp(now.getTime()));
				OrderManagerApp.DB.updateService(service, "ws");
			} else {
				routingContext.response().setStatusCode(400).end();
			}
		}
		routingContext.response().setStatusCode(204).end();
	}
	
}
