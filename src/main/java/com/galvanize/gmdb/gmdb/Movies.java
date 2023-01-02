package com.galvanize.gmdb.gmdb;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private int yearReleased;
    private String genre;
    private String runtime;

    @OneToMany(
        mappedBy = "Movies",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Reviews> reviews = new ArrayList<>();

    protected Movies(){
        
    }

    public Movies(String title, int yearReleased, String genre, String runtime) {
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

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

}




    
    
    

