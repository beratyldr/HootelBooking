package com.kodluyoruz.demo.repository;


import com.kodluyoruz.demo.model.entity.Booking;
import com.kodluyoruz.demo.model.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

    @Modifying
    @Transactional
    @Query("SELECT h FROM Hotel h WHERE h.id IN (SELECT a.hotelId FROM Room a WHERE a.id NOT IN " +
            "(SELECT roomId FROM Booking WHERE :start BETWEEN checkInDate "+
            "AND checkOutDate " +
            "OR :end BETWEEN checkInDate " +
            "AND checkOutDate OR :start <= checkInDate AND :end >= checkOutDate))" +
            "AND province LIKE CONCAT('%',:prov,'%') AND town LIKE CONCAT('%',:tow,'%' ) ")
    List<Hotel> findByAvailableDateBetween(@Param("prov") String province,@Param("tow") String town,@Param("start") Date from, @Param("end") Date to);



    @Transactional
    @Query("SELECT case when (count('*')=0) then true else false end as isEmpty FROM Booking b WHERE :start BETWEEN checkInDate "+
            "AND checkOutDate " +
            "OR :end BETWEEN checkInDate " +
            "AND checkOutDate OR :start <= checkInDate AND :end >= checkOutDate AND roomId=:rId  ")
    boolean CheckAvailableDateBetween(@Param("rId")Integer rId, @Param("start") Date from, @Param("end") Date to);




}
