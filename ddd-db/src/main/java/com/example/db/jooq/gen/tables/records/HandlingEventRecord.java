/*
 * This file is generated by jOOQ.
 */
package com.example.db.jooq.gen.tables.records;


import com.example.db.jooq.gen.tables.JHandlingEvent;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


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
public class HandlingEventRecord extends UpdatableRecordImpl<HandlingEventRecord> implements Record7<Integer, Integer, Integer, Integer, LocalDateTime, Integer, String> {

    private static final long serialVersionUID = -1437428650;

    /**
     * Setter for <code>ddd-sample.handling_event.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>ddd-sample.handling_event.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>ddd-sample.handling_event.voyage_id</code>.
     */
    public void setVoyageId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>ddd-sample.handling_event.voyage_id</code>.
     */
    public Integer getVoyageId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>ddd-sample.handling_event.location_id</code>.
     */
    public void setLocationId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>ddd-sample.handling_event.location_id</code>.
     */
    public Integer getLocationId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>ddd-sample.handling_event.cargo_id</code>.
     */
    public void setCargoId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>ddd-sample.handling_event.cargo_id</code>.
     */
    public Integer getCargoId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>ddd-sample.handling_event.completion_time</code>.
     */
    public void setCompletionTime(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>ddd-sample.handling_event.completion_time</code>.
     */
    public LocalDateTime getCompletionTime() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>ddd-sample.handling_event.registration_time</code>.
     */
    public void setRegistrationTime(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>ddd-sample.handling_event.registration_time</code>.
     */
    public Integer getRegistrationTime() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>ddd-sample.handling_event.type</code>.
     */
    public void setType(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>ddd-sample.handling_event.type</code>.
     */
    public String getType() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Integer, Integer, Integer, LocalDateTime, Integer, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Integer, Integer, Integer, LocalDateTime, Integer, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return JHandlingEvent.HANDLING_EVENT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return JHandlingEvent.HANDLING_EVENT.VOYAGE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return JHandlingEvent.HANDLING_EVENT.LOCATION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return JHandlingEvent.HANDLING_EVENT.CARGO_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field5() {
        return JHandlingEvent.HANDLING_EVENT.COMPLETION_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return JHandlingEvent.HANDLING_EVENT.REGISTRATION_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return JHandlingEvent.HANDLING_EVENT.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getVoyageId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getLocationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getCargoId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component5() {
        return getCompletionTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getRegistrationTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getVoyageId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getLocationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getCargoId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value5() {
        return getCompletionTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getRegistrationTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlingEventRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlingEventRecord value2(Integer value) {
        setVoyageId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlingEventRecord value3(Integer value) {
        setLocationId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlingEventRecord value4(Integer value) {
        setCargoId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlingEventRecord value5(LocalDateTime value) {
        setCompletionTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlingEventRecord value6(Integer value) {
        setRegistrationTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlingEventRecord value7(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HandlingEventRecord values(Integer value1, Integer value2, Integer value3, Integer value4, LocalDateTime value5, Integer value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached HandlingEventRecord
     */
    public HandlingEventRecord() {
        super(JHandlingEvent.HANDLING_EVENT);
    }

    /**
     * Create a detached, initialised HandlingEventRecord
     */
    public HandlingEventRecord(Integer id, Integer voyageId, Integer locationId, Integer cargoId, LocalDateTime completionTime, Integer registrationTime, String type) {
        super(JHandlingEvent.HANDLING_EVENT);

        set(0, id);
        set(1, voyageId);
        set(2, locationId);
        set(3, cargoId);
        set(4, completionTime);
        set(5, registrationTime);
        set(6, type);
    }
}
