/**
 * This class is generated by jOOQ
 */
package ch.ergon.storm.dominator.jooq.tables;


import ch.ergon.storm.dominator.jooq.Keys;
import ch.ergon.storm.dominator.jooq.Sab;
import ch.ergon.storm.dominator.jooq.tables.records.ServiceParameterBatchRecord;

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
public class ServiceParameterBatch extends TableImpl<ServiceParameterBatchRecord> {

    private static final long serialVersionUID = -160866729;

    /**
     * The reference instance of <code>sab.service_parameter_batch</code>
     */
    public static final ServiceParameterBatch SERVICE_PARAMETER_BATCH = new ServiceParameterBatch();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ServiceParameterBatchRecord> getRecordType() {
        return ServiceParameterBatchRecord.class;
    }

    /**
     * The column <code>sab.service_parameter_batch.id</code>.
     */
    public final TableField<ServiceParameterBatchRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('service_parameter_batch_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>sab.service_parameter_batch.created</code>.
     */
    public final TableField<ServiceParameterBatchRecord, Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>sab.service_parameter_batch</code> table reference
     */
    public ServiceParameterBatch() {
        this("service_parameter_batch", null);
    }

    /**
     * Create an aliased <code>sab.service_parameter_batch</code> table reference
     */
    public ServiceParameterBatch(String alias) {
        this(alias, SERVICE_PARAMETER_BATCH);
    }

    private ServiceParameterBatch(String alias, Table<ServiceParameterBatchRecord> aliased) {
        this(alias, aliased, null);
    }

    private ServiceParameterBatch(String alias, Table<ServiceParameterBatchRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ServiceParameterBatchRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SERVICE_PARAMETER_BATCH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ServiceParameterBatchRecord> getPrimaryKey() {
        return Keys.SERVICE_PARAMETER_BATCH_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ServiceParameterBatchRecord>> getKeys() {
        return Arrays.<UniqueKey<ServiceParameterBatchRecord>>asList(Keys.SERVICE_PARAMETER_BATCH_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ServiceParameterBatch as(String alias) {
        return new ServiceParameterBatch(alias, this);
    }

    /**
     * Rename this table
     */
    public ServiceParameterBatch rename(String name) {
        return new ServiceParameterBatch(name, null);
    }
}
