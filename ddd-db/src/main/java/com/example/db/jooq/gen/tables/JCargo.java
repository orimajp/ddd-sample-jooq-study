/*
 * This file is generated by jOOQ.
 */
package com.example.db.jooq.gen.tables;


import com.example.db.jooq.gen.Indexes;
import com.example.db.jooq.gen.JDddSample;
import com.example.db.jooq.gen.Keys;
import com.example.db.jooq.gen.tables.records.CargoRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class JCargo extends TableImpl<CargoRecord> {

    private static final long serialVersionUID = 770552925;

    /**
     * The reference instance of <code>ddd-sample.cargo</code>
     */
    public static final JCargo CARGO = new JCargo();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CargoRecord> getRecordType() {
        return CargoRecord.class;
    }

    /**
     * The column <code>ddd-sample.cargo.id</code>.
     */
    public final TableField<CargoRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>ddd-sample.cargo.origin_id</code>.
     */
    public final TableField<CargoRecord, Integer> ORIGIN_ID = createField("origin_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>ddd-sample.cargo.tracking_id</code>.
     */
    public final TableField<CargoRecord, Integer> TRACKING_ID = createField("tracking_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>ddd-sample.cargo.id_misdirected</code>.
     */
    public final TableField<CargoRecord, Byte> ID_MISDIRECTED = createField("id_misdirected", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>ddd-sample.cargo.eta</code>.
     */
    public final TableField<CargoRecord, LocalDateTime> ETA = createField("eta", org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>ddd-sample.cargo.calculated_at</code>.
     */
    public final TableField<CargoRecord, LocalDateTime> CALCULATED_AT = createField("calculated_at", org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>ddd-sample.cargo.unloaded_at_dest</code>.
     */
    public final TableField<CargoRecord, Byte> UNLOADED_AT_DEST = createField("unloaded_at_dest", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>ddd-sample.cargo.routing_status</code>.
     */
    public final TableField<CargoRecord, String> ROUTING_STATUS = createField("routing_status", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>ddd-sample.cargo.next_expected_location_id</code>.
     */
    public final TableField<CargoRecord, Integer> NEXT_EXPECTED_LOCATION_ID = createField("next_expected_location_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>ddd-sample.cargo.next_expected_handling_event_type</code>.
     */
    public final TableField<CargoRecord, String> NEXT_EXPECTED_HANDLING_EVENT_TYPE = createField("next_expected_handling_event_type", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>ddd-sample.cargo.next_expected_voyage_id</code>.
     */
    public final TableField<CargoRecord, Integer> NEXT_EXPECTED_VOYAGE_ID = createField("next_expected_voyage_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>ddd-sample.cargo.transport_status</code>.
     */
    public final TableField<CargoRecord, String> TRANSPORT_STATUS = createField("transport_status", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>ddd-sample.cargo.current_voyage_id</code>.
     */
    public final TableField<CargoRecord, Integer> CURRENT_VOYAGE_ID = createField("current_voyage_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>ddd-sample.cargo.last_known_location_id</code>.
     */
    public final TableField<CargoRecord, Integer> LAST_KNOWN_LOCATION_ID = createField("last_known_location_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>ddd-sample.cargo.last_event_id</code>.
     */
    public final TableField<CargoRecord, Integer> LAST_EVENT_ID = createField("last_event_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>ddd-sample.cargo.spec_origin_id</code>.
     */
    public final TableField<CargoRecord, Integer> SPEC_ORIGIN_ID = createField("spec_origin_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>ddd-sample.cargo.spec_destination_id</code>.
     */
    public final TableField<CargoRecord, Integer> SPEC_DESTINATION_ID = createField("spec_destination_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>ddd-sample.cargo.spec_arrival_deadline</code>.
     */
    public final TableField<CargoRecord, LocalDateTime> SPEC_ARRIVAL_DEADLINE = createField("spec_arrival_deadline", org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * Create a <code>ddd-sample.cargo</code> table reference
     */
    public JCargo() {
        this(DSL.name("cargo"), null);
    }

    /**
     * Create an aliased <code>ddd-sample.cargo</code> table reference
     */
    public JCargo(String alias) {
        this(DSL.name(alias), CARGO);
    }

    /**
     * Create an aliased <code>ddd-sample.cargo</code> table reference
     */
    public JCargo(Name alias) {
        this(alias, CARGO);
    }

    private JCargo(Name alias, Table<CargoRecord> aliased) {
        this(alias, aliased, null);
    }

    private JCargo(Name alias, Table<CargoRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("荷物"));
    }

    public <O extends Record> JCargo(Table<O> child, ForeignKey<O, CargoRecord> key) {
        super(child, key, CARGO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return JDddSample.DDD_SAMPLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CARGO_CARGO_IDX_1, Indexes.CARGO_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<CargoRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CARGO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CargoRecord> getPrimaryKey() {
        return Keys.KEY_CARGO_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CargoRecord>> getKeys() {
        return Arrays.<UniqueKey<CargoRecord>>asList(Keys.KEY_CARGO_PRIMARY, Keys.KEY_CARGO_CARGO_IDX_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JCargo as(String alias) {
        return new JCargo(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JCargo as(Name alias) {
        return new JCargo(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JCargo rename(String name) {
        return new JCargo(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JCargo rename(Name name) {
        return new JCargo(name, null);
    }
}
