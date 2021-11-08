package com.kodluyoruz.demo.model.dto;

import lombok.*;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private int id;
    private Integer visitorId;
    private Integer roomId;
    private Date checkInDate;
    private Date checkOutDate;
    private int day;

}
