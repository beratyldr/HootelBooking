package com.kodluyoruz.demo.service;


import com.kodluyoruz.demo.exception.BusinessException;
import com.kodluyoruz.demo.model.dto.BookingDto;
import com.kodluyoruz.demo.model.entity.Booking;
import com.kodluyoruz.demo.model.request.CreateUpdateBookingRequest;
import com.kodluyoruz.demo.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import static com.kodluyoruz.demo.model.mapper.BookingMapper.BOOKING_MAPPER;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BookingDto createReservation(CreateUpdateBookingRequest request) { //add new reservation
        Booking book =BOOKING_MAPPER.createBooking(request);
        validateRoom(request);

        return BOOKING_MAPPER.toBookingDto(bookingRepository.save(book));

    }

    private void validateRoom(CreateUpdateBookingRequest request) { //check if room is available
        if(!bookingRepository.CheckAvailableDateBetween(request.getRoomId(),request.getCheckInDate(),request.getCheckOutDate())){
            throw new BusinessException("Room all ready reserved!");
        }
    }



}
