package com.spring.Valgykla.service;

import com.spring.Valgykla.model.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    void save(Menu menu);
    List<Menu> getAll();
    void deleteById(int id);
    Optional<Menu> findById(int id);
    List<Menu> findMealsByTitle(String query);
    List<Menu> findMealsByReservationId(int id);
    List<Menu> findByIdIn(List<Integer> ids);

    List<Menu> findMenuByReservationId(int userId);
}
