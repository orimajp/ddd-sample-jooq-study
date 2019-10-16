/*
 * This file is generated by jOOQ.
 */
package com.example.db.jooq.gen.tables.daos;


import com.example.db.jooq.gen.tables.JItinerary;
import com.example.db.jooq.gen.tables.pojos.ItineraryVo;
import com.example.db.jooq.gen.tables.records.ItineraryRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ItineraryDao extends DAOImpl<ItineraryRecord, ItineraryVo, Integer> {

    /**
     * Create a new ItineraryDao without any configuration
     */
    public ItineraryDao() {
        super(JItinerary.ITINERARY, ItineraryVo.class);
    }

    /**
     * Create a new ItineraryDao with an attached configuration
     */
    public ItineraryDao(Configuration configuration) {
        super(JItinerary.ITINERARY, ItineraryVo.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(ItineraryVo object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<ItineraryVo> fetchByJId(Integer... values) {
        return fetch(JItinerary.ITINERARY.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public ItineraryVo fetchOneByJId(Integer value) {
        return fetchOne(JItinerary.ITINERARY.ID, value);
    }

    /**
     * Fetch records that have <code>cargo_id IN (values)</code>
     */
    public List<ItineraryVo> fetchByJCargoId(Integer... values) {
        return fetch(JItinerary.ITINERARY.CARGO_ID, values);
    }

    /**
     * Fetch records that have <code>leg_id IN (values)</code>
     */
    public List<ItineraryVo> fetchByJLegId(Integer... values) {
        return fetch(JItinerary.ITINERARY.LEG_ID, values);
    }
}