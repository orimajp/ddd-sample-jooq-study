package com.example.dddcorestudy.infrastructure.repository.jooq.assembler;

import com.example.db.jooq.gen.tables.JLocation;
import com.example.db.jooq.gen.tables.records.LocationRecord;
import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.model.location.UnLocode;
import org.springframework.stereotype.Component;

@Component
public class LocationAssembler {

    public Location createLocation(LocationRecord locationRecord, JLocation jLocation) {
        return new Location(new UnLocode(locationRecord.getValue(jLocation.UNLOCODE)),
                locationRecord.getValue(jLocation.NAME));
    }

}
