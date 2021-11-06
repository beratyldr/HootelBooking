package com.kodluyoruz.demo.service;


import com.kodluyoruz.demo.model.dto.BookingDto;
import com.kodluyoruz.demo.model.dto.RoomDto;
import com.kodluyoruz.demo.model.entity.Booking;
import com.kodluyoruz.demo.model.request.CreateUpdateBookingRequest;
import com.kodluyoruz.demo.repository.BookingRepository;
import com.kodluyoruz.demo.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static com.kodluyoruz.demo.model.mapper.BookingMapper.BOOKING_MAPPER;
import static com.kodluyoruz.demo.model.mapper.RoomMapper.ROOM_MAPPER;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final RoomService roomService;

    public BookingDto createReservation(CreateUpdateBookingRequest request) {
        Booking book =BOOKING_MAPPER.createBooking(request);

        roomService.updateAvailability(request.getRoomId(), false);
        return BOOKING_MAPPER.toBookingDto(bookingRepository.save(book));

    }

    public List<RoomDto> getRooms(Date checkInDate, Date checkOutDate) {
        if (checkInDate != null && checkOutDate != null) {
            return ROOM_MAPPER.toRoomDtoList(bookingRepository.findByAvailableDateBetween(checkInDate,checkOutDate));
        }
        return ROOM_MAPPER.toRoomDtoList(roomRepository.findAll());
    }



}
