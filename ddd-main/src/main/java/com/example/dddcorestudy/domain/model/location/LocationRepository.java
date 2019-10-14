package com.example.dddcorestudy.domain.model.location;

import java.util.List;
import java.util.Optional;

public interface LocationRepository {

    /**
     * Finds a location using given unlocode.
     *
     * @param unLocode UNLocode.
     * @return Location.
     */
    Optional<Location> find(UnLocode unLocode);

    /**
     * Finds all locations.
     *
     * @return All locations.
     */
    List<Location> findAll();

}
