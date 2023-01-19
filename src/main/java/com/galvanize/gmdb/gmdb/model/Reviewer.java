package com.galvanize.gmdb.gmdb.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name="reviwers")
public class Reviewer {

    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(columnDefinition = "date") 
    @JsonFormat(pattern = "YYYY-MM-DD")
    private Date joining_date;
    private Integer number_of_reviews;


    // Constructors
    protected Reviewer(){}
    public Reviewer(Long id,String username, Date joining_date, Integer num_of_reviews){
        this.id=id;
        this.username=username;
        this.joining_date=joining_date;
        this.number_of_reviews=num_of_reviews;
    }
    public Reviewer(String username){
        this.username = username;
    }


    //GETTERS & SETTERS
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(Date joining_date) {
        this.joining_date = joining_date;
    }

    public Integer getNumber_of_reviews() {
        return number_of_reviews;
    }

    public void setNumber_of_reviews(Integer number_of_reviews) {
        this.number_of_reviews = number_of_reviews;
    }

  
}
