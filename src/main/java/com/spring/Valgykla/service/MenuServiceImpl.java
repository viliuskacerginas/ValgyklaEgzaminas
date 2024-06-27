package com.spring.Valgykla.service;

import com.spring.Valgykla.model.Menu;
import com.spring.Valgykla.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Override
    public void save(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public List<Menu> getAll(){
        return menuRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        menuRepository.deleteById(id);
    }
    @Override
    public Optional<Menu> findById(int id) {
        return menuRepository.findById(id);
    }

    @Override
    public List<Menu> findMealsByTitle(String query) {
        return menuRepository.findByNameContainingIgnoreCase(query);
    }

    @Override
    public List<Menu> findMealsByReservationId(int id) {
        return menuRepository.findByReservationId(id);
    }

    @Override
    public List<Menu> findByIdIn(List<Integer> ids) {
        return menuRepository.findByIdIn(ids);
    }

    @Override
    public List<Menu> findMenuByReservationId(int userId) {
        return null;
    }
}
