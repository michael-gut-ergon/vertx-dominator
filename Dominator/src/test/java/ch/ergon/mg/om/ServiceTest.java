package ch.ergon.mg.om;

import org.junit.Test;

import ch.ergon.mg.om.jooq.enums.ServiceState;
import ch.ergon.mg.om.jooq.tables.pojos.Service;

import static org.junit.Assert.*;

public class ServiceTest {

    @Test public void testServiceCreation() {
        Service service = new Service();
        service.setState(ServiceState.INSERTED);
        assertTrue("service has to be active", service.getState() == ServiceState.INSERTED);
    }

}
