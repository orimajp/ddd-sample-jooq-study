/*
 * This file is generated by jOOQ.
 */
package com.example.db.jooq.gen.tables.records;


import com.example.db.jooq.gen.tables.JCargo;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record18;
import org.jooq.Row18;
import org.jooq.impl.UpdatableRecordImpl;


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
public class CargoRecord extends UpdatableRecordImpl<CargoRecord> implements Record18<Integer, Integer, Integer, Byte, LocalDateTime, LocalDateTime, Byte, String, Integer, String, Integer, String, Integer, Integer, Integer, Integer, Integer, LocalDateTime> {

    private static final long serialVersionUID = 381348541;

    /**
     * Setter for <code>ddd-sample.cargo.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>ddd-sample.cargo.origin_id</code>.
     */
    public void setOriginId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.origin_id</code>.
     */
    public Integer getOriginId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>ddd-sample.cargo.tracking_id</code>.
     */
    public void setTrackingId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.tracking_id</code>.
     */
    public Integer getTrackingId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>ddd-sample.cargo.id_misdirected</code>.
     */
    public void setIdMisdirected(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.id_misdirected</code>.
     */
    public Byte getIdMisdirected() {
        return (Byte) get(3);
    }

    /**
     * Setter for <code>ddd-sample.cargo.eta</code>.
     */
    public void setEta(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.eta</code>.
     */
    public LocalDateTime getEta() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>ddd-sample.cargo.calculated_at</code>.
     */
    public void setCalculatedAt(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.calculated_at</code>.
     */
    public LocalDateTime getCalculatedAt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>ddd-sample.cargo.unloaded_at_dest</code>.
     */
    public void setUnloadedAtDest(Byte value) {
        set(6, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.unloaded_at_dest</code>.
     */
    public Byte getUnloadedAtDest() {
        return (Byte) get(6);
    }

    /**
     * Setter for <code>ddd-sample.cargo.routing_status</code>.
     */
    public void setRoutingStatus(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.routing_status</code>.
     */
    public String getRoutingStatus() {
        return (String) get(7);
    }

    /**
     * Setter for <code>ddd-sample.cargo.next_expected_location_id</code>.
     */
    public void setNextExpectedLocationId(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.next_expected_location_id</code>.
     */
    public Integer getNextExpectedLocationId() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>ddd-sample.cargo.next_expected_handling_event_type</code>.
     */
    public void setNextExpectedHandlingEventType(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.next_expected_handling_event_type</code>.
     */
    public String getNextExpectedHandlingEventType() {
        return (String) get(9);
    }

    /**
     * Setter for <code>ddd-sample.cargo.next_expected_voyage_id</code>.
     */
    public void setNextExpectedVoyageId(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.next_expected_voyage_id</code>.
     */
    public Integer getNextExpectedVoyageId() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>ddd-sample.cargo.transport_status</code>.
     */
    public void setTransportStatus(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.transport_status</code>.
     */
    public String getTransportStatus() {
        return (String) get(11);
    }

    /**
     * Setter for <code>ddd-sample.cargo.current_voyage_id</code>.
     */
    public void setCurrentVoyageId(Integer value) {
        set(12, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.current_voyage_id</code>.
     */
    public Integer getCurrentVoyageId() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>ddd-sample.cargo.last_known_location_id</code>.
     */
    public void setLastKnownLocationId(Integer value) {
        set(13, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.last_known_location_id</code>.
     */
    public Integer getLastKnownLocationId() {
        return (Integer) get(13);
    }

    /**
     * Setter for <code>ddd-sample.cargo.last_event_id</code>.
     */
    public void setLastEventId(Integer value) {
        set(14, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.last_event_id</code>.
     */
    public Integer getLastEventId() {
        return (Integer) get(14);
    }

    /**
     * Setter for <code>ddd-sample.cargo.spec_origin_id</code>.
     */
    public void setSpecOriginId(Integer value) {
        set(15, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.spec_origin_id</code>.
     */
    public Integer getSpecOriginId() {
        return (Integer) get(15);
    }

    /**
     * Setter for <code>ddd-sample.cargo.spec_destination_id</code>.
     */
    public void setSpecDestinationId(Integer value) {
        set(16, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.spec_destination_id</code>.
     */
    public Integer getSpecDestinationId() {
        return (Integer) get(16);
    }

    /**
     * Setter for <code>ddd-sample.cargo.spec_arrival_deadline</code>.
     */
    public void setSpecArrivalDeadline(LocalDateTime value) {
        set(17, value);
    }

    /**
     * Getter for <code>ddd-sample.cargo.spec_arrival_deadline</code>.
     */
    public LocalDateTime getSpecArrivalDeadline() {
        return (LocalDateTime) get(17);
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
    // Record18 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<Integer, Integer, Integer, Byte, LocalDateTime, LocalDateTime, Byte, String, Integer, String, Integer, String, Integer, Integer, Integer, Integer, Integer, LocalDateTime> fieldsRow() {
        return (Row18) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<Integer, Integer, Integer, Byte, LocalDateTime, LocalDateTime, Byte, String, Integer, String, Integer, String, Integer, Integer, Integer, Integer, Integer, LocalDateTime> valuesRow() {
        return (Row18) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return JCargo.CARGO.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return JCargo.CARGO.ORIGIN_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return JCargo.CARGO.TRACKING_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field4() {
        return JCargo.CARGO.ID_MISDIRECTED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field5() {
        return JCargo.CARGO.ETA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field6() {
        return JCargo.CARGO.CALCULATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field7() {
        return JCargo.CARGO.UNLOADED_AT_DEST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return JCargo.CARGO.ROUTING_STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return JCargo.CARGO.NEXT_EXPECTED_LOCATION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return JCargo.CARGO.NEXT_EXPECTED_HANDLING_EVENT_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field11() {
        return JCargo.CARGO.NEXT_EXPECTED_VOYAGE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return JCargo.CARGO.TRANSPORT_STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field13() {
        return JCargo.CARGO.CURRENT_VOYAGE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field14() {
        return JCargo.CARGO.LAST_KNOWN_LOCATION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field15() {
        return JCargo.CARGO.LAST_EVENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field16() {
        return JCargo.CARGO.SPEC_ORIGIN_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field17() {
        return JCargo.CARGO.SPEC_DESTINATION_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field18() {
        return JCargo.CARGO.SPEC_ARRIVAL_DEADLINE;
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
        return getOriginId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getTrackingId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component4() {
        return getIdMisdirected();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component5() {
        return getEta();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component6() {
        return getCalculatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component7() {
        return getUnloadedAtDest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getRoutingStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component9() {
        return getNextExpectedLocationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getNextExpectedHandlingEventType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component11() {
        return getNextExpectedVoyageId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getTransportStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component13() {
        return getCurrentVoyageId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component14() {
        return getLastKnownLocationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component15() {
        return getLastEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component16() {
        return getSpecOriginId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component17() {
        return getSpecDestinationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component18() {
        return getSpecArrivalDeadline();
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
        return getOriginId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getTrackingId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value4() {
        return getIdMisdirected();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value5() {
        return getEta();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value6() {
        return getCalculatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value7() {
        return getUnloadedAtDest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getRoutingStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getNextExpectedLocationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getNextExpectedHandlingEventType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value11() {
        return getNextExpectedVoyageId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getTransportStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value13() {
        return getCurrentVoyageId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value14() {
        return getLastKnownLocationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value15() {
        return getLastEventId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value16() {
        return getSpecOriginId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value17() {
        return getSpecDestinationId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value18() {
        return getSpecArrivalDeadline();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value2(Integer value) {
        setOriginId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value3(Integer value) {
        setTrackingId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value4(Byte value) {
        setIdMisdirected(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value5(LocalDateTime value) {
        setEta(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value6(LocalDateTime value) {
        setCalculatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value7(Byte value) {
        setUnloadedAtDest(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value8(String value) {
        setRoutingStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value9(Integer value) {
        setNextExpectedLocationId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value10(String value) {
        setNextExpectedHandlingEventType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value11(Integer value) {
        setNextExpectedVoyageId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value12(String value) {
        setTransportStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value13(Integer value) {
        setCurrentVoyageId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value14(Integer value) {
        setLastKnownLocationId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value15(Integer value) {
        setLastEventId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value16(Integer value) {
        setSpecOriginId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value17(Integer value) {
        setSpecDestinationId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord value18(LocalDateTime value) {
        setSpecArrivalDeadline(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CargoRecord values(Integer value1, Integer value2, Integer value3, Byte value4, LocalDateTime value5, LocalDateTime value6, Byte value7, String value8, Integer value9, String value10, Integer value11, String value12, Integer value13, Integer value14, Integer value15, Integer value16, Integer value17, LocalDateTime value18) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CargoRecord
     */
    public CargoRecord() {
        super(JCargo.CARGO);
    }

    /**
     * Create a detached, initialised CargoRecord
     */
    public CargoRecord(Integer id, Integer originId, Integer trackingId, Byte idMisdirected, LocalDateTime eta, LocalDateTime calculatedAt, Byte unloadedAtDest, String routingStatus, Integer nextExpectedLocationId, String nextExpectedHandlingEventType, Integer nextExpectedVoyageId, String transportStatus, Integer currentVoyageId, Integer lastKnownLocationId, Integer lastEventId, Integer specOriginId, Integer specDestinationId, LocalDateTime specArrivalDeadline) {
        super(JCargo.CARGO);

        set(0, id);
        set(1, originId);
        set(2, trackingId);
        set(3, idMisdirected);
        set(4, eta);
        set(5, calculatedAt);
        set(6, unloadedAtDest);
        set(7, routingStatus);
        set(8, nextExpectedLocationId);
        set(9, nextExpectedHandlingEventType);
        set(10, nextExpectedVoyageId);
        set(11, transportStatus);
        set(12, currentVoyageId);
        set(13, lastKnownLocationId);
        set(14, lastEventId);
        set(15, specOriginId);
        set(16, specDestinationId);
        set(17, specArrivalDeadline);
    }
}
