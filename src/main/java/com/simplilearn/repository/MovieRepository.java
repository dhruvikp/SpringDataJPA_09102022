package com.simplilearn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer>{

	
	// TODO : HOW DO YOU EXECUTE WHERE CONDITION QUERY?
	// TODO:  How do you execute JOIN Query ? One To Many replationship
}
