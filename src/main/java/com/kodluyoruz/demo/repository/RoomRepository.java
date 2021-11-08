package com.kodluyoruz.demo.repository;

import com.kodluyoruz.demo.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Modifying
    @Transactional
    @Query("SELECT b FROM Room b WHERE b.hotelId=:id AND id NOT IN " +
            "(SELECT roomId FROM Booking WHERE :start BETWEEN checkInDate AND checkOutDate " +
            "OR :end BETWEEN checkInDate " +
            "AND checkOutDate OR :start <= checkInDate AND :end >= checkOutDate)")
    List<Room> getHotelRooms(@Param("start") Date from, @Param("end") Date to, @Param("id") Integer id);

}