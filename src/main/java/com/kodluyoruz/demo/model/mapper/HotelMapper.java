package com.kodluyoruz.demo.model.mapper;

import com.kodluyoruz.demo.model.dto.HotelDto;
import com.kodluyoruz.demo.model.entity.Hotel;
import com.kodluyoruz.demo.model.request.CreateUpdateHotelRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface HotelMapper {
    HotelMapper HOTEL_MAPPER= Mappers.getMapper(HotelMapper.class);

    HotelDto toHotelDto(Hotel hotel);
    Hotel toDtoHotel(HotelDto hotelDto);
    List<HotelDto> toHotelDtoList(List<Hotel> hotels);

    Hotel createHotel(CreateUpdateHotelRequest request);

    void updateHotel(@MappingTarget Hotel hotel, CreateUpdateHotelRequest request);
}
