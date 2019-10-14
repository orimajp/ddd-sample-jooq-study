/*
 * This file is generated by jOOQ.
 */
package com.example.db.jooq.gen.tables.daos;


import com.example.db.jooq.gen.tables.JLeg;
import com.example.db.jooq.gen.tables.pojos.LegVo;
import com.example.db.jooq.gen.tables.records.LegRecord;

import java.sql.Timestamp;
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
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LegDao extends DAOImpl<LegRecord, LegVo, Integer> {

    /**
     * Create a new LegDao without any configuration
     */
    public LegDao() {
        super(JLeg.LEG, LegVo.class);
    }

    /**
     * Create a new LegDao with an attached configuration
     */
    public LegDao(Configuration configuration) {
        super(JLeg.LEG, LegVo.class, configuration);
    }

    @Override
    public Integer getId(LegVo object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<LegVo> fetchRangeOfJId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JLeg.LEG.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<LegVo> fetchByJId(Integer... values) {
        return fetch(JLeg.LEG.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public LegVo fetchOneByJId(Integer value) {
        return fetchOne(JLeg.LEG.ID, value);
    }

    /**
     * Fetch records that have <code>load_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<LegVo> fetchRangeOfJLoadTime(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(JLeg.LEG.LOAD_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>load_time IN (values)</code>
     */
    public List<LegVo> fetchByJLoadTime(Timestamp... values) {
        return fetch(JLeg.LEG.LOAD_TIME, values);
    }

    /**
     * Fetch records that have <code>unload_time BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<LegVo> fetchRangeOfJUnloadTime(Timestamp lowerInclusive, Timestamp upperInclusive) {
        return fetchRange(JLeg.LEG.UNLOAD_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>unload_time IN (values)</code>
     */
    public List<LegVo> fetchByJUnloadTime(Timestamp... values) {
        return fetch(JLeg.LEG.UNLOAD_TIME, values);
    }

    /**
     * Fetch records that have <code>voyage_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<LegVo> fetchRangeOfJVoyageId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JLeg.LEG.VOYAGE_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>voyage_id IN (values)</code>
     */
    public List<LegVo> fetchByJVoyageId(Integer... values) {
        return fetch(JLeg.LEG.VOYAGE_ID, values);
    }

    /**
     * Fetch records that have <code>load_location_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<LegVo> fetchRangeOfJLoadLocationId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JLeg.LEG.LOAD_LOCATION_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>load_location_id IN (values)</code>
     */
    public List<LegVo> fetchByJLoadLocationId(Integer... values) {
        return fetch(JLeg.LEG.LOAD_LOCATION_ID, values);
    }

    /**
     * Fetch records that have <code>unload_location_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<LegVo> fetchRangeOfJUnloadLocationId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(JLeg.LEG.UNLOAD_LOCATION_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>unload_location_id IN (values)</code>
     */
    public List<LegVo> fetchByJUnloadLocationId(Integer... values) {
        return fetch(JLeg.LEG.UNLOAD_LOCATION_ID, values);
    }
}