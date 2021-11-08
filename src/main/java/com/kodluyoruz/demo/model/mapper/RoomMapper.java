package com.kodluyoruz.demo.model.mapper;

import com.kodluyoruz.demo.model.dto.RoomDto;
import com.kodluyoruz.demo.model.entity.Room;
import com.kodluyoruz.demo.model.request.CreateUpdateRoomRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface RoomMapper {
    RoomMapper ROOM_MAPPER= Mappers.getMapper(RoomMapper.class);

    RoomDto toRoomDto(Room room);
    Room toDtoRoom(RoomDto roomDto);
    List<RoomDto> toRoomDtoList(List<Room> rooms);

    Room createRoom(CreateUpdateRoomRequest request);

    void updateRoom(@MappingTarget Room room, CreateUpdateRoomRequest request);
}
