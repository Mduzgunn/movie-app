package com.movie.collection.app.controller;


import com.movie.collection.app.model.Actor;
import com.movie.collection.app.model.Movie;

import com.movie.collection.app.service.ActorService;
import com.movie.collection.app.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("movie")
public class MovieController {

    private MovieService movieService;
    private ActorService actorService;

    public MovieController(MovieService movieService, ActorService actorService) {
        this.movieService = movieService;
        this.actorService = actorService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Movie> movies = movieService.list();
        model.addAttribute("movies", movies);
        return "movieList";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("movie") Movie movie) {
        movieService.save(movie);
        return "redirect:/movie/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        movieService.delete(id);
        return "redirect:/movie/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Movie movie = movieService.getById(id);
        model.addAttribute("actors", actorService.list());
        model.addAttribute("movie", movie);
        return "newMovie";
    }

    @GetMapping("/add-movie")
    public String add(Model model) {
        Movie movie = new Movie();
        List<Actor> actors = actorService.list();
        model.addAttribute("actors", actors);
        model.addAttribute("movie", movie);
        return "newMovie";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        List<Movie> movies = movieService.search(search);
        model.addAttribute("movies", movies);
        return "movieList";
    }

    @GetMapping("/sort-date")
    public String sortDate(Model model) {
        List<Movie> movies = movieService.sortDate();
        model.addAttribute("movies", movies);
        return "movieList";
    }
}