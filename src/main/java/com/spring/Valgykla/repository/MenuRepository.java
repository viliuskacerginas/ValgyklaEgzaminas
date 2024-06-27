package com.spring.Valgykla.repository;

import com.spring.Valgykla.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Menu> findByNameContainingIgnoreCase(String query);
    List<Menu> findByReservationId(int id);
    List<Menu> findByIdIn(List<Integer> ids);
}