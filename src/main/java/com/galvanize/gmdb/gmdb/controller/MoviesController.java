package com.galvanize.gmdb.gmdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galvanize.gmdb.gmdb.model.Movie;
import com.galvanize.gmdb.gmdb.model.Review;
import com.galvanize.gmdb.gmdb.repository.IMoviesRepository;
import com.galvanize.gmdb.gmdb.repository.IReviewsRepository;

@RestController
@RequestMapping("/movies")  
public class MoviesController {
    @Autowired
    private  IMoviesRepository repository;

    

    @PostMapping("")  
    public void createMovies(@RequestBody Movie movie) {
        this.repository.save(movie);
    }

    // 1. As a user
    //    I can GET a list of movies from GMDB that includes Movie ID | Movie Title | Year Released | Genre | Runtime
    //    so that I can see the list of available movies.
    @GetMapping("all")
    public List<Movie> getAllMovies() {
        return this.repository.findAll();
    }
    // 2. As a user
    //    I can provide a movie ID and get back the record shown in story 1, plus a list of reviews that contains Review ID | Movie ID | Reviewer ID | Review Text | DateTime last modified
    //    so that I can read the reviews for a movie.
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id){
        return this.repository.findById(id).orElse(null);
    }


    //      @GetMapping("/{id}")
    // public Movie getMovieById(@PathVariable Long id){
    //     return this.movieRepo.findById(id).orElse(null);
    // }


    

}