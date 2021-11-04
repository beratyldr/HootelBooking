package com.kodluyoruz.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUpdateHotelRequest {
    private String name;
    private String address;
    private String email;
    private int star;
}
