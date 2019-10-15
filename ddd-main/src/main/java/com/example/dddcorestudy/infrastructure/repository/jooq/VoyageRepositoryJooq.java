package com.example.dddcorestudy.infrastructure.repository.jooq;

import com.example.db.jooq.gen.tables.JCurrierMovement;
import com.example.db.jooq.gen.tables.JLocation;
import com.example.db.jooq.gen.tables.JVoyage;
import com.example.db.jooq.gen.tables.JVoyageToCurrierMovement;
import com.example.db.jooq.gen.tables.records.CurrierMovementRecord;
import com.example.db.jooq.gen.tables.records.LocationRecord;
import com.example.db.jooq.gen.tables.records.VoyageRecord;
import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.model.location.UnLocode;
import com.example.dddcorestudy.domain.model.voyage.*;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class VoyageRepositoryJooq implements VoyageRepository {

    private final DSLContext dslContext;

    /**
     * Finds a voyage using voyage number.
     *
     * @param voyageNumber voyage number
     * @return The voyage
     */
    @Override
    public Voyage find(VoyageNumber voyageNumber) {
        final JVoyage jVoyage = JVoyage.VOYAGE;

        final VoyageRecord voyageRecord = dslContext
                .selectFrom(jVoyage)
                .where(jVoyage.VOYAGE_NUMBER.eq(voyageNumber.idString()))
                .fetchAny();

        if (voyageRecord == null) {
            return Voyage.NONE;
        }

        final JVoyageToCurrierMovement jVoyageToCurrierMovement = JVoyageToCurrierMovement.VOYAGE_TO_CURRIER_MOVEMENT;
        final JCurrierMovement jcurrierMovement = JCurrierMovement.CURRIER_MOVEMENT;
        final JLocation jLocation = JLocation.LOCATION;
        final JLocation dep = jLocation.as("dep");
        final JLocation arv = jLocation.as("arv");

        final List<Record> records = dslContext
                .select()
                .from(jVoyageToCurrierMovement)
                .join(jcurrierMovement).on(jVoyageToCurrierMovement.CURRIER_MOVEMENT_ID.eq(jcurrierMovement.ID))
                .join(dep).on(jcurrierMovement.DEPARTURE_LOCATION_ID.eq(dep.ID))
                .join(arv).on(jcurrierMovement.ARRIVAL_LOCATION_ID.eq(arv.ID))
                .where(jVoyageToCurrierMovement.VOYAGE_ID.eq(voyageRecord.getId()))
                .fetch();

        final List<CarrierMovement> carrierMovements = new ArrayList<>();

        for (Record r: records) {
            final CurrierMovementRecord currierMovementRecord = r.into(jcurrierMovement);
            final LocationRecord d = r.into(dep);
            final LocationRecord a = r.into(arv);
            final CarrierMovement carrierMovement = new CarrierMovement(
                    new Location(new UnLocode(d.getValue(dep.UNLOCODE)), d.getValue(dep.NAME)),
                    new Location(new UnLocode(a.getValue(arv.UNLOCODE)), a.getValue(arv.NAME)),
                    currierMovementRecord.getValue(jcurrierMovement.DEPARTURE_TIME),
                    currierMovementRecord.getValue(jcurrierMovement.ARRIVAL_TIME));
            carrierMovements.add(carrierMovement);
        }

        return new Voyage(new VoyageNumber(voyageRecord.getVoyageNumber()), new Schedule(carrierMovements));
    }

}
