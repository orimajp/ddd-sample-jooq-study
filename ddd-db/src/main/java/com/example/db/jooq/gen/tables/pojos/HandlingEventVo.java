/*
 * This file is generated by jOOQ.
 */
package com.example.db.jooq.gen.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Generated;


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
public class HandlingEventVo implements Serializable {

    private static final long serialVersionUID = 188224900;

    private final Integer       id;
    private final Integer       voyageId;
    private final Integer       locationId;
    private final Integer       cargoId;
    private final LocalDateTime completionTime;
    private final Integer       registrationTime;
    private final String        type;

    public HandlingEventVo(HandlingEventVo value) {
        this.id = value.id;
        this.voyageId = value.voyageId;
        this.locationId = value.locationId;
        this.cargoId = value.cargoId;
        this.completionTime = value.completionTime;
        this.registrationTime = value.registrationTime;
        this.type = value.type;
    }

    public HandlingEventVo(
        Integer       id,
        Integer       voyageId,
        Integer       locationId,
        Integer       cargoId,
        LocalDateTime completionTime,
        Integer       registrationTime,
        String        type
    ) {
        this.id = id;
        this.voyageId = voyageId;
        this.locationId = locationId;
        this.cargoId = cargoId;
        this.completionTime = completionTime;
        this.registrationTime = registrationTime;
        this.type = type;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getVoyageId() {
        return this.voyageId;
    }

    public Integer getLocationId() {
        return this.locationId;
    }

    public Integer getCargoId() {
        return this.cargoId;
    }

    public LocalDateTime getCompletionTime() {
        return this.completionTime;
    }

    public Integer getRegistrationTime() {
        return this.registrationTime;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final HandlingEventVo other = (HandlingEventVo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (voyageId == null) {
            if (other.voyageId != null)
                return false;
        }
        else if (!voyageId.equals(other.voyageId))
            return false;
        if (locationId == null) {
            if (other.locationId != null)
                return false;
        }
        else if (!locationId.equals(other.locationId))
            return false;
        if (cargoId == null) {
            if (other.cargoId != null)
                return false;
        }
        else if (!cargoId.equals(other.cargoId))
            return false;
        if (completionTime == null) {
            if (other.completionTime != null)
                return false;
        }
        else if (!completionTime.equals(other.completionTime))
            return false;
        if (registrationTime == null) {
            if (other.registrationTime != null)
                return false;
        }
        else if (!registrationTime.equals(other.registrationTime))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        }
        else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.voyageId == null) ? 0 : this.voyageId.hashCode());
        result = prime * result + ((this.locationId == null) ? 0 : this.locationId.hashCode());
        result = prime * result + ((this.cargoId == null) ? 0 : this.cargoId.hashCode());
        result = prime * result + ((this.completionTime == null) ? 0 : this.completionTime.hashCode());
        result = prime * result + ((this.registrationTime == null) ? 0 : this.registrationTime.hashCode());
        result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("HandlingEventVo (");

        sb.append(id);
        sb.append(", ").append(voyageId);
        sb.append(", ").append(locationId);
        sb.append(", ").append(cargoId);
        sb.append(", ").append(completionTime);
        sb.append(", ").append(registrationTime);
        sb.append(", ").append(type);

        sb.append(")");
        return sb.toString();
    }
}