package com.kodluyoruz.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "bookings")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE bookings SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Booking extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "Check in date required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkInDate;

    @Column(nullable = false)
    @NotNull(message = "Check out date required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkOutDate;

    private int day;

    @Column(name = "room_id")
    private Integer roomId;

    @JoinColumn(name="room_id",nullable = false,insertable = false,updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @Column(name = "visitor_id")
    private Integer visitorId;

    @JoinColumn(name="visitor_id",nullable = false,insertable = false,updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Visitor visitor;


}
