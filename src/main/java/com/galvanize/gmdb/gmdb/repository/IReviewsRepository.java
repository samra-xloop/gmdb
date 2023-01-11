package com.galvanize.gmdb.gmdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.galvanize.gmdb.gmdb.model.Review;

@Repository
public interface IReviewsRepository extends JpaRepository<Review, Long>{
    List<Review> findByMovieId(Long movieId);
 
}
