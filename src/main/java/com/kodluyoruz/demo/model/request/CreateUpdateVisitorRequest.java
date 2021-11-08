package com.kodluyoruz.demo.model.request;

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
