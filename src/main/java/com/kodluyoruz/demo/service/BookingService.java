package com.kodluyoruz.demo.service;


import com.kodluyoruz.demo.model.dto.BookingDto;
import com.kodluyoruz.demo.model.dto.HotelDto;
import com.kodluyoruz.demo.model.dto.RoomDto;
import com.kodluyoruz.demo.model.entity.Booking;
import com.kodluyoruz.demo.model.entity.Hotel;
import com.kodluyoruz.demo.model.entity.Room;
import com.kodluyoruz.demo.model.mapper.HotelMapper;
import com.kodluyoruz.demo.model.request.CreateUpdateBookingRequest;
import com.kodluyoruz.demo.repository.BookingRepository;
import com.kodluyoruz.demo.repository.HotelRepository;
import com.kodluyoruz.demo.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import static com.kodluyoruz.demo.model.mapper.BookingMapper.BOOKING_MAPPER;
import static com.kodluyoruz.demo.model.mapper.HotelMapper.HOTEL_MAPPER;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomService roomService;
    private final HotelRepository hotelRepository;

    public BookingDto createReservation(CreateUpdateBookingRequest request) {
        Booking book =BOOKING_MAPPER.createBooking(request);

        roomService.updateAvailability(request.getRoomId(), false);
        return BOOKING_MAPPER.toBookingDto(bookingRepository.save(book));

    }





}
