package com.kodluyoruz.demo.model.request;

import com.kodluyoruz.demo.model.entity.Hotel;
import com.kodluyoruz.demo.model.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUpdateVisitorRequest {
    private String firstName;
    private String lastName;
    private Boolean child;
}
