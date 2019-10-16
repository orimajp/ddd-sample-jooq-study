package com.example.dddcorestudy.presentation.booking.web;

import com.example.dddcorestudy.application.facade.booking.BookingServiceFacade;
import com.example.dddcorestudy.application.facade.booking.dto.CargoRoutingDTO;
import com.example.dddcorestudy.application.facade.booking.dto.LegDTO;
import com.example.dddcorestudy.application.facade.booking.dto.LocationDTO;
import com.example.dddcorestudy.application.facade.booking.dto.RouteCandidateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("admin")
@RequiredArgsConstructor
public final class CargoAdminController {

    private final BookingServiceFacade bookingServiceFacade;

    @GetMapping("registration")
    public String registration(Model model) {
        final List<LocationDTO> dtos = bookingServiceFacade.listShippingLocations();
        final List<String> unLocodesString = dtos.stream().map(LocationDTO::getUnLocode).collect(Collectors.toList());
        model.addAttribute("unlocodes", unLocodesString);
        model.addAttribute("loctions", dtos);
        return "admin/registrationForm";
    }

    @PostMapping("register")
    public String register(@Validated @ModelAttribute RegistrationCommand command, BindingResult result, Model model,
                           RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            return registration(model);
        }
        final String trackingId = bookingServiceFacade.bookNewCargo(command.getOriginUnlocode(),
                command.getDestinationUnlocode(), command.getArrivalDeadline());
        redirectAttributes.addAttribute("trackingId", trackingId);
        return "redirect:show";
    }

    @GetMapping("list")
    public String list(Model model) {
        final List<CargoRoutingDTO> cargoRoutingDTOS = bookingServiceFacade.listAllCargos();
        model.addAttribute("cargoList", cargoRoutingDTOS);
        return "admin/list";
    }

    @GetMapping("show")
    public String show(@RequestParam("trackingId") String trackingId, Model model) {
        final CargoRoutingDTO dto = bookingServiceFacade.loadCargoForRouting(trackingId);
        model.addAttribute("cargo", dto);
        return "admin/show";
    }

    @GetMapping("selectItinerary")
    public String selectItinerary(@RequestParam("trackingId") String trackingId, Model model) {
        final List<RouteCandidateDTO> routeCandidateDTOS = bookingServiceFacade.requestPossibleRoutesForCargo(trackingId);
        final CargoRoutingDTO cargoRoutingDTO = bookingServiceFacade.loadCargoForRouting(trackingId);
        model.addAttribute("routeCandidates", routeCandidateDTOS);
        model.addAttribute("cargo", cargoRoutingDTO);
        return "admin/selectItinerary";
    }

    @PostMapping("assignItinerary")
    public String assignItinerary(RouteAssignmentCommand command, RedirectAttributes redirectAttributes) {
        final List<LegDTO> legDTOS = command.getLegs().stream().map(this::crateLegDTO).collect(Collectors.toList());
        final RouteCandidateDTO selectedRoute = new RouteCandidateDTO(legDTOS);
        bookingServiceFacade.assignCargoToRoute(command.getTrackingId(), selectedRoute);
        redirectAttributes.addAttribute("trackingId", command.getTrackingId());
        return "redirect:show";
    }

    @GetMapping("pickNewDestination")
    public String pickNewDestination(@RequestParam("trackingId") String trackingId, Model model) {
        final List<LocationDTO> locations = bookingServiceFacade.listShippingLocations();
        final CargoRoutingDTO cargo = bookingServiceFacade.loadCargoForRouting(trackingId);
        model.addAttribute("locations", locations);
        model.addAttribute("cargo", cargo);
        return "admin/pickNewDestination";
    }

    @PostMapping("changeDestination")
    public String changeDestination(@ModelAttribute ChangeDestinationCommand command, RedirectAttributes redirectAttributes) {
        bookingServiceFacade.changeDestination(command.getTrackingId(), command.getUnlocode());
        redirectAttributes.addAttribute("trackingId", command.getTrackingId());
        return "redirect:show";
    }

    private LegDTO crateLegDTO(RouteAssignmentCommand.LegCommand command) {
        return new LegDTO(command.getVoyageNumber(), command.getFromUnLocode(), command.getToUnLocode(),
                command.getFromDate(), command.getToDate());
    }

}
