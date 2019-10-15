package com.example.dddcorestudy.application.facade.booking.internal.assembler;

import com.example.dddcorestudy.application.facade.booking.dto.CargoRoutingDTO;
import com.example.dddcorestudy.domain.model.cargo.Cargo;
import com.example.dddcorestudy.domain.model.cargo.RoutingStatus;
import org.springframework.stereotype.Component;

@Component
public class CargoRoutingDTOAssembler {

    public CargoRoutingDTO toDTO(final Cargo cargo) {
        final CargoRoutingDTO dto = new CargoRoutingDTO(
                cargo.trackingId().idString(),
                cargo.origin().unLocode().idString(),
                cargo.routeSpecification().destination().unLocode().idString(),
                cargo.routeSpecification().arrivalDeadline(),
                cargo.delivery().routingStatus().sameValueAs(RoutingStatus.MISROUTED));

        cargo.itinerary().legs().forEach(leg ->
            dto.addLeg(
                    leg.voyage().voyageNumber().idString(),
                    leg.loadLocation().unLocode().idString(),
                    leg.unloadLocation().unLocode().idString(),
                    leg.loadTime(),
                    leg.unloadTime())
        );

        return dto;
    }

}
