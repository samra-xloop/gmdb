package com.galvanize.gmdb.gmdb;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Long>{

    List<Movies> findAll();
    Movies getMovieById(long id);
    

    
}
