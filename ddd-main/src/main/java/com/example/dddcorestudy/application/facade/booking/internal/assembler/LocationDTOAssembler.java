package com.example.dddcorestudy.application.facade.booking.internal.assembler;

import com.example.dddcorestudy.application.facade.booking.dto.LocationDTO;
import com.example.dddcorestudy.domain.model.location.Location;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationDTOAssembler {

    public LocationDTO toDTO(Location location) {
        return new LocationDTO(location.unLocode().idString(), location.name());
    }

    public List<LocationDTO> toDTOList(List<Location> allLocations) {
        return allLocations.stream().map(this::toDTO).collect(Collectors.toList());
    }

}
