package com.restapi.crud;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.restapi.crud.Movie;

public interface MovieRepository extends MongoRepository<Movie, Long>{
    
}