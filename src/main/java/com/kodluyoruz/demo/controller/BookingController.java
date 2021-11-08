package com.kodluyoruz.demo.controller;

import com.kodluyoruz.demo.model.dto.BookingDto;
import com.kodluyoruz.demo.model.request.CreateUpdateBookingRequest;
import com.kodluyoruz.demo.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RestController
@RequestMapping("bookings")
@RequiredArgsConstructor
@Slf4j
public class BookingController {
    private final BookingService bookingService;
        //campaingDay sistemini anlayamadım şimdilik sadece rezervasyon oluşturuyoruz.
    @PostMapping("/create-reservation")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDto createReservation(@RequestBody CreateUpdateBookingRequest request){
        return bookingService.createReservation(request);
    }


}
