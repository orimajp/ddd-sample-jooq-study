package com.example.dddcorestudy.infrastructure.routing;

import com.example.dddcorestudy.domain.model.cargo.Itinerary;
import com.example.dddcorestudy.domain.model.cargo.RouteSpecification;
import com.example.dddcorestudy.domain.service.RoutingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalRoutingService implements RoutingService {
    /**
     * @param routeSpecification route specification
     * @return A list of itineraries that satisfy the specification. May be an empty list if no route is found.
     */
    @Override
    public List<Itinerary> fetchRoutesForSpecification(RouteSpecification routeSpecification) {
        return null;
    }
}
