package com.movie.collection.app.service;

import com.movie.collection.app.model.Actor;
import java.util.List;

public interface ActorService {

    public Actor findById(Long id) ;

    public Actor save(Actor model);

    public Actor getById(Long id);

    public void delete(Long id) ;

    public List<Actor> list();
}