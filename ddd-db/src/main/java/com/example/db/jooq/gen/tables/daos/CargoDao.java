/*
 * This file is generated by jOOQ.
 */
package com.example.db.jooq.gen.tables.daos;


import com.example.db.jooq.gen.tables.JCargo;
import com.example.db.jooq.gen.tables.pojos.CargoVo;
import com.example.db.jooq.gen.tables.records.CargoRecord;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * 荷物
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CargoDao extends DAOImpl<CargoRecord, CargoVo, Integer> {

    /**
     * Create a new CargoDao without any configuration
     */
    public CargoDao() {
        super(JCargo.CARGO, CargoVo.class);
    }

    /**
     * Create a new CargoDao with an attached configuration
     */
    public CargoDao(Configuration configuration) {
        super(JCargo.CARGO, CargoVo.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(CargoVo object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<CargoVo> fetchByJId(Integer... values) {
        return fetch(JCargo.CARGO.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public CargoVo fetchOneByJId(Integer value) {
        return fetchOne(JCargo.CARGO.ID, value);
    }

    /**
     * Fetch records that have <code>origin_id IN (values)</code>
     */
    public List<CargoVo> fetchByJOriginId(Integer... values) {
        return fetch(JCargo.CARGO.ORIGIN_ID, values);
    }

    /**
     * Fetch records that have <code>tracking_id IN (values)</code>
     */
    public List<CargoVo> fetchByJTrackingId(Integer... values) {
        return fetch(JCargo.CARGO.TRACKING_ID, values);
    }

    /**
     * Fetch a unique record that has <code>tracking_id = value</code>
     */
    public CargoVo fetchOneByJTrackingId(Integer value) {
        return fetchOne(JCargo.CARGO.TRACKING_ID, value);
    }

    /**
     * Fetch records that have <code>id_misdirected IN (values)</code>
     */
    public List<CargoVo> fetchByJIdMisdirected(Byte... values) {
        return fetch(JCargo.CARGO.ID_MISDIRECTED, values);
    }

    /**
     * Fetch records that have <code>eta IN (values)</code>
     */
    public List<CargoVo> fetchByJEta(LocalDateTime... values) {
        return fetch(JCargo.CARGO.ETA, values);
    }

    /**
     * Fetch records that have <code>calculated_at IN (values)</code>
     */
    public List<CargoVo> fetchByJCalculatedAt(LocalDateTime... values) {
        return fetch(JCargo.CARGO.CALCULATED_AT, values);
    }

    /**
     * Fetch records that have <code>unloaded_at_dest IN (values)</code>
     */
    public List<CargoVo> fetchByJUnloadedAtDest(Byte... values) {
        return fetch(JCargo.CARGO.UNLOADED_AT_DEST, values);
    }

    /**
     * Fetch records that have <code>routing_status IN (values)</code>
     */
    public List<CargoVo> fetchByJRoutingStatus(String... values) {
        return fetch(JCargo.CARGO.ROUTING_STATUS, values);
    }

    /**
     * Fetch records that have <code>next_expected_location_id IN (values)</code>
     */
    public List<CargoVo> fetchByJNextExpectedLocationId(Integer... values) {
        return fetch(JCargo.CARGO.NEXT_EXPECTED_LOCATION_ID, values);
    }

    /**
     * Fetch records that have <code>next_expected_handling_event_type IN (values)</code>
     */
    public List<CargoVo> fetchByJNextExpectedHandlingEventType(String... values) {
        return fetch(JCargo.CARGO.NEXT_EXPECTED_HANDLING_EVENT_TYPE, values);
    }

    /**
     * Fetch records that have <code>next_expected_voyage_id IN (values)</code>
     */
    public List<CargoVo> fetchByJNextExpectedVoyageId(Integer... values) {
        return fetch(JCargo.CARGO.NEXT_EXPECTED_VOYAGE_ID, values);
    }

    /**
     * Fetch records that have <code>transport_status IN (values)</code>
     */
    public List<CargoVo> fetchByJTransportStatus(String... values) {
        return fetch(JCargo.CARGO.TRANSPORT_STATUS, values);
    }

    /**
     * Fetch records that have <code>current_voyage_id IN (values)</code>
     */
    public List<CargoVo> fetchByJCurrentVoyageId(Integer... values) {
        return fetch(JCargo.CARGO.CURRENT_VOYAGE_ID, values);
    }

    /**
     * Fetch records that have <code>last_known_location_id IN (values)</code>
     */
    public List<CargoVo> fetchByJLastKnownLocationId(Integer... values) {
        return fetch(JCargo.CARGO.LAST_KNOWN_LOCATION_ID, values);
    }

    /**
     * Fetch records that have <code>last_event_id IN (values)</code>
     */
    public List<CargoVo> fetchByJLastEventId(Integer... values) {
        return fetch(JCargo.CARGO.LAST_EVENT_ID, values);
    }

    /**
     * Fetch records that have <code>spec_origin_id IN (values)</code>
     */
    public List<CargoVo> fetchByJSpecOriginId(Integer... values) {
        return fetch(JCargo.CARGO.SPEC_ORIGIN_ID, values);
    }

    /**
     * Fetch records that have <code>spec_destination_id IN (values)</code>
     */
    public List<CargoVo> fetchByJSpecDestinationId(Integer... values) {
        return fetch(JCargo.CARGO.SPEC_DESTINATION_ID, values);
    }

    /**
     * Fetch records that have <code>spec_arrival_deadline IN (values)</code>
     */
    public List<CargoVo> fetchByJSpecArrivalDeadline(LocalDateTime... values) {
        return fetch(JCargo.CARGO.SPEC_ARRIVAL_DEADLINE, values);
    }
}