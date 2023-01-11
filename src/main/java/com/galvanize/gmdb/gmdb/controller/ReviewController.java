package com.galvanize.gmdb.gmdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galvanize.gmdb.gmdb.model.Review;
import com.galvanize.gmdb.gmdb.repository.IReviewsRepository;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private  IReviewsRepository repository;

    // public MoviesController(IMoviesRepository repository){
    //     this.repository = repository;
    // }

    @PostMapping("")  
    public void createMovies(@RequestBody Review review) {
        this.repository.save(review);
    }
}
