package com.example.dddcorestudy.infrastructure.repository.jooq;

import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.model.location.LocationRepository;
import com.example.dddcorestudy.domain.model.location.UnLocode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LocationRepositoryJooq implements LocationRepository {
    /**
     * Finds a location using given unlocode.
     *
     * @param unLocode UNLocode.
     * @return Location.
     */
    @Override
    public Optional<Location> find(UnLocode unLocode) {
        return Optional.empty();
    }

    /**
     * Finds all locations.
     *
     * @return All locations.
     */
    @Override
    public List<Location> findAll() {
        return null;
    }
}
