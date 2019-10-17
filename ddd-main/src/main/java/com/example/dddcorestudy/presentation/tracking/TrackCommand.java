package com.example.dddcorestudy.presentation.tracking;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.NotEmpty;

import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;

@Data
public final class TrackCommand {

    @NotEmpty
    private String trackingId;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, MULTI_LINE_STYLE);
    }

}
