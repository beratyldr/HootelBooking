package com.kodluyoruz.demo.repository;

import com.kodluyoruz.demo.model.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer> {

}