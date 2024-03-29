/*
 * This file is generated by jOOQ.
 */
package com.example.db.jooq.gen.tables.records;


import com.example.db.jooq.gen.tables.JLocation;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class LocationRecord extends UpdatableRecordImpl<LocationRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = -1889934727;

    /**
     * Setter for <code>ddd-sample.location.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>ddd-sample.location.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>ddd-sample.location.unlocode</code>.
     */
    public void setUnlocode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>ddd-sample.location.unlocode</code>.
     */
    public String getUnlocode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>ddd-sample.location.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>ddd-sample.location.name</code>.
     */
    public String getName() {
        return (String) get(2);
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
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return JLocation.LOCATION.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return JLocation.LOCATION.UNLOCODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return JLocation.LOCATION.NAME;
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
    public String component2() {
        return getUnlocode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getName();
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
    public String value2() {
        return getUnlocode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationRecord value2(String value) {
        setUnlocode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationRecord value3(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LocationRecord
     */
    public LocationRecord() {
        super(JLocation.LOCATION);
    }

    /**
     * Create a detached, initialised LocationRecord
     */
    public LocationRecord(Integer id, String unlocode, String name) {
        super(JLocation.LOCATION);

        set(0, id);
        set(1, unlocode);
        set(2, name);
    }
}
