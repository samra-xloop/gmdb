package com.galvanize.gmdb.gmdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galvanize.gmdb.gmdb.model.Movie;

@Repository
public interface IMoviesRepository extends JpaRepository<Movie, Long>{

//    public List<Movie> findAll();

    // public Movie findByTitle()
    

    
}
