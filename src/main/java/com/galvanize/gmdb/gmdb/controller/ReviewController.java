package com.galvanize.gmdb.gmdb.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galvanize.gmdb.gmdb.model.Movie;
import com.galvanize.gmdb.gmdb.model.Review;
import com.galvanize.gmdb.gmdb.model.Reviewer;
import com.galvanize.gmdb.gmdb.repository.IMoviesRepository;
import com.galvanize.gmdb.gmdb.repository.IReviewersRepository;
import com.galvanize.gmdb.gmdb.repository.IReviewsRepository;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private  IReviewsRepository review_repo;
    @Autowired
    private  IMoviesRepository movie_repo;
    @Autowired
    private  IReviewersRepository reviewer_repo;

    

    @PostMapping("/{reviwer_id}/{movie_id}")  
    public void createMovies(@RequestBody Review review, @PathVariable Long reviwer_id, @PathVariable Long movie_id) {
    
        Movie movie = movie_repo.findById(movie_id).orElse(null);
        Reviewer reviewer = reviewer_repo.findById(reviwer_id).orElse(null);
        reviewer.setNumber_of_reviews(reviewer.getNumber_of_reviews()+1);
        this.reviewer_repo.save(reviewer);
        review.setDateTime(Date.valueOf(LocalDate.now()));
        review.setMovie(movie);
        review.setReviewer(reviewer);
        review_repo.save(review);
    }
}
