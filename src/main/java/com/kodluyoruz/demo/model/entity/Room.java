package com.kodluyoruz.demo.model.entity;

import com.kodluyoruz.demo.model.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "rooms")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE rooms SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Room extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "hotel_id")
    private Integer hotelId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false, insertable = false, updatable = false)
    private Hotel hotel;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String roomNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(nullable = false)
    private int beds;

    public Room(Long createdDate, Long lastModifiedDate, Boolean deleted, Integer id, Integer hotelId, Hotel hotel, String roomNumber, RoomType roomType, int beds) {
        super(createdDate, lastModifiedDate, deleted);
        this.id = id;
        this.hotelId = hotelId;
        this.hotel = hotel;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.beds = beds;
    }
}
    /*@Column(nullable = false)
    private BigDecimal costPerNight;

    @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;*/
