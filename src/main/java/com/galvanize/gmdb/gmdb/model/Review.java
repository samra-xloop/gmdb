package com.galvanize.gmdb.gmdb.model;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    // private Long movieId;
    // private Long reviewerId;
    private String reviewText;

    @Column(columnDefinition = "date")
    private Date dateTime_last_modified;
    // @ManyToOne(fetch = FetchType.LAZY)
    // // @JoinColumn(name="movieId")
    // private Movies movie;
    @ManyToOne
    @JoinColumn(name="movie_id",referencedColumnName = "id",nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    // @JsonBackReference
    @JsonIgnore
    private Movie movie;

    protected Review(){}

    public Review(String reviewText) {
        // this.movieId = movieId;
        // this.reviewerId = reviewerId;
        Date review_date= new Date();
        this.reviewText = reviewText;
        this.dateTime_last_modified = review_date;
    }

    // public long getReviewId() {
    //     return reviewId;
    // }

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

    public Date getDateTime() {
        return dateTime_last_modified;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime_last_modified = dateTime;
    }
//     @Override
//     public boolean equals(Object o) {
//     if (this == o) return true ;
//     if (!(o instanceof Reviews )) return false ;
//     return reviewId != null && reviewId.equals(((Reviews) o).getReviewerId());
//     }
//     @Override
//     public int hashCode() {
//     return getClass().hashCode();
// }



    

}




    
    
    

