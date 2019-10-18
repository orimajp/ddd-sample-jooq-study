package com.example.dddcorestudy.infrastructure.repository.jooq.assembler;

import com.example.db.jooq.gen.tables.JCurrierMovement;
import com.example.db.jooq.gen.tables.JLocation;
import com.example.db.jooq.gen.tables.records.CurrierMovementRecord;
import com.example.db.jooq.gen.tables.records.LocationRecord;
import com.example.dddcorestudy.domain.model.voyage.CarrierMovement;
import lombok.RequiredArgsConstructor;
import org.jooq.Record;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarrierMovementAssembler {

    private final LocationAssembler locationAssembler;

    public CarrierMovement createCarrierMovement(Record record, JCurrierMovement jCurrierMovement,
            JLocation jDepartureLocation, JLocation jArrivalLocation) {
        final CurrierMovementRecord currier = record.into(jCurrierMovement);
        final LocationRecord departure = record.into(jDepartureLocation);
        final LocationRecord arrival = record.into(jArrivalLocation);
        return new CarrierMovement(
                locationAssembler.createLocation(departure, jDepartureLocation),
                locationAssembler.createLocation(arrival, jArrivalLocation),
                currier.getValue(jCurrierMovement.DEPARTURE_TIME),
                currier.getValue(jCurrierMovement.ARRIVAL_TIME));
    }

}
