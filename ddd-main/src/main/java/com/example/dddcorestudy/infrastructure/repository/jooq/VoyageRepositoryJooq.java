package com.example.dddcorestudy.infrastructure.repository.jooq;

import com.example.dddcorestudy.domain.model.voyage.Voyage;
import com.example.dddcorestudy.domain.model.voyage.VoyageNumber;
import com.example.dddcorestudy.domain.model.voyage.VoyageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VoyageRepositoryJooq implements VoyageRepository {
    /**
     * Finds a voyage using voyage number.
     *
     * @param voyageNumber voyage number
     * @return The voyage
     */
    @Override
    public Voyage find(VoyageNumber voyageNumber) {
        return Voyage.NONE;
    }
}
