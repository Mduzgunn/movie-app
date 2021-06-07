package com.movie.collection.app.service;

import com.movie.collection.app.model.Movie;
import java.util.List;

public interface MovieService {

    public Movie findById(Long id);
    public Movie save(Movie model);
    public Movie getById(Long id);
    public void delete(Long id);
    public List<Movie> list();
    public List<Movie> search(String search);
    public List<Movie> sortDate();

}