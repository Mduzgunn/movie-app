package com.movie.collection.app.controller;


import com.movie.collection.app.model.Actor;
import com.movie.collection.app.model.Movie;

import com.movie.collection.app.service.ActorService;
import com.movie.collection.app.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ActorService actorService;

    public MovieController() {

    }

    static List<String> languageList = null;
    static List<String> typeList = null;

    static {
        languageList = new ArrayList<>();
        languageList.add("Türkçe");
        languageList.add("Almanca");
        languageList.add("Fransizca");
    }

    static {
        typeList = new ArrayList<>();
        typeList.add("Korku");
        typeList.add("Gerilim");
        typeList.add("Aksiyon");
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Movie> movies = movieService.list();
        model.addAttribute("movies", movies);
        return "movieList";
    }


    @GetMapping("/listtest")
    public @ResponseBody
    List<Movie> listApi() {
        List<Movie> movies = movieService.list();
        return movies;
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
        model.addAttribute("languageList", languageList);
        model.addAttribute("typeList", typeList);
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