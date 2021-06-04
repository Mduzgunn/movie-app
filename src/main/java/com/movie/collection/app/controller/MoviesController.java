package com.movie.collection.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.movie.collection.app.model.Languages;
import com.movie.collection.app.model.Genres;
import com.movie.collection.app.model.Movies;
import com.movie.collection.app.Services.MoviesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
@RequestMapping("/movies")
public class MoviesController {

    private static final Logger LOG = LoggerFactory.getLogger(MoviesController.class);

    @Autowired
    private MoviesService moviesService;

    @RequestMapping(value = "/languages", method = RequestMethod.GET)
    public List<Languages> getAllLanguages() {
        return moviesService.getAllLanguages();
    }

    @RequestMapping(value = "/genres", method = RequestMethod.GET)
    public List<Genres> getAllGenres() {
        return moviesService.getAllGenres();
    }


    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    public List<Movies> getMovieInfo(@PathVariable("movieId") Integer movieId) {
        return moviesService.getMovieInfo(movieId);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Movies> getAllMovies() {
        LOG.info("Fetch all the Movies...");
        return moviesService.getAllMovies();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Movies> addMovie(@RequestBody Movies movie) {
        LOG.info("Add a Movies...");
        moviesService.addMovie(movie);
        return moviesService.getAllMovies();
    }

}