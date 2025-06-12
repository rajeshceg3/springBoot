package com.restapi.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import com.restapi.crud.Movie;
// ApiPaths import is not strictly necessary if using fully qualified names,
// but good practice if used frequently. For this overwrite, direct use is fine.

@RestController
public class MovieController{

    @Autowired
    private MovieService movieservice;

    @GetMapping(ApiPaths.MOVIES_BASE) // Use constant
    public ResponseEntity<List<Movie>> getMovies(){
        return ResponseEntity.ok().body(movieservice.getAllMovies());
    }

    @GetMapping(ApiPaths.MOVIES_BY_ID) // Use constant
    public ResponseEntity<Movie> getMovieById(@PathVariable long id){
        Optional<Movie> movie = movieservice.getMovieById(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok().body(movie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(ApiPaths.MOVIES_BASE) // Use constant
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie){
        return ResponseEntity.ok().body(movieservice.createMovie(movie));
    }

    @PutMapping(ApiPaths.MOVIES_BY_ID) // Use constant
    public ResponseEntity<Movie> updateMovie( @PathVariable long id, @Valid @RequestBody Movie movie){
        movie.setId(id);
        return ResponseEntity.ok().body(movieservice.updateMovie(movie));
    }

    @DeleteMapping(ApiPaths.MOVIES_BY_ID) // Use constant
    public HttpStatus deleteMovie(@PathVariable long id){
        movieservice.deleteMovie(id);
        return HttpStatus.OK;
    }
}
