package com.spring.Valgykla.service;

import com.spring.Valgykla.model.Genre;
import com.spring.Valgykla.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public void save(Genre genre) {
        genreRepository.save(genre);
    }
    @Override
    public List<String> findAllGenreNames() {
        return genreRepository.findAllGenreNames();
    }
    @Override
    public List<Genre> findAll(){
        return genreRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        genreRepository.deleteById(id);
    }

    @Override
    public Optional<Genre> findById(int id) {
        return genreRepository.findById(id);
    }

}
