package com.movie.collection.app.repository;

import com.movie.collection.app.model.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genres, Integer> {

}