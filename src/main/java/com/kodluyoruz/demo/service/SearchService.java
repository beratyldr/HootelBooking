package com.kodluyoruz.demo.service;

import com.kodluyoruz.demo.model.dto.HotelDto;
import com.kodluyoruz.demo.model.dto.RoomDto;
import com.kodluyoruz.demo.model.entity.Hotel;
import com.kodluyoruz.demo.repository.BookingRepository;
import com.kodluyoruz.demo.repository.HotelRepository;
import com.kodluyoruz.demo.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.kodluyoruz.demo.model.mapper.HotelMapper.HOTEL_MAPPER;
import static com.kodluyoruz.demo.model.mapper.RoomMapper.ROOM_MAPPER;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final BookingRepository bookingRepository;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final HotelService hotelService;

    public List<HotelDto> getHotels(Date checkInDate, Date checkOutDate, String town, String province) {
        if (checkInDate != null && checkOutDate != null) {
            List<Hotel> hotelList=bookingRepository.findByAvailableDateBetween(province,town,checkInDate, checkOutDate);
            return HOTEL_MAPPER.toHotelDtoList(hotelList);
        }
        return HOTEL_MAPPER.toHotelDtoList(hotelRepository.findAll());
    }

    public List<RoomDto> getRooms(Date checkInDate,Date checkOutDate,int id) {
        return ROOM_MAPPER.toRoomDtoList(roomRepository.getHotelRooms(checkInDate,checkOutDate,id));
    }
}
