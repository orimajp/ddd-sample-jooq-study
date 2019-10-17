package com.example.dddcorestudy.presentation.tracking;

import com.example.dddcorestudy.domain.model.cargo.Delivery;

public interface TransporterStatusParameter {

    default Object[] getStatusTextArgumentsForInPort(Delivery delivery) {
        // FIXME 元々CargoTrackingViewAdapterの getDisplayText()を使っているので処理が分参加されている
        return new Object[] {delivery.lastKnownLocation().name()};
    }

    default Object[] getStatusTextArgumentsForOnboardCarrier(Delivery delivery) {
        return new Object[] {delivery.currentVoyage().voyageNumber().idString()};
    }

    default Object[] getStatusTextArgumentsDefault(Delivery delivery) {
        return null;
    }

}
