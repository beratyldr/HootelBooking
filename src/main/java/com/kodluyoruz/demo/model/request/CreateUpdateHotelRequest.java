package com.kodluyoruz.demo.model.request;

import com.kodluyoruz.demo.model.location.Address;
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
    private Address address;
    private String email;
    private int star;
}
