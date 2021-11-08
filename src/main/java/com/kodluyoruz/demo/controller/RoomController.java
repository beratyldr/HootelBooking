package com.kodluyoruz.demo.controller;

import com.kodluyoruz.demo.model.dto.RoomDto;
import com.kodluyoruz.demo.model.request.CreateUpdateRoomRequest;
import com.kodluyoruz.demo.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
@Slf4j
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoomDto createRoom(@RequestBody CreateUpdateRoomRequest request){
        return roomService.createRoom(request);
    }

    @GetMapping("{id}")
    public RoomDto getRoom(@PathVariable int id){return roomService.getRoom(id);}

    @PutMapping("{id}")
    public RoomDto updateRoom(@PathVariable int id,@RequestBody CreateUpdateRoomRequest request){
        return  roomService.updateRoom(id,request);
    }

    @GetMapping
    public List<RoomDto> getRooms(){
        return roomService.getRooms();
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable int id){roomService.deleteRoom(id);}
}
