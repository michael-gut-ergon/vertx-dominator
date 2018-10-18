package ch.ergon.storm.dominator;

import org.junit.Test;

import ch.ergon.storm.dominator.jooq.enums.ServiceState;
import ch.ergon.storm.dominator.jooq.tables.pojos.Service;

import static org.junit.Assert.*;

public class ServiceTest {

    @Test public void testServiceCreation() {
        Service service = new Service();
        service.setState(ServiceState.INSERTED);
        assertTrue("service has to be active", service.getState() == ServiceState.INSERTED);
    }

}
