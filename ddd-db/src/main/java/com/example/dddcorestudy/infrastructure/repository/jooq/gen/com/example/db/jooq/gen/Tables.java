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

import javax.annotation.Generated;


/**
 * Convenience access to all tables in ddd-sample
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * 荷物
     */
    public static final JCargo CARGO = JCargo.CARGO;

    /**
     * The table <code>ddd-sample.currier_movement</code>.
     */
    public static final JCurrierMovement CURRIER_MOVEMENT = JCurrierMovement.CURRIER_MOVEMENT;

    /**
     * The table <code>ddd-sample.handling_event</code>.
     */
    public static final JHandlingEvent HANDLING_EVENT = JHandlingEvent.HANDLING_EVENT;

    /**
     * The table <code>ddd-sample.itinerary</code>.
     */
    public static final JItinerary ITINERARY = JItinerary.ITINERARY;

    /**
     * The table <code>ddd-sample.leg</code>.
     */
    public static final JLeg LEG = JLeg.LEG;

    /**
     * The table <code>ddd-sample.location</code>.
     */
    public static final JLocation LOCATION = JLocation.LOCATION;

    /**
     * The table <code>ddd-sample.schedule</code>.
     */
    public static final JSchedule SCHEDULE = JSchedule.SCHEDULE;

    /**
     * The table <code>ddd-sample.vayage</code>.
     */
    public static final JVayage VAYAGE = JVayage.VAYAGE;
}
