package com.kodluyoruz.demo.service;

import com.kodluyoruz.demo.model.dto.RoomDto;
import com.kodluyoruz.demo.model.entity.Room;
import com.kodluyoruz.demo.model.request.CreateUpdateRoomRequest;
import com.kodluyoruz.demo.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.demo.model.mapper.RoomMapper.ROOM_MAPPER;


@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    public RoomDto createRoom(CreateUpdateRoomRequest request) {
        Room room=ROOM_MAPPER.createRoom(request);
        return ROOM_MAPPER.toRoomDto(roomRepository.save(room));
    }

    private Room getRoomEntity(int id) {
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }
    public RoomDto getRoom(int id) {
        Room room=getRoomEntity(id);
        return ROOM_MAPPER.toRoomDto(room);
    }

    public RoomDto updateRoom(int id, CreateUpdateRoomRequest request) {
        Room room=getRoomEntity(id);
        ROOM_MAPPER.updateRoom(room,request);

        Room updatedRoom=roomRepository.save(room);
        return ROOM_MAPPER.toRoomDto(updatedRoom);
    }

    public List<RoomDto> getRooms() {
        return ROOM_MAPPER.toRoomDtoList(roomRepository.findAll());
    }



    public void deleteRoom(int id) {
        roomRepository.deleteById(id);
    }
}
