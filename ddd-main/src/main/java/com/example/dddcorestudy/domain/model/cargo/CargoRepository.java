package com.example.dddcorestudy.domain.model.cargo;

import java.util.List;
import java.util.Optional;

public interface CargoRepository {

    /**
     * Finds a cargo using given id.
     *
     * @param trackingId Id
     * @return Cargo
     */
    Optional<Cargo> find(TrackingId trackingId);

    /**
     * Finds all cargo.
     *
     * @return All cargo.
     */
    List<Cargo> findAll();

    /**
     * Saves given cargo.
     *
     * @param cargo cargo to save
     */
    void store(Cargo cargo);

    /**
     * @return A unique, generated tracking Id.
     */
    TrackingId nextTrackingId();

}
