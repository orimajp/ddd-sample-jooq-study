/*
 * This file is generated by jOOQ.
 */
package com.example.db.jooq.gen.tables.daos;


import com.example.db.jooq.gen.tables.JVoyageToCurrierMovement;
import com.example.db.jooq.gen.tables.pojos.VoyageToCurrierMovementVo;
import com.example.db.jooq.gen.tables.records.VoyageToCurrierMovementRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VoyageToCurrierMovementDao extends DAOImpl<VoyageToCurrierMovementRecord, VoyageToCurrierMovementVo, Integer> {

    /**
     * Create a new VoyageToCurrierMovementDao without any configuration
     */
    public VoyageToCurrierMovementDao() {
        super(JVoyageToCurrierMovement.VOYAGE_TO_CURRIER_MOVEMENT, VoyageToCurrierMovementVo.class);
    }

    /**
     * Create a new VoyageToCurrierMovementDao with an attached configuration
     */
    public VoyageToCurrierMovementDao(Configuration configuration) {
        super(JVoyageToCurrierMovement.VOYAGE_TO_CURRIER_MOVEMENT, VoyageToCurrierMovementVo.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(VoyageToCurrierMovementVo object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<VoyageToCurrierMovementVo> fetchByJId(Integer... values) {
        return fetch(JVoyageToCurrierMovement.VOYAGE_TO_CURRIER_MOVEMENT.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public VoyageToCurrierMovementVo fetchOneByJId(Integer value) {
        return fetchOne(JVoyageToCurrierMovement.VOYAGE_TO_CURRIER_MOVEMENT.ID, value);
    }

    /**
     * Fetch records that have <code>voyage_id IN (values)</code>
     */
    public List<VoyageToCurrierMovementVo> fetchByJVoyageId(Integer... values) {
        return fetch(JVoyageToCurrierMovement.VOYAGE_TO_CURRIER_MOVEMENT.VOYAGE_ID, values);
    }

    /**
     * Fetch records that have <code>currier_movement_id IN (values)</code>
     */
    public List<VoyageToCurrierMovementVo> fetchByJCurrierMovementId(Integer... values) {
        return fetch(JVoyageToCurrierMovement.VOYAGE_TO_CURRIER_MOVEMENT.CURRIER_MOVEMENT_ID, values);
    }
}
