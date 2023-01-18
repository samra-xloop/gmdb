package com.galvanize.gmdb.gmdb.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.galvanize.gmdb.gmdb.model.Review;


public interface IReviewsRepository extends JpaRepository<Review, Long>{
   
 
}
