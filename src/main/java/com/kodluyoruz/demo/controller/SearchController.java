package com.kodluyoruz.demo.controller;

import com.kodluyoruz.demo.model.dto.HotelDto;
import com.kodluyoruz.demo.model.dto.RoomDto;
import com.kodluyoruz.demo.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("search")
@Slf4j
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/hotels")
    public List<HotelDto> getAvailableRooms(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkInDate,
                                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkOutDate,
                                            @RequestParam String town,
                                            @RequestParam String province){
        return searchService.getHotels(checkInDate,checkOutDate,town,province);
    }
    @GetMapping("/hotels/{id}/rooms")
    public List<RoomDto> getAvailableRooms(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkInDate,
                                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date checkOutDate,
                                           @PathVariable int id){
        return searchService.getRooms(checkInDate,checkOutDate,id);
    }

}
