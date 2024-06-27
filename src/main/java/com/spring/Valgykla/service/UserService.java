package com.spring.Valgykla.service;


import com.spring.Valgykla.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
