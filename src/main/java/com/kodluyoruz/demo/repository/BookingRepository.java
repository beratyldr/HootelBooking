package com.kodluyoruz.demo.repository;


import com.kodluyoruz.demo.model.entity.Booking;
import com.kodluyoruz.demo.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {


    @Modifying
    @Transactional
    @Query("SELECT a FROM Room a WHERE a.id NOT IN " +
            "(SELECT roomId FROM Booking WHERE :start BETWEEN checkInDate "+
            "AND checkOutDate " +
            "OR :end BETWEEN checkInDate " +
            "AND checkOutDate)")
    List<Room> findByAvailableDateBetween(@Param("start") Date from, @Param("end") Date to);
    /*@Transactional
    @Modifying
    @Query(value = "select c* from Room LEFT JOIN Booking ON c.id=Booking.roomId Where check_in_date BETWEEN :startDate AND :endDate ")
    List<Room> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate")Date endDate);*/

}
