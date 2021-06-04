package com.movie.collection.app.Services;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.collection.app.controller.MoviesController;
import com.movie.collection.app.model.*;

import com.movie.collection.app.repository.*;

@Service
public class MoviesService {

    private static final Logger LOG = LoggerFactory.getLogger(MoviesService.class);

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MoviesRepository moviesRepository;


    public List<Languages> getAllLanguages() {
        return (List<Languages>) languageRepository.findAll();
    }

    public List<Genres> getAllGenres() {
        return (List<Genres>) genreRepository.findAll();
    }

    public List<Movies> getAllMovies() {
        List<Movies> list = (List<Movies>) moviesRepository.findAll();
        updateLanguageGenres(list);
        return list;
    }

    public void addMovie(Movies movie) {
        movie.setCreatedTimestamp(new Date());
        movie.setLastUpdtTimestamp(new Date());
        moviesRepository.save(movie);
    }

    public List<Movies> getMovieInfo(Integer movieId) {

        Optional<Movies> movieOptional = moviesRepository.findById(movieId);
        Movies movie = movieOptional.get();

        // Update Genre & Language
        List<Movies> list = Arrays.asList(new Movies[] { movie });
        updateLanguageGenres(list);

        return list;
    }

    private void updateLanguageGenres(List<Movies> list) {
        Map<Integer, String> languageMap = new HashMap<>();
        Map<Integer, String> genreMap = new HashMap<>();

        List<Languages> languageList = getAllLanguages();
        languageList.parallelStream().forEach(obj -> languageMap.put(obj.getId(), obj.getName()));

        List<Genres> genreList = getAllGenres();
        genreList.parallelStream().forEach(obj -> genreMap.put(obj.getId(), obj.getName()));

        list.parallelStream().forEach(obj -> {
            obj.setLanguage(languageMap.get(obj.getLanguageId()));
            obj.setGenre(genreMap.get(obj.getGenreId()));
        });

    }


}