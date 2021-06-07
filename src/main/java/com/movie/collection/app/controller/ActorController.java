package com.movie.collection.app.controller;

import com.movie.collection.app.model.Actor;
import com.movie.collection.app.service.ActorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("actor")
public class ActorController {

    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Actor> actors = actorService.list();
        model.addAttribute("actors", actors);
        return "actorList";
    }

    @GetMapping("/add-actor")
    public String add(Model model) {
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        return "newActor";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        actorService.delete(id);
        return "redirect:/actor/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Actor actor = actorService.getById(id);
        model.addAttribute("actor", actor);
        return "newActor";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("actor") Actor actor) {
        actorService.save(actor);
        return "redirect:/actor/list";
    }
}