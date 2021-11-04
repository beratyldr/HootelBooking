package com.kodluyoruz.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private int id;
    private String name;
    private String address;
    private String email;
    private int star;
}
