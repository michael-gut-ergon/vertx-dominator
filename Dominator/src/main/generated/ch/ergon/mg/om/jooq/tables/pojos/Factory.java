/**
 * This class is generated by jOOQ
 */
package ch.ergon.mg.om.jooq.tables.pojos;


import ch.ergon.mg.om.jooq.enums.FactoryParameterType;
import ch.ergon.mg.om.jooq.enums.FactoryType;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Factory implements Serializable {

    private static final long serialVersionUID = 469263145;

    private Integer              id;
    private String               name;
    private FactoryType          factoryType;
    private FactoryParameterType parameterType;
    private String               server;
    private Integer              port;
    private String               createUrl;
    private String               cancelUrl;
    private String               activateUrl;
    private String               suspendUrl;
    private String               updateUrl;
    private String               monitoringUrl;
    private Integer              monitoringPort;
    private Timestamp            inserted;
    private String               useri;
    private Timestamp            updated;
    private String               useru;

    public Factory() {}

    public Factory(Factory value) {
        this.id = value.id;
        this.name = value.name;
        this.factoryType = value.factoryType;
        this.parameterType = value.parameterType;
        this.server = value.server;
        this.port = value.port;
        this.createUrl = value.createUrl;
        this.cancelUrl = value.cancelUrl;
        this.activateUrl = value.activateUrl;
        this.suspendUrl = value.suspendUrl;
        this.updateUrl = value.updateUrl;
        this.monitoringUrl = value.monitoringUrl;
        this.monitoringPort = value.monitoringPort;
        this.inserted = value.inserted;
        this.useri = value.useri;
        this.updated = value.updated;
        this.useru = value.useru;
    }

    public Factory(
        Integer              id,
        String               name,
        FactoryType          factoryType,
        FactoryParameterType parameterType,
        String               server,
        Integer              port,
        String               createUrl,
        String               cancelUrl,
        String               activateUrl,
        String               suspendUrl,
        String               updateUrl,
        String               monitoringUrl,
        Integer              monitoringPort,
        Timestamp            inserted,
        String               useri,
        Timestamp            updated,
        String               useru
    ) {
        this.id = id;
        this.name = name;
        this.factoryType = factoryType;
        this.parameterType = parameterType;
        this.server = server;
        this.port = port;
        this.createUrl = createUrl;
        this.cancelUrl = cancelUrl;
        this.activateUrl = activateUrl;
        this.suspendUrl = suspendUrl;
        this.updateUrl = updateUrl;
        this.monitoringUrl = monitoringUrl;
        this.monitoringPort = monitoringPort;
        this.inserted = inserted;
        this.useri = useri;
        this.updated = updated;
        this.useru = useru;
    }

    public Integer getId() {
        return this.id;
    }

    public Factory setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Factory setName(String name) {
        this.name = name;
        return this;
    }

    public FactoryType getFactoryType() {
        return this.factoryType;
    }

    public Factory setFactoryType(FactoryType factoryType) {
        this.factoryType = factoryType;
        return this;
    }

    public FactoryParameterType getParameterType() {
        return this.parameterType;
    }

    public Factory setParameterType(FactoryParameterType parameterType) {
        this.parameterType = parameterType;
        return this;
    }

    public String getServer() {
        return this.server;
    }

    public Factory setServer(String server) {
        this.server = server;
        return this;
    }

    public Integer getPort() {
        return this.port;
    }

    public Factory setPort(Integer port) {
        this.port = port;
        return this;
    }

    public String getCreateUrl() {
        return this.createUrl;
    }

    public Factory setCreateUrl(String createUrl) {
        this.createUrl = createUrl;
        return this;
    }

    public String getCancelUrl() {
        return this.cancelUrl;
    }

    public Factory setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
        return this;
    }

    public String getActivateUrl() {
        return this.activateUrl;
    }

    public Factory setActivateUrl(String activateUrl) {
        this.activateUrl = activateUrl;
        return this;
    }

    public String getSuspendUrl() {
        return this.suspendUrl;
    }

    public Factory setSuspendUrl(String suspendUrl) {
        this.suspendUrl = suspendUrl;
        return this;
    }

    public String getUpdateUrl() {
        return this.updateUrl;
    }

    public Factory setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
        return this;
    }

    public String getMonitoringUrl() {
        return this.monitoringUrl;
    }

    public Factory setMonitoringUrl(String monitoringUrl) {
        this.monitoringUrl = monitoringUrl;
        return this;
    }

    public Integer getMonitoringPort() {
        return this.monitoringPort;
    }

    public Factory setMonitoringPort(Integer monitoringPort) {
        this.monitoringPort = monitoringPort;
        return this;
    }

    public Timestamp getInserted() {
        return this.inserted;
    }

    public Factory setInserted(Timestamp inserted) {
        this.inserted = inserted;
        return this;
    }

    public String getUseri() {
        return this.useri;
    }

    public Factory setUseri(String useri) {
        this.useri = useri;
        return this;
    }

    public Timestamp getUpdated() {
        return this.updated;
    }

    public Factory setUpdated(Timestamp updated) {
        this.updated = updated;
        return this;
    }

    public String getUseru() {
        return this.useru;
    }

    public Factory setUseru(String useru) {
        this.useru = useru;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Factory (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(factoryType);
        sb.append(", ").append(parameterType);
        sb.append(", ").append(server);
        sb.append(", ").append(port);
        sb.append(", ").append(createUrl);
        sb.append(", ").append(cancelUrl);
        sb.append(", ").append(activateUrl);
        sb.append(", ").append(suspendUrl);
        sb.append(", ").append(updateUrl);
        sb.append(", ").append(monitoringUrl);
        sb.append(", ").append(monitoringPort);
        sb.append(", ").append(inserted);
        sb.append(", ").append(useri);
        sb.append(", ").append(updated);
        sb.append(", ").append(useru);

        sb.append(")");
        return sb.toString();
    }
}
