package com.example.dddcorestudy.presentation.booking;

import com.example.dddcorestudy.application.facade.booking.BookingServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
@RequiredArgsConstructor
public final class CargoAdminController {

    private final BookingServiceFacade bookingServiceFacade;

}
