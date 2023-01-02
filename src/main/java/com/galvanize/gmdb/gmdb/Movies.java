package com.galvanize.gmdb.gmdb;

import org.glassfish.jaxb.core.v2.model.core.ID;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="title")
    private String title;
    @Column(name="year_released")
    private int yearReleased;
    @Column(name="genre")
    private String genre;
    @Column(name="runtime")
    private String runtime;

    protected Movies(){
        
    }

    public Movies(String title, int yearReleased, String genre, String runtime) {
        this.title = title;
        this.yearReleased = yearReleased;
        this.genre = genre;
        this.runtime = runtime;
    }




    
    
    
}
