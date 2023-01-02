package com.galvanize.gmdb.gmdb;

import org.glassfish.jaxb.core.v2.model.core.ID;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// 2. As a user
    //    I can provide a movie ID and get back the record shown in story 1, plus a list of reviews that contains Review ID | Movie ID | Reviewer ID | Review Text | DateTime last modified
    //    so that I can read the reviews for a movie.

@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reviewId;
    // private long movieId;
    // private long reviewerId;
    private String reviewText;
    private String dateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    private Movies movie;

    protected Reviews(){}

    public Reviews(String reviewText, String dateTime) {
        // this.movieId = movieId;
        // this.reviewerId = reviewerId;
        this.reviewText = reviewText;
        this.dateTime = dateTime;
    }

    public long getReviewId() {
        return reviewId;
    }

    // public long getMovieId() {
    //     return movieId;
    // }

    // public void setMovieId(long movieId) {
    //     this.movieId = movieId;
    // }

    // public long getReviewerId() {
    //     return reviewerId;
    // }

    // public void setReviewerId(long reviewerId) {
    //     this.reviewerId = reviewerId;
    // }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }




    


    

    

    

}




    
    
    

