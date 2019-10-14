package com.example.dddcorestudy.domain.model.voyage;

import com.example.dddcorestudy.domain.share.ValueObject;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.Validate;

@EqualsAndHashCode
public class VoyageNumber implements ValueObject<VoyageNumber> {

    private String number;

    public VoyageNumber(String number) {
        Validate.notNull(number);

        this.number = number;
    }

    /**
     * Value objects compare by the values of their attributes, they don't have an identity.
     *
     * @param other The other value object.
     * @return <code>true</code> if the given value object's and this value object's attributes are the same.
     */
    @Override
    public boolean sameValueAs(VoyageNumber other) {
        return equals(other);
    }

    @Override
    public String toString() {
        return number;
    }

    public String idString() {
        return number;
    }

}
