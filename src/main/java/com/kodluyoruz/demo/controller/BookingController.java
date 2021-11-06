package com.kodluyoruz.demo.controller;

import com.kodluyoruz.demo.model.dto.BookingDto;
import com.kodluyoruz.demo.model.dto.RoomDto;
import com.kodluyoruz.demo.model.request.CreateUpdateBookingRequest;
import com.kodluyoruz.demo.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RestController
@RequestMapping("bookings")
@RequiredArgsConstructor
@Slf4j
public class BookingController {
    private final BookingService bookingService;
    @PostMapping("/create-reservation")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDto createReservation(@RequestBody CreateUpdateBookingRequest request){
        return bookingService.createReservation(request);
    }

    @GetMapping("/rooms")
    public List<RoomDto> getAvailableRooms(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkInDate,
                                                  @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkOutDate){
        return bookingService.getRooms(checkInDate,checkOutDate);
    }


}
