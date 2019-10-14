package com.example.dddcorestudy.domain.model.cargo;

import com.example.dddcorestudy.domain.model.handling.HandlingEvent;

import java.util.Iterator;

public interface NextExpectedActivityCalculation {

    HandlingActivity NO_ACTIVITY = null;

    default HandlingActivity calculateNextActivityForLoad(Itinerary itinerary, HandlingEvent lastEvent) {
        for (Leg leg : itinerary.legs()) {
            if (leg.loadLocation().sameIdentityAs(lastEvent.location())) {
                return new HandlingActivity(HandlingEvent.Type.UNLOAD, leg.unloadLocation(), leg.voyage());
            }
        }

        return NO_ACTIVITY;
    }

    default HandlingActivity calculateNextActivityForUnload(Itinerary itinerary, HandlingEvent lastEvent) {
        for (Iterator<Leg> it = itinerary.legs().iterator(); it.hasNext();) {
            final Leg leg = it.next();
            if (leg.unloadLocation().sameIdentityAs(lastEvent.location())) {
                if (it.hasNext()) {
                    final Leg nextLeg = it.next();
                    return new HandlingActivity(HandlingEvent.Type.LOAD, nextLeg.loadLocation(), nextLeg.voyage());
                }
                return new HandlingActivity(HandlingEvent.Type.CLAIM, leg.unloadLocation());
            }
        }

        return NO_ACTIVITY;
    }

    default HandlingActivity calculateNextActivityForReceive(Itinerary itinerary, HandlingEvent lastEvent) {
        final Leg firstLeg = itinerary.legs().iterator().next();
        return new HandlingActivity(HandlingEvent.Type.LOAD, firstLeg.loadLocation(), firstLeg.voyage());
    }

    default HandlingActivity calculateNextActivityDefault(Itinerary itinerary, HandlingEvent lastEvent) {
        return NO_ACTIVITY;
    }

}
