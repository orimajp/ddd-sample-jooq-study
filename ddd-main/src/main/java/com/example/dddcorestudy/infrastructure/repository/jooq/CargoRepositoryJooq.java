package com.example.dddcorestudy.infrastructure.repository.jooq;

import com.example.dddcorestudy.domain.model.cargo.Cargo;
import com.example.dddcorestudy.domain.model.cargo.CargoRepository;
import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CargoRepositoryJooq implements CargoRepository {
    /**
     * Finds a cargo using given id.
     *
     * @param trackingId Id
     * @return Cargo
     */
    @Override
    public Optional<Cargo> find(TrackingId trackingId) {
        return Optional.empty();
    }

    /**
     * Finds all cargo.
     *
     * @return All cargo.
     */
    @Override
    public List<Cargo> findAll() {
        return null;
    }

    /**
     * Saves given cargo.
     *
     * @param cargo cargo to save
     */
    @Override
    public void store(Cargo cargo) {

    }

    /**
     * @return A unique, generated tracking Id.
     */
    @Override
    public TrackingId nextTrackingId() {
        return null;
    }

}
