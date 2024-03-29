package com.example.dddcorestudy.domain.service;

import com.example.dddcorestudy.domain.model.cargo.Itinerary;
import com.example.dddcorestudy.domain.model.cargo.RouteSpecification;

import java.util.List;

public interface RoutingService {

    /**
     * @param routeSpecification route specification
     * @return A list of itineraries that satisfy the specification. May be an empty list if no route is found.
     */
    List<Itinerary> fetchRoutesForSpecification(RouteSpecification routeSpecification);

}
