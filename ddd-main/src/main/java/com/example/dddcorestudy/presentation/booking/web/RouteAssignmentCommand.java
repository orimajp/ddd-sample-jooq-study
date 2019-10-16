package com.example.dddcorestudy.presentation.booking.web;

import lombok.Data;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.ListUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public final class RouteAssignmentCommand {
    private String trackingId;
    private List<LegCommand> legs = ListUtils.lazyList(
            new ArrayList<>(), LegCommand.factory());

    @Data
    public static final class LegCommand {
        private String voyageNumber;
        private String fromUnLocode;
        private String toUnLocode;
        private LocalDateTime fromDate;
        private LocalDateTime toDate;
        public static Factory<LegCommand> factory() {
            return LegCommand::new;
        }
    }

}
