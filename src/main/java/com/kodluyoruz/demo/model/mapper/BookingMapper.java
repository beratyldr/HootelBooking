package com.kodluyoruz.demo.model.mapper;

import com.kodluyoruz.demo.model.dto.BookingDto;
import com.kodluyoruz.demo.model.entity.Booking;
import com.kodluyoruz.demo.model.request.CreateUpdateBookingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface BookingMapper {
    BookingMapper BOOKING_MAPPER= Mappers.getMapper(BookingMapper.class);

    BookingDto toBookingDto(Booking Booking);
    Booking toDtoBooking(BookingDto BookingDto);
    List<BookingDto> toBookingDtoList(List<Booking> Bookings);

    Booking createBooking(CreateUpdateBookingRequest request);

    void updateBooking(@MappingTarget Booking Booking, CreateUpdateBookingRequest request);
}
