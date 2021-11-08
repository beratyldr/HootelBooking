package com.kodluyoruz.demo.controller;

import com.kodluyoruz.demo.model.dto.HotelDto;
import com.kodluyoruz.demo.model.request.CreateUpdateHotelRequest;
import com.kodluyoruz.demo.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("hotels")
@RequiredArgsConstructor
@Slf4j
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HotelDto createHotel(@RequestBody CreateUpdateHotelRequest request){
        return hotelService.createHotel(request);
    }

    @GetMapping("{id}")
    public HotelDto getHotel(@PathVariable int id){return hotelService.getHotel(id);}

    @PutMapping("{id}")
    public HotelDto updateHotel(@PathVariable int id,@RequestBody CreateUpdateHotelRequest request){
        return  hotelService.updateHotel(id,request);
    }

    @GetMapping
    public List<HotelDto> getHotels(){
        return hotelService.getHotels();
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHotel(@PathVariable int id){hotelService.deleteHotel(id);}
}
