package com.galvanize.gmdb.gmdb.model;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

// 2. As a user
    //    I can provide a movie ID and get back the record shown in story 1, plus a list of reviews that contains Review ID | Movie ID | Reviewer ID | Review Text | DateTime last modified
    //    so that I can read the reviews for a movie.

@Entity
@Table(name="reviews")
public class Review {
    // Review ID | Movie ID | Reviewer ID | Review Text | DateTime last modified
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;


    private String reviewText;

    @Column(columnDefinition = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateTime_last_modified;


    
    @ManyToOne
    @JoinColumn(name="movie_id",referencedColumnName = "id",nullable = false)
    @JsonIgnore
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="reviewer_id",referencedColumnName = "id",nullable = false)
    @JsonIgnore
    private Reviewer reviewer;

    protected Review(){}

    public Review(String reviewText) {
        this.reviewText = reviewText;
    }

    public long getReviewId() {
        return reviewId;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer= reviewer;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public Date getDateTime() {
        return dateTime_last_modified;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime_last_modified = dateTime;
    }

    public Long getId(){
        return this.reviewId;
    }

    public void setId(Long reviewId){
        this.reviewId=reviewId;
    }
}




    
    
    

