package com.kodluyoruz.demo.service;


import com.kodluyoruz.demo.exception.BusinessException;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.kodluyoruz.demo.model.mapper.BookingMapper.BOOKING_MAPPER;
import static com.kodluyoruz.demo.model.mapper.HotelMapper.HOTEL_MAPPER;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomService roomService;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BookingDto createReservation(CreateUpdateBookingRequest request) {
        Booking book =BOOKING_MAPPER.createBooking(request);
        validateRoom(request);

        return BOOKING_MAPPER.toBookingDto(bookingRepository.save(book));

    }

    private void validateRoom(CreateUpdateBookingRequest request) {
        if(!bookingRepository.CheckAvailableDateBetween(request.getRoomId(),request.getCheckInDate(),request.getCheckOutDate())){
            throw new BusinessException("Room all ready reserved!");
        }
    }



}
