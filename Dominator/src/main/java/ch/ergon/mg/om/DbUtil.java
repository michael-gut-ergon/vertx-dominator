package ch.ergon.mg.om;

import static ch.ergon.mg.om.jooq.Tables.CUSTOMER;
import static ch.ergon.mg.om.jooq.Tables.FACTORY;
import static ch.ergon.mg.om.jooq.Tables.PRODUCT;
import static ch.ergon.mg.om.jooq.Tables.SERVICE;
import static ch.ergon.mg.om.jooq.Tables.SERVICE_ORDER;
import static ch.ergon.mg.om.jooq.Tables.SERVICE_PARAMETER;
import static ch.ergon.mg.om.jooq.Tables.SERVICE_PARAMETER_BATCH;
import static ch.ergon.mg.om.jooq.Tables.SERVICE_PRODUCTION;
import static ch.ergon.mg.om.jooq.Tables.SERVICE_HISTORY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import ch.ergon.mg.om.jooq.tables.ServiceHistory;
import ch.ergon.mg.om.jooq.tables.pojos.Customer;
import ch.ergon.mg.om.jooq.tables.pojos.Factory;
import ch.ergon.mg.om.jooq.tables.pojos.Product;
import ch.ergon.mg.om.jooq.tables.pojos.Service;
import ch.ergon.mg.om.jooq.tables.pojos.ServiceOrder;
import ch.ergon.mg.om.jooq.tables.pojos.ServiceParameter;
import ch.ergon.mg.om.jooq.tables.pojos.ServiceParameterBatch;
import ch.ergon.mg.om.jooq.tables.pojos.ServiceProduction;
import ch.ergon.mg.om.jooq.tables.records.ServiceRecord;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class DbUtil {
	public static final Logger LOGGER = LoggerFactory.getLogger(DbUtil.class);
	private DSLContext sql;
    private Connection conn;
	
	public DbUtil(Configuration conf) {
        try {
        	LOGGER.info("Connect to database: "+conf.getDatabase().getUrl());
			Class.forName(conf.getDatabase().getDriverClass()).newInstance();
			conn = DriverManager.getConnection(conf.getDatabase().getUrl(), conf.getDatabase().getUsername(), conf.getDatabase().getPassword());
	        sql = DSL.using(conn, SQLDialect.valueOf(conf.getDatabase().getDialect()));
		} catch (InstantiationException|IllegalAccessException|SQLException e) {
			LOGGER.error("DB connection error "+e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			LOGGER.error("Resource not found "+e.getMessage());
			e.printStackTrace();
		} 
    }
    
    public void closeConnection() throws SQLException {
    	if (conn != null) {
    		conn.close();
    	}
    }
    
    public List<Service> getServices() {
    	List<Service> services = new ArrayList<Service>();
	    try {
	    	LOGGER.info("getServices");
	    	services = sql.select()
	    			.from(SERVICE)
	    			.fetchInto(Service.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getServices Exception "+e.getMessage());
	    }
	    
	    return services;
    }
    
    public Service getService(Integer id) {
    	Service service = null;
	    try {
	    	LOGGER.info("getService "+id);
	    	service = sql.select()
	    			.from(SERVICE)
	    			.where(Arrays.asList(SERVICE.ID.eq(id)))
	    			.fetchAny().into(Service.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getService Exception "+e.getMessage());
	    }
	    
	    return service;
    }
    
    public Integer createService(Service service, String user) {
	    try {
	    	LOGGER.info("createService["+user+"] "+service.getName()+" ("+service.getState()+")");
	    	Date now = new Date();
			ServiceRecord rec = sql.insertInto(SERVICE, SERVICE.NAME, SERVICE.UUID, 
					SERVICE.EXT_ID, SERVICE.SERVICE_PARAMETER, SERVICE.STATE, 
					SERVICE.VALID_FROM, SERVICE.INSERTED, SERVICE.USERI)
			      .values(service.getName(), service.getUuid(), service.getExtId(),
			    		  service.getServiceParameter(), service.getState(), 
			    		  service.getValidFrom(), new Timestamp(now.getTime()), user)
			      .returning(SERVICE.ID)
			      .fetchOne();
			
			return rec.getValue(SERVICE.ID);
	    } catch (Exception e) {
	    	LOGGER.warn("createService Exception "+e.getMessage());
	    }
	    
	    return -1;
    }
    
    public Boolean updateService(Service service, String user) {
	    try {
	    	LOGGER.info("updateService["+user+"] "+service.getName()+" ("+service.getState()+")");
	    	Date now = new Date();
	    	Service oldPhone = getService(service.getId());
	    	if (oldPhone != null) {
	    		doUpdateService(service, user, now);
    			return true;
	    	} 
	    } catch (Exception e) {
	    	LOGGER.warn("updateService Exception "+e.getMessage());
	    }
	    
	    return false;
    }
    
    private void doUpdateService(Service service, String user, Date now) {
		sql.update(SERVICE)
			.set(SERVICE.NAME, service.getName())
			.set(SERVICE.UUID, service.getUuid())
			.set(SERVICE.EXT_ID, service.getExtId())
			.set(SERVICE.SERVICE_PARAMETER, service.getServiceParameter())
			.set(SERVICE.STATE, service.getState())
			.set(SERVICE.UPDATED, new Timestamp(now.getTime()))
			.set(SERVICE.USERU, user)
			.where(Arrays.asList(SERVICE.ID.equal(service.getId())))
			.execute();
    }
    
    public List<Product> getProducts() {
    	List<Product> products = new ArrayList<Product>();
	    try {
	    	LOGGER.info("getProducts");
	    	products = sql.select()
	    			.from(PRODUCT)
	    			.fetchInto(Product.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getProducts Exception "+e.getMessage());
	    }
	    
	    return products;
    }
    
    public Product getProduct(Integer id) {
    	Product product = null;
	    try {
	    	LOGGER.info("getProduct "+id);
	    	product = sql.select()
	    			.from(PRODUCT)
	    			.where(Arrays.asList(PRODUCT.ID.eq(id)))
	    			.fetchAny().into(Product.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getProduct Exception "+e.getMessage());
	    }
	    
	    return product;
    }
    
    public List<Customer> getCustomers() {
    	List<Customer> customers = new ArrayList<Customer>();
	    try {
	    	LOGGER.info("getCustomers");
	    	customers = sql.select()
	    			.from(CUSTOMER)
	    			.fetchInto(Customer.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getCustomers Exception "+e.getMessage());
	    }
	    
	    return customers;
    }
    
    public Customer getCustomer(Integer id) {
    	Customer customer = null;
	    try {
	    	LOGGER.info("getCustomer "+id);
	    	customer = sql.select()
	    			.from(CUSTOMER)
	    			.where(Arrays.asList(CUSTOMER.ID.eq(id)))
	    			.fetchAny().into(Customer.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getCustomer Exception "+e.getMessage());
	    }
	    
	    return customer;
    }
    
    public List<ServiceOrder> getServiceOrders() {
    	List<ServiceOrder> orders = new ArrayList<ServiceOrder>();
	    try {
	    	LOGGER.info("getServiceOrders");
	    	orders = sql.select()
	    			.from(SERVICE_ORDER)
	    			.fetchInto(ServiceOrder.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getServiceOrders Exception "+e.getMessage());
	    }
	    
	    return orders;
    }
    
    public ServiceOrder getServiceOrder(Integer id) {
    	ServiceOrder order = null;
	    try {
	    	LOGGER.info("getServiceOrder "+id);
	    	order = sql.select()
	    			.from(SERVICE_ORDER)
	    			.where(Arrays.asList(SERVICE_ORDER.ID.eq(id)))
	    			.fetchAny().into(ServiceOrder.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getServiceOrder Exception "+e.getMessage());
	    }
	    
	    return order;
    }
    
    public List<ServiceProduction> getServiceProductions() {
    	List<ServiceProduction> productions = new ArrayList<ServiceProduction>();
	    try {
	    	LOGGER.info("getServiceProductions");
	    	productions = sql.select()
	    			.from(SERVICE_PRODUCTION)
	    			.fetchInto(ServiceProduction.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getServiceProductions Exception "+e.getMessage());
	    }
	    
	    return productions;
    }
    
    public ServiceProduction getServiceProduction(Integer id) {
    	ServiceProduction production = null;
	    try {
	    	LOGGER.info("getServiceProduction "+id);
	    	production = sql.select()
	    			.from(SERVICE_PRODUCTION)
	    			.where(Arrays.asList(SERVICE_PRODUCTION.ID.eq(id)))
	    			.fetchAny().into(ServiceProduction.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getServiceProduction Exception "+e.getMessage());
	    }
	    
	    return production;
    }
    
    public List<ServiceHistory> getServiceHistorys(Integer id) {
    	List<ServiceHistory> histories = new ArrayList<ServiceHistory>();
	    try {
	    	LOGGER.info("getServiceHistorys");
	    	histories = sql.select()
	    			.from(SERVICE_HISTORY)
	    			.where(Arrays.asList(SERVICE_HISTORY.SERVICE.eq(id)))
	    			.fetchInto(ServiceHistory.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getServiceHistorys Exception "+e.getMessage());
	    }
	    
	    return histories;
    }
	    
    public List<ServiceParameterBatch> getServiceParameterBatchs() {
    	List<ServiceParameterBatch> orders = new ArrayList<ServiceParameterBatch>();
	    try {
	    	LOGGER.info("getServiceParameterBatchs");
	    	orders = sql.select()
	    			.from(SERVICE_PARAMETER_BATCH)
	    			.fetchInto(ServiceParameterBatch.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getServiceParameterBatchs Exception "+e.getMessage());
	    }
	    
	    return orders;
    }
    
    public ServiceParameterBatch getServiceParameterBatch(Integer id) {
    	ServiceParameterBatch factory = null;
	    try {
	    	LOGGER.info("getServiceParameterBatch "+id);
	    	factory = sql.select()
	    			.from(SERVICE_PARAMETER_BATCH)
	    			.where(Arrays.asList(SERVICE_PARAMETER_BATCH.ID.eq(id)))
	    			.fetchAny().into(ServiceParameterBatch.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getServiceParameterBatch Exception "+e.getMessage());
	    }
	    
	    return factory;
    }
    
    public List<ServiceParameter> getServiceParameters(Integer id) {
    	List<ServiceParameter> parameters = new ArrayList<ServiceParameter>();
	    try {
	    	LOGGER.info("getServiceParameters");
	    	parameters = sql.select()
	    			.from(SERVICE_PARAMETER)
	    			.where(Arrays.asList(SERVICE_PARAMETER.SERVICE_PARAMETER_BATCH.eq(id)))
	    			.fetchInto(ServiceParameter.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getServiceParameters Exception "+e.getMessage());
	    }
	    
	    return parameters;
    }
    
    public List<Factory> getFactories() {
    	List<Factory> factories = new ArrayList<Factory>();
	    try {
	    	LOGGER.info("getFactories");
	    	factories = sql.select()
	    			.from(FACTORY)
	    			.fetchInto(Factory.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getFactories Exception "+e.getMessage());
	    }
	    
	    return factories;
    }
    
    public Factory getFactory(Integer id) {
    	Factory factory = null;
	    try {
	    	LOGGER.info("getFactory "+id);
	    	factory = sql.select()
	    			.from(FACTORY)
	    			.where(Arrays.asList(FACTORY.ID.eq(id)))
	    			.fetchAny().into(Factory.class);	        
	    } catch (Exception e) {
	    	LOGGER.warn("getFactory Exception "+e.getMessage());
	    }
	    
	    return factory;
    }

}
