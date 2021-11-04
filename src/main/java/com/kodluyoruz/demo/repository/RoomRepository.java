package com.kodluyoruz.demo.repository;

import com.kodluyoruz.demo.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}