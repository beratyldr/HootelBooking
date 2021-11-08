package com.kodluyoruz.demo.repository;

import com.kodluyoruz.demo.model.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    List<Hotel> findAllByAddressTownContainsAndAddressProvinceContains(String town,String province);

}
