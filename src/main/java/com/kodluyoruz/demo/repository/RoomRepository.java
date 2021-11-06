package com.kodluyoruz.demo.repository;

import com.kodluyoruz.demo.model.dto.RoomDto;
import com.kodluyoruz.demo.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Room b set b.availability= :available where b.id= :id")
    int setAvailability(@Param("id") Integer id, @Param("available") boolean available);

    @Modifying(clearAutomatically = true)
    @Query("SELECT b FROM Room b WHERE b.hotelId=:id and b.availability=true ")
    List<Room> getAvailableRoom(@Param("id") Integer id);
}