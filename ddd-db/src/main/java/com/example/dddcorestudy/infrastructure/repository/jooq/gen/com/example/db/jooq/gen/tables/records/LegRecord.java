/*
 * This file is generated by jOOQ.
 */
package com.example.db.jooq.gen.tables.records;


import com.example.db.jooq.gen.tables.JLeg;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
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
public class LegRecord extends UpdatableRecordImpl<LegRecord> implements Record6<Integer, Timestamp, Timestamp, Integer, Integer, Integer> {

    private static final long serialVersionUID = -1355236885;

    /**
     * Setter for <code>ddd-sample.leg.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>ddd-sample.leg.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>ddd-sample.leg.load_time</code>.
     */
    public void setLoadTime(Timestamp value) {
        set(1, value);
    }

    /**
     * Getter for <code>ddd-sample.leg.load_time</code>.
     */
    public Timestamp getLoadTime() {
        return (Timestamp) get(1);
    }

    /**
     * Setter for <code>ddd-sample.leg.unload_time</code>.
     */
    public void setUnloadTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>ddd-sample.leg.unload_time</code>.
     */
    public Timestamp getUnloadTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>ddd-sample.leg.voyage_id</code>.
     */
    public void setVoyageId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>ddd-sample.leg.voyage_id</code>.
     */
    public Integer getVoyageId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>ddd-sample.leg.load_location_id</code>.
     */
    public void setLoadLocationId(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>ddd-sample.leg.load_location_id</code>.
     */
    public Integer getLoadLocationId() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>ddd-sample.leg.unload_location_id</code>.
     */
    public void setUnloadLocationId(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>ddd-sample.leg.unload_location_id</code>.
     */
    public Integer getUnloadLocationId() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Timestamp, Timestamp, Integer, Integer, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, Timestamp, Timestamp, Integer, Integer, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return JLeg.LEG.ID;
    }

    @Override
    public Field<Timestamp> field2() {
        return JLeg.LEG.LOAD_TIME;
    }

    @Override
    public Field<Timestamp> field3() {
        return JLeg.LEG.UNLOAD_TIME;
    }

    @Override
    public Field<Integer> field4() {
        return JLeg.LEG.VOYAGE_ID;
    }

    @Override
    public Field<Integer> field5() {
        return JLeg.LEG.LOAD_LOCATION_ID;
    }

    @Override
    public Field<Integer> field6() {
        return JLeg.LEG.UNLOAD_LOCATION_ID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Timestamp component2() {
        return getLoadTime();
    }

    @Override
    public Timestamp component3() {
        return getUnloadTime();
    }

    @Override
    public Integer component4() {
        return getVoyageId();
    }

    @Override
    public Integer component5() {
        return getLoadLocationId();
    }

    @Override
    public Integer component6() {
        return getUnloadLocationId();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Timestamp value2() {
        return getLoadTime();
    }

    @Override
    public Timestamp value3() {
        return getUnloadTime();
    }

    @Override
    public Integer value4() {
        return getVoyageId();
    }

    @Override
    public Integer value5() {
        return getLoadLocationId();
    }

    @Override
    public Integer value6() {
        return getUnloadLocationId();
    }

    @Override
    public LegRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public LegRecord value2(Timestamp value) {
        setLoadTime(value);
        return this;
    }

    @Override
    public LegRecord value3(Timestamp value) {
        setUnloadTime(value);
        return this;
    }

    @Override
    public LegRecord value4(Integer value) {
        setVoyageId(value);
        return this;
    }

    @Override
    public LegRecord value5(Integer value) {
        setLoadLocationId(value);
        return this;
    }

    @Override
    public LegRecord value6(Integer value) {
        setUnloadLocationId(value);
        return this;
    }

    @Override
    public LegRecord values(Integer value1, Timestamp value2, Timestamp value3, Integer value4, Integer value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LegRecord
     */
    public LegRecord() {
        super(JLeg.LEG);
    }

    /**
     * Create a detached, initialised LegRecord
     */
    public LegRecord(Integer id, Timestamp loadTime, Timestamp unloadTime, Integer voyageId, Integer loadLocationId, Integer unloadLocationId) {
        super(JLeg.LEG);

        set(0, id);
        set(1, loadTime);
        set(2, unloadTime);
        set(3, voyageId);
        set(4, loadLocationId);
        set(5, unloadLocationId);
    }
}
