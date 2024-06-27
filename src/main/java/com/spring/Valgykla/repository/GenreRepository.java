package com.spring.Valgykla.repository;

import com.spring.Valgykla.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    @Query("SELECT g.name FROM Genre g")
    List<String> findAllGenreNames();
}
