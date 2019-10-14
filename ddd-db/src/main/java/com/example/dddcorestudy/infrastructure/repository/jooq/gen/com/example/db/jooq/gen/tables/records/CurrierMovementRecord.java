/*
 * This file is generated by jOOQ.
 */
package com.example.db.jooq.gen.tables.records;


import com.example.db.jooq.gen.tables.JCurrierMovement;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


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
public class CurrierMovementRecord extends UpdatableRecordImpl<CurrierMovementRecord> implements Record5<Integer, Timestamp, Timestamp, Integer, Integer> {

    private static final long serialVersionUID = -1611383271;

    /**
     * Setter for <code>ddd-sample.currier_movement.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>ddd-sample.currier_movement.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>ddd-sample.currier_movement.arrival_time</code>.
     */
    public void setArrivalTime(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>ddd-sample.currier_movement.arrival_time</code>.
     */
    public Timestamp getArrivalTime() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>ddd-sample.currier_movement.departure_time</code>.
     */
    public void setDepartureTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>ddd-sample.currier_movement.departure_time</code>.
     */
    public Timestamp getDepartureTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>ddd-sample.currier_movement.arrival_location_id</code>.
     */
    public void setArrivalLocationId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>ddd-sample.currier_movement.arrival_location_id</code>.
     */
    public Integer getArrivalLocationId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>ddd-sample.currier_movement.departure_location_id</code>.
     */
    public void setDepartureLocationId(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>ddd-sample.currier_movement.departure_location_id</code>.
     */
    public Integer getDepartureLocationId() {
        return (Integer) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Timestamp, Timestamp, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, Timestamp, Timestamp, Integer, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return JCurrierMovement.CURRIER_MOVEMENT.ID;
    }

    @Override
    public Field<Timestamp> field2() {
        return JCurrierMovement.CURRIER_MOVEMENT.ARRIVAL_TIME;
    }

    @Override
    public Field<Timestamp> field3() {
        return JCurrierMovement.CURRIER_MOVEMENT.DEPARTURE_TIME;
    }

    @Override
    public Field<Integer> field4() {
        return JCurrierMovement.CURRIER_MOVEMENT.ARRIVAL_LOCATION_ID;
    }

    @Override
    public Field<Integer> field5() {
        return JCurrierMovement.CURRIER_MOVEMENT.DEPARTURE_LOCATION_ID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Timestamp component2() {
        return getArrivalTime();
    }

    @Override
    public Timestamp component3() {
        return getDepartureTime();
    }

    @Override
    public Integer component4() {
        return getArrivalLocationId();
    }

    @Override
    public Integer component5() {
        return getDepartureLocationId();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Timestamp value2() {
        return getArrivalTime();
    }

    @Override
    public Timestamp value3() {
        return getDepartureTime();
    }

    @Override
    public Integer value4() {
        return getArrivalLocationId();
    }

    @Override
    public Integer value5() {
        return getDepartureLocationId();
    }

    @Override
    public CurrierMovementRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public CurrierMovementRecord value2(Timestamp value) {
        setArrivalTime(value);
        return this;
    }

    @Override
    public CurrierMovementRecord value3(Timestamp value) {
        setDepartureTime(value);
        return this;
    }

    @Override
    public CurrierMovementRecord value4(Integer value) {
        setArrivalLocationId(value);
        return this;
    }

    @Override
    public CurrierMovementRecord value5(Integer value) {
        setDepartureLocationId(value);
        return this;
    }

    @Override
    public CurrierMovementRecord values(Integer value1, Timestamp value2, Timestamp value3, Integer value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CurrierMovementRecord
     */
    public CurrierMovementRecord() {
        super(JCurrierMovement.CURRIER_MOVEMENT);
    }

    /**
     * Create a detached, initialised CurrierMovementRecord
     */
    public CurrierMovementRecord(Integer id, Timestamp arrivalTime, Timestamp departureTime, Integer arrivalLocationId, Integer departureLocationId) {
        super(JCurrierMovement.CURRIER_MOVEMENT);

        set(0, id);
        set(1, arrivalTime);
        set(2, departureTime);
        set(3, arrivalLocationId);
        set(4, departureLocationId);
    }
}