package com.galvanize.gmdb.gmdb.model;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jaxb.core.v2.model.core.ID;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int yearReleased;
    private String genre;
    private Integer runtime;

    //parent class is movie where we have primary key(id)..... review is child class where the primary key becomes foreign key(movie_id)
    @OneToMany(
        mappedBy = "movie",  // movie is the name of the table in database
        cascade = CascadeType.ALL
        // targetEntity = Review.class
    )    
    private List<Review> reviews;

    protected Movie(){
        
    }


    public Movie(String title, int yearReleased, String genre, Integer runtime) {
        this.title = title;
        this.yearReleased = yearReleased;
        this.genre = genre;
        this.runtime = runtime;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}




    
    
    

