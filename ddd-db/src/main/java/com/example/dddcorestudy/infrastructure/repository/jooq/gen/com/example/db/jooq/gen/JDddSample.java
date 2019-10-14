/*
 * This file is generated by jOOQ.
 */
package com.example.db.jooq.gen;


import com.example.db.jooq.gen.tables.JCargo;
import com.example.db.jooq.gen.tables.JCurrierMovement;
import com.example.db.jooq.gen.tables.JHandlingEvent;
import com.example.db.jooq.gen.tables.JItinerary;
import com.example.db.jooq.gen.tables.JLeg;
import com.example.db.jooq.gen.tables.JLocation;
import com.example.db.jooq.gen.tables.JSchedule;
import com.example.db.jooq.gen.tables.JVayage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JDddSample extends SchemaImpl {

    private static final long serialVersionUID = 1899961373;

    /**
     * The reference instance of <code>ddd-sample</code>
     */
    public static final JDddSample DDD_SAMPLE = new JDddSample();

    /**
     * 荷物
     */
    public final JCargo CARGO = com.example.db.jooq.gen.tables.JCargo.CARGO;

    /**
     * The table <code>ddd-sample.currier_movement</code>.
     */
    public final JCurrierMovement CURRIER_MOVEMENT = com.example.db.jooq.gen.tables.JCurrierMovement.CURRIER_MOVEMENT;

    /**
     * The table <code>ddd-sample.handling_event</code>.
     */
    public final JHandlingEvent HANDLING_EVENT = com.example.db.jooq.gen.tables.JHandlingEvent.HANDLING_EVENT;

    /**
     * The table <code>ddd-sample.itinerary</code>.
     */
    public final JItinerary ITINERARY = com.example.db.jooq.gen.tables.JItinerary.ITINERARY;

    /**
     * The table <code>ddd-sample.leg</code>.
     */
    public final JLeg LEG = com.example.db.jooq.gen.tables.JLeg.LEG;

    /**
     * The table <code>ddd-sample.location</code>.
     */
    public final JLocation LOCATION = com.example.db.jooq.gen.tables.JLocation.LOCATION;

    /**
     * The table <code>ddd-sample.schedule</code>.
     */
    public final JSchedule SCHEDULE = com.example.db.jooq.gen.tables.JSchedule.SCHEDULE;

    /**
     * The table <code>ddd-sample.vayage</code>.
     */
    public final JVayage VAYAGE = com.example.db.jooq.gen.tables.JVayage.VAYAGE;

    /**
     * No further instances allowed
     */
    private JDddSample() {
        super("ddd-sample", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            JCargo.CARGO,
            JCurrierMovement.CURRIER_MOVEMENT,
            JHandlingEvent.HANDLING_EVENT,
            JItinerary.ITINERARY,
            JLeg.LEG,
            JLocation.LOCATION,
            JSchedule.SCHEDULE,
            JVayage.VAYAGE);
    }
}