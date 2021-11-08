package com.kodluyoruz.demo.model.request;

import com.kodluyoruz.demo.model.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUpdateRoomRequest {
    private Integer hotelId;
    private String roomNumber;
    private RoomType roomType;
    private Double price;
    private int beds;
}
