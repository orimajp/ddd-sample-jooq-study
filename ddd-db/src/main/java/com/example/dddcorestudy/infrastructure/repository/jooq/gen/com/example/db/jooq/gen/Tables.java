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
import com.example.db.jooq.gen.tables.JVoyage;
import com.example.db.jooq.gen.tables.JVoyageToCurrierMovement;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in ddd-sample
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * 荷物
     */
    public static final JCargo CARGO = com.example.db.jooq.gen.tables.JCargo.CARGO;

    /**
     * The table <code>ddd-sample.currier_movement</code>.
     */
    public static final JCurrierMovement CURRIER_MOVEMENT = com.example.db.jooq.gen.tables.JCurrierMovement.CURRIER_MOVEMENT;

    /**
     * The table <code>ddd-sample.handling_event</code>.
     */
    public static final JHandlingEvent HANDLING_EVENT = com.example.db.jooq.gen.tables.JHandlingEvent.HANDLING_EVENT;

    /**
     * The table <code>ddd-sample.itinerary</code>.
     */
    public static final JItinerary ITINERARY = com.example.db.jooq.gen.tables.JItinerary.ITINERARY;

    /**
     * The table <code>ddd-sample.leg</code>.
     */
    public static final JLeg LEG = com.example.db.jooq.gen.tables.JLeg.LEG;

    /**
     * The table <code>ddd-sample.location</code>.
     */
    public static final JLocation LOCATION = com.example.db.jooq.gen.tables.JLocation.LOCATION;

    /**
     * The table <code>ddd-sample.voyage</code>.
     */
    public static final JVoyage VOYAGE = com.example.db.jooq.gen.tables.JVoyage.VOYAGE;

    /**
     * The table <code>ddd-sample.voyage_to_currier_movement</code>.
     */
    public static final JVoyageToCurrierMovement VOYAGE_TO_CURRIER_MOVEMENT = com.example.db.jooq.gen.tables.JVoyageToCurrierMovement.VOYAGE_TO_CURRIER_MOVEMENT;
}
