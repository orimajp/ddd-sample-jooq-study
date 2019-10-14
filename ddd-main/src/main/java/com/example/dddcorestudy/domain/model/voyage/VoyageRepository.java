package com.example.dddcorestudy.domain.model.voyage;

public interface VoyageRepository {

    /**
     * Finds a voyage using voyage number.
     *
     * @param voyageNumber voyage number
     * @return The voyage
     */
    Voyage find(VoyageNumber voyageNumber);

}
