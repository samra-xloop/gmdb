package com.galvanize.gmdb.gmdb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.galvanize.gmdb.gmdb.model.Movie;

@Repository
public interface IMoviesRepository extends JpaRepository<Movie, Long>{

    List<Movie> findAll();
    Movie getMovieById(long id);
    Optional<Movie> findById(Long id);
    

    
}
