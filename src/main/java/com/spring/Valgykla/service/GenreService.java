package com.spring.Valgykla.service;

import com.spring.Valgykla.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    void save(Genre genre);

    List<String> findAllGenreNames();
    List<Genre> findAll();

    void deleteById(int id);

    Optional<Genre> findById(int id);
}
