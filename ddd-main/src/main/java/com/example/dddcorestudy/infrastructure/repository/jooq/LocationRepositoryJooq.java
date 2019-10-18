package com.example.dddcorestudy.infrastructure.repository.jooq;

import com.example.db.jooq.gen.tables.JLocation;
import com.example.db.jooq.gen.tables.records.LocationRecord;
import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.model.location.LocationRepository;
import com.example.dddcorestudy.domain.model.location.UnLocode;
import com.example.dddcorestudy.infrastructure.repository.jooq.assembler.LocationAssembler;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class LocationRepositoryJooq implements LocationRepository {

    private final DSLContext dslContext;
    private final LocationAssembler locationAssembler;

    /**
     * Finds a location using given unlocode.
     *
     * @param unLocode UNLocode.
     * @return Location.
     */
    @Override
    public Optional<Location> find(UnLocode unLocode) {
        final JLocation jLocation = JLocation.LOCATION;

        final LocationRecord locationRecord = dslContext
                .selectFrom(jLocation)
                .where(jLocation.UNLOCODE.eq(unLocode.idString()))
                .fetchAny();

        if (locationRecord == null) {
            return Optional.empty();
        }

        return Optional.of(locationAssembler.createLocation(locationRecord, jLocation));
    }

    /**
     * Finds all locations.
     *
     * @return All locations.
     */
    @Override
    public List<Location> findAll() {
        final JLocation jLocation = JLocation.LOCATION;

        final List<LocationRecord> records = dslContext
                .selectFrom(jLocation)
                .fetch();

        return records.stream()
                .map(locationRecord -> locationAssembler.createLocation(locationRecord, jLocation))
                .collect(Collectors.toList());
    }

}
