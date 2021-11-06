package com.kodluyoruz.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUpdateBookingRequest {

    private Integer visitorId;
    private Integer roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int day;
}
