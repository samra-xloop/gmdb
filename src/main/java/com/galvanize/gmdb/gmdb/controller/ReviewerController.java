package com.galvanize.gmdb.gmdb.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galvanize.gmdb.gmdb.model.Reviewer;
import com.galvanize.gmdb.gmdb.repository.IReviewersRepository;

@RestController
@RequestMapping("/reviewers")
public class ReviewerController {
    @Autowired
    public IReviewersRepository repository;


    @GetMapping("")
    public List<Reviewer> getAllReviewers(){
        return this.repository.findAll();
    }
    @GetMapping("/{id}") 
    public Reviewer getById(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }

    @PostMapping("")  
    public void createMovies(@RequestBody Reviewer reviewer) {
        reviewer.setNumber_of_reviews(0);
        reviewer.setJoining_date(Date.valueOf(LocalDate.now()));
        this.repository.save(reviewer);
    }

    
}
