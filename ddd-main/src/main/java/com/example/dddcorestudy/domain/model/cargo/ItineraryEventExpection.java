package com.example.dddcorestudy.domain.model.cargo;

import com.example.dddcorestudy.domain.model.handling.HandlingEvent;

public interface ItineraryEventExpection {

    default boolean isExpectedForRecieve(Itinerary itinerary, HandlingEvent event) {
        //Check that the first leg's origin is the event's location
        final Leg leg = itinerary.legs().get(0);
        return leg.loadLocation().equals(event.location());
    }

    default boolean isExpectedForLoad(Itinerary itinerary, HandlingEvent event) {
        //Check that the there is one leg with same load location and voyage
        for (Leg leg:itinerary.legs()) {
            if (leg.loadLocation().sameIdentityAs(event.location()) &&
                    leg.voyage().sameIdentityAs(event.voyage())) {
                return true;
            }
        }
        return false;
    }

    default boolean isExpectedForUnload(Itinerary itinerary, HandlingEvent event) {
        //Check that the there is one leg with same unload location and voyage
        for (Leg leg:itinerary.legs()) {
            if (leg.unloadLocation().equals(event.location()) &&
                    leg.voyage().equals(event.voyage())) {
                return true;
            }
        }
        return false;
    }

    default boolean isExpectedForClaim(Itinerary itinerary, HandlingEvent event) {
        //Check that the last leg's destination is from the event's location
        final Leg leg = itinerary.lastLeg();
        return leg.unloadLocation().equals(event.location());
    }

    default boolean isExpectedForDefault(Itinerary itinerary, HandlingEvent event) {
        //HandlingEvent.Type.CUSTOMS;
        return true;
    }

}
