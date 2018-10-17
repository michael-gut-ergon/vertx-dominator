package ch.ergon.mg.om.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import ch.ergon.mg.om.OrderManagerApp;
import ch.ergon.mg.om.jooq.enums.ServiceState;
import ch.ergon.mg.om.jooq.tables.pojos.Customer;
import ch.ergon.mg.om.jooq.tables.pojos.Service;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

public class CustomerController {

	public static void getAll(RoutingContext routingContext) {
		List<Customer> customers = OrderManagerApp.DB.getCustomers();
		
		routingContext.response()
			.putHeader("content-type", "application/json; charset=utf-8")
			.end(Json.encodePrettily(customers));
	}
	
	public static void getCustomer(RoutingContext routingContext) {
		Customer customer = new Customer();
		
		String id = routingContext.request().getParam("id");
		if (id == null) {
			routingContext.response().setStatusCode(400).end();
		} else {
			Integer idAsInteger = Integer.valueOf(id);
			customer = OrderManagerApp.DB.getCustomer(idAsInteger);
			routingContext.response()
				.putHeader("content-type", "application/json; charset=utf-8")
				.end(Json.encodePrettily(customer));
		}
	}
	
	public static void addCustomer(RoutingContext routingContext) {
		final Service service = Json.decodeValue(routingContext.getBodyAsString(), Service.class);
		//routingContext.getCookie(name);
		Integer id = OrderManagerApp.DB.createService(service, "ws");
		service.setId(id);
		
		routingContext.response()
			.setStatusCode(201)
			.putHeader("content-type", "application/json; charset=utf-8")
			.end(Json.encodePrettily(service));
	}
	
	public static void deleteCustomer(RoutingContext routingContext) {
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
