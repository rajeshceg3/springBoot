package com.restapi.crud;
import java.util.List;
import com.restapi.crud.Movie;

import java.util.Optional;

public interface MovieServiceInterface{
    List<Movie> getAllMovies();
    Optional<Movie> getMovieById(long id);
    Movie createMovie(Movie movie);
    Movie updateMovie(Movie movie);
    void deleteMovie(long id);   
}