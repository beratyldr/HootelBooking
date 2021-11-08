package com.kodluyoruz.demo.model.dto;

import com.kodluyoruz.demo.model.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Integer id;
    private Integer hotelId;
    private String roomNumber;
    private RoomType roomType;
    private int beds;
    private Double price;
}
