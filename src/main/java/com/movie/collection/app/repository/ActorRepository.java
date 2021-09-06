package com.movie.collection.app.repository;


import com.movie.collection.app.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {


}