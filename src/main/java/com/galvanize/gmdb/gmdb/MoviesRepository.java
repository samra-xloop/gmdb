package com.galvanize.gmdb.gmdb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Long>{

    Movies getMovieById(long id);
    

    
}
