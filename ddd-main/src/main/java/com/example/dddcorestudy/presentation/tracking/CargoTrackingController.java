package com.example.dddcorestudy.presentation.tracking;

import com.example.dddcorestudy.domain.model.cargo.CargoRepository;
import com.example.dddcorestudy.domain.model.cargo.TrackingId;
import com.example.dddcorestudy.domain.model.handling.HandlingEvent;
import com.example.dddcorestudy.domain.model.handling.HandlingEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("track")
@RequiredArgsConstructor
public final class CargoTrackingController {

    private final CargoRepository cargoRepository;
    private final HandlingEventRepository handlingEventRepository;
    private final MessageSource messageSource;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("trackCommand", new TrackCommand());
        return "track";
    }

    @PostMapping
    protected  String onSubmit(HttpServletRequest request,  @Validated @ModelAttribute TrackCommand command, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "track";
        }

        final TrackingId trackingId = new TrackingId(command.getTrackingId());

        return cargoRepository.find(trackingId).map(cargo -> {
            final Locale locale = RequestContextUtils.getLocale(request);
            final List<HandlingEvent> handlingEvents = handlingEventRepository.lookupHandlingHistoryOfCargo(trackingId).distinctEventsByCompletionTime();
            model.addAttribute("cargo", new CargoTrackingViewAdapter(cargo, messageSource, locale, handlingEvents));
            return "track";
        }).orElseGet(() -> {
            result.rejectValue("trackingId", "cargo.unknown_id", new Object[]{command.getTrackingId()}, "Unknown tracking id");
            return "track";
        });
    }

}
