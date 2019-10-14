package com.example.dddcorestudy.domain.model.voyage;

import com.example.dddcorestudy.domain.share.ValueObject;
import org.apache.commons.lang3.Validate;

import java.util.Collections;
import java.util.List;

public class Schedule implements ValueObject<Schedule> {

    private List<CarrierMovement> carrierMovements = Collections.emptyList();

    public static final Schedule EMPTY = new Schedule();

    Schedule(final List<CarrierMovement> carrierMovements) {
        Validate.notNull(carrierMovements);
        Validate.noNullElements(carrierMovements);
        Validate.notEmpty(carrierMovements);

        this.carrierMovements = carrierMovements;
    }

    /**
     * @return Carrier movements.
     */
    public List<CarrierMovement> carrierMovements() {
        return Collections.unmodifiableList(carrierMovements);
    }

    @Override
    public boolean sameValueAs(final Schedule other) {
        return other != null && this.carrierMovements.equals(other.carrierMovements);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Schedule that = (Schedule) o;

        return sameValueAs(that);
    }

    private Schedule() {}

}
