package com.example.dddcorestudy.presentation.tracking;

import com.example.dddcorestudy.domain.model.cargo.HandlingActivity;
import com.example.dddcorestudy.domain.model.handling.HandlingEvent;

public interface NextExpectedActivity {

    String PREFIX_TEXT = "Next expected activity is to ";

    default String getNextExpectedActivityForLoadEvent(HandlingEvent.Type type, HandlingActivity activity) {
        return String.format("%s%s cargo onto voyage %s in %s", PREFIX_TEXT, type.name().toLowerCase(),
                activity.voyage().voyageNumber(), activity.location().name());
    }

    default String getNextExpectedActivityForUnloadEvent(HandlingEvent.Type type, HandlingActivity activity) {
        return String.format("%s%s cargo off of %s in %s", PREFIX_TEXT, type.name().toLowerCase(),
                activity.voyage().voyageNumber(), activity.location().name());
    }

    default String getNextExpectedActivityDefault(HandlingEvent.Type type, HandlingActivity activity) {
        return String.format("%s%s cargo in %s", PREFIX_TEXT, type.name().toLowerCase(), activity.location().name());
    }

}
