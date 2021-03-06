/**
 * This class is generated by jOOQ
 */
package ch.ergon.storm.dominator.jooq.enums;


import ch.ergon.storm.dominator.jooq.Sab;

import javax.annotation.Generated;

import org.jooq.EnumType;
import org.jooq.Schema;


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
public enum OrderState implements EnumType {

    CREATED("CREATED"),

    IN_PRODUCTION("IN_PRODUCTION"),

    FINISHED("FINISHED"),

    DEPROVISIONING("DEPROVISIONING"),

    ABORTED("ABORTED");

    private final String literal;

    private OrderState(String literal) {
        this.literal = literal;
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
    public String getName() {
        return "order_state";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLiteral() {
        return literal;
    }
}
