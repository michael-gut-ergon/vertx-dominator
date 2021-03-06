/**
 * This class is generated by jOOQ
 */
package ch.ergon.storm.dominator.jooq.tables;


import ch.ergon.storm.dominator.jooq.Keys;
import ch.ergon.storm.dominator.jooq.Sab;
import ch.ergon.storm.dominator.jooq.enums.ServiceState;
import ch.ergon.storm.dominator.jooq.tables.records.ServiceRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Service extends TableImpl<ServiceRecord> {

    private static final long serialVersionUID = -1753678880;

    /**
     * The reference instance of <code>sab.service</code>
     */
    public static final Service SERVICE = new Service();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ServiceRecord> getRecordType() {
        return ServiceRecord.class;
    }

    /**
     * The column <code>sab.service.id</code>.
     */
    public final TableField<ServiceRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('service_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>sab.service.name</code>.
     */
    public final TableField<ServiceRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(250).nullable(false), this, "");

    /**
     * The column <code>sab.service.uuid</code>.
     */
    public final TableField<ServiceRecord, String> UUID = createField("uuid", org.jooq.impl.SQLDataType.VARCHAR.length(250).nullable(false), this, "");

    /**
     * The column <code>sab.service.ext_id</code>.
     */
    public final TableField<ServiceRecord, String> EXT_ID = createField("ext_id", org.jooq.impl.SQLDataType.VARCHAR.length(250), this, "");

    /**
     * The column <code>sab.service.customer</code>.
     */
    public final TableField<ServiceRecord, Integer> CUSTOMER = createField("customer", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>sab.service.service_parameter</code>.
     */
    public final TableField<ServiceRecord, Integer> SERVICE_PARAMETER = createField("service_parameter", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>sab.service.valid_from</code>.
     */
    public final TableField<ServiceRecord, Timestamp> VALID_FROM = createField("valid_from", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>sab.service.valid_until</code>.
     */
    public final TableField<ServiceRecord, Timestamp> VALID_UNTIL = createField("valid_until", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>sab.service.state</code>.
     */
    public final TableField<ServiceRecord, ServiceState> STATE = createField("state", org.jooq.util.postgres.PostgresDataType.VARCHAR.asEnumDataType(ServiceState.class), this, "");

    /**
     * The column <code>sab.service.inserted</code>.
     */
    public final TableField<ServiceRecord, Timestamp> INSERTED = createField("inserted", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>sab.service.useri</code>.
     */
    public final TableField<ServiceRecord, String> USERI = createField("useri", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>sab.service.updated</code>.
     */
    public final TableField<ServiceRecord, Timestamp> UPDATED = createField("updated", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>sab.service.useru</code>.
     */
    public final TableField<ServiceRecord, String> USERU = createField("useru", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * Create a <code>sab.service</code> table reference
     */
    public Service() {
        this("service", null);
    }

    /**
     * Create an aliased <code>sab.service</code> table reference
     */
    public Service(String alias) {
        this(alias, SERVICE);
    }

    private Service(String alias, Table<ServiceRecord> aliased) {
        this(alias, aliased, null);
    }

    private Service(String alias, Table<ServiceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Sab.SAB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ServiceRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SERVICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ServiceRecord> getPrimaryKey() {
        return Keys.SERVICE_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ServiceRecord>> getKeys() {
        return Arrays.<UniqueKey<ServiceRecord>>asList(Keys.SERVICE_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Service as(String alias) {
        return new Service(alias, this);
    }

    /**
     * Rename this table
     */
    public Service rename(String name) {
        return new Service(name, null);
    }
}
