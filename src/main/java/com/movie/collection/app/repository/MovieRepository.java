package com.movie.collection.app.repository;

import com.movie.collection.app.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT movie FROM Movie movie WHERE" +
            " (UPPER(movie.name) LIKE %:search%) " +
            " OR (UPPER(movie.type) LIKE %:search%) ")
    List<Movie> findBySearch(@Param("search") String search);

    @Query("SELECT movie  FROM Movie movie ORDER BY year DESC ")
    List<Movie> findAllByDate();
}
