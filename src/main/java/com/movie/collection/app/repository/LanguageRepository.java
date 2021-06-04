package com.movie.collection.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.collection.app.model.Languages;

public interface LanguageRepository extends JpaRepository<Languages, Integer> {

}