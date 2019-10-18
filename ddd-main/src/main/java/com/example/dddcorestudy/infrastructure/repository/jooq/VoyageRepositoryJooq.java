package com.example.dddcorestudy.infrastructure.repository.jooq;

import com.example.db.jooq.gen.tables.JCurrierMovement;
import com.example.db.jooq.gen.tables.JLocation;
import com.example.db.jooq.gen.tables.JVoyage;
import com.example.db.jooq.gen.tables.JVoyageToCurrierMovement;
import com.example.dddcorestudy.domain.model.voyage.CarrierMovement;
import com.example.dddcorestudy.domain.model.voyage.Schedule;
import com.example.dddcorestudy.domain.model.voyage.Voyage;
import com.example.dddcorestudy.domain.model.voyage.VoyageNumber;
import com.example.dddcorestudy.domain.model.voyage.VoyageRepository;
import com.example.dddcorestudy.infrastructure.repository.jooq.assembler.CarrierMovementAssembler;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class VoyageRepositoryJooq implements VoyageRepository {

    private final DSLContext dslContext;
    private final CarrierMovementAssembler carrierMovementAssembler;

    /**
     * Finds a voyage using voyage number.
     *
     * @param voyageNumber voyage number
     * @return The voyage
     */
    @Override
    public Voyage find(VoyageNumber voyageNumber) {
        final JVoyage jVoyage = JVoyage.VOYAGE;
        final JVoyageToCurrierMovement jVoyageToCurrierMovement = JVoyageToCurrierMovement.VOYAGE_TO_CURRIER_MOVEMENT;
        final JCurrierMovement jcurrierMovement = JCurrierMovement.CURRIER_MOVEMENT;
        final JLocation jLocation = JLocation.LOCATION;
        final JLocation dep = jLocation.as("dep");
        final JLocation arv = jLocation.as("arv");

        final List<Record> records = dslContext
                .select()
                .from(jVoyageToCurrierMovement)
                .join(jVoyage).on(jVoyageToCurrierMovement.VOYAGE_ID.eq(jVoyage.ID))
                .join(jcurrierMovement).on(jVoyageToCurrierMovement.CURRIER_MOVEMENT_ID.eq(jcurrierMovement.ID))
                .join(dep).on(jcurrierMovement.DEPARTURE_LOCATION_ID.eq(dep.ID))
                .join(arv).on(jcurrierMovement.ARRIVAL_LOCATION_ID.eq(arv.ID))
                .where(jVoyage.VOYAGE_NUMBER.eq(voyageNumber.idString()))
                .fetch();

        if (records.isEmpty()) {
            return Voyage.NONE;
        }

        final List<CarrierMovement> carrierMovements = records.stream()
                .map(record -> carrierMovementAssembler.createCarrierMovement(record, jcurrierMovement, dep, arv))
                .collect(Collectors.toList());

        return new Voyage(voyageNumber, new Schedule(carrierMovements));
    }

}
