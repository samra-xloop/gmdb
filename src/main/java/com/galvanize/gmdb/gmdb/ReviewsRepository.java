package com.galvanize.gmdb.gmdb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepository extends CrudRepository<Reviews, Long>{
 
}
