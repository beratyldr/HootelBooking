package com.kodluyoruz.demo.service;

import com.kodluyoruz.demo.model.dto.HotelDto;
import com.kodluyoruz.demo.model.entity.Hotel;
import com.kodluyoruz.demo.model.request.CreateUpdateHotelRequest;
import com.kodluyoruz.demo.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.demo.model.mapper.HotelMapper.HOTEL_MAPPER;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelDto createHotel(CreateUpdateHotelRequest request) {
        Hotel hotel=HOTEL_MAPPER.createHotel(request);
        return HOTEL_MAPPER.toHotelDto(hotelRepository.save(hotel));

    }
     public Hotel getHotelEntity(int id) {
        return hotelRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }
    public HotelDto getHotel(int id) {
        Hotel hotel=getHotelEntity(id);
        return HOTEL_MAPPER.toHotelDto(hotel);
    }

    public HotelDto updateHotel(int id,CreateUpdateHotelRequest request){
        Hotel hotel=getHotelEntity(id);
        HOTEL_MAPPER.updateHotel(hotel,request);

        Hotel updatedHotel=hotelRepository.save(hotel);
        return HOTEL_MAPPER.toHotelDto(updatedHotel);
    }

    public List<HotelDto> getHotels(){
        return HOTEL_MAPPER.toHotelDtoList(hotelRepository.findAll());
    }

    public void deleteHotel(int id){hotelRepository.deleteById(id);}


}
