/*
 * This file is generated by jOOQ.
 */
package com.example.db.jooq.gen.tables;


import com.example.db.jooq.gen.Indexes;
import com.example.db.jooq.gen.JDddSample;
import com.example.db.jooq.gen.Keys;
import com.example.db.jooq.gen.tables.records.CurrierMovementRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class JCurrierMovement extends TableImpl<CurrierMovementRecord> {

    private static final long serialVersionUID = -1378420443;

    /**
     * The reference instance of <code>ddd-sample.currier_movement</code>
     */
    public static final JCurrierMovement CURRIER_MOVEMENT = new JCurrierMovement();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CurrierMovementRecord> getRecordType() {
        return CurrierMovementRecord.class;
    }

    /**
     * The column <code>ddd-sample.currier_movement.id</code>.
     */
    public final TableField<CurrierMovementRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>ddd-sample.currier_movement.arrival_time</code>.
     */
    public final TableField<CurrierMovementRecord, Timestamp> ARRIVAL_TIME = createField(DSL.name("arrival_time"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>ddd-sample.currier_movement.departure_time</code>.
     */
    public final TableField<CurrierMovementRecord, Timestamp> DEPARTURE_TIME = createField(DSL.name("departure_time"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>ddd-sample.currier_movement.arrival_location_id</code>.
     */
    public final TableField<CurrierMovementRecord, Integer> ARRIVAL_LOCATION_ID = createField(DSL.name("arrival_location_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>ddd-sample.currier_movement.departure_location_id</code>.
     */
    public final TableField<CurrierMovementRecord, Integer> DEPARTURE_LOCATION_ID = createField(DSL.name("departure_location_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>ddd-sample.currier_movement</code> table reference
     */
    public JCurrierMovement() {
        this(DSL.name("currier_movement"), null);
    }

    /**
     * Create an aliased <code>ddd-sample.currier_movement</code> table reference
     */
    public JCurrierMovement(String alias) {
        this(DSL.name(alias), CURRIER_MOVEMENT);
    }

    /**
     * Create an aliased <code>ddd-sample.currier_movement</code> table reference
     */
    public JCurrierMovement(Name alias) {
        this(alias, CURRIER_MOVEMENT);
    }

    private JCurrierMovement(Name alias, Table<CurrierMovementRecord> aliased) {
        this(alias, aliased, null);
    }

    private JCurrierMovement(Name alias, Table<CurrierMovementRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> JCurrierMovement(Table<O> child, ForeignKey<O, CurrierMovementRecord> key) {
        super(child, key, CURRIER_MOVEMENT);
    }

    @Override
    public Schema getSchema() {
        return JDddSample.DDD_SAMPLE;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CURRIER_MOVEMENT_PRIMARY);
    }

    @Override
    public Identity<CurrierMovementRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CURRIER_MOVEMENT;
    }

    @Override
    public UniqueKey<CurrierMovementRecord> getPrimaryKey() {
        return Keys.KEY_CURRIER_MOVEMENT_PRIMARY;
    }

    @Override
    public List<UniqueKey<CurrierMovementRecord>> getKeys() {
        return Arrays.<UniqueKey<CurrierMovementRecord>>asList(Keys.KEY_CURRIER_MOVEMENT_PRIMARY);
    }

    @Override
    public JCurrierMovement as(String alias) {
        return new JCurrierMovement(DSL.name(alias), this);
    }

    @Override
    public JCurrierMovement as(Name alias) {
        return new JCurrierMovement(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JCurrierMovement rename(String name) {
        return new JCurrierMovement(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JCurrierMovement rename(Name name) {
        return new JCurrierMovement(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Timestamp, Timestamp, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
