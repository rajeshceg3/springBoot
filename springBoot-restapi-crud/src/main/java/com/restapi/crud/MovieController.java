package com.restapi.crud;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.restapi.crud.Movie;
import com.restapi.crud.MovieService;

@RestController
public class MovieController{

@Autowired
private MovieService movieservice;

@GetMapping("/movies")
public ResponseEntity<List<Movie>> getMovies(){
	return ResponseEntity.ok().body(movieservice.getMovies());
}

@GetMapping("/movies/{id}")
public ResponseEntity<Movie> getMovieById(@PathVariable long id){
	return ResponseEntity.ok().body(movieservice.getMovieById(id));
}

@PostMapping("/movies")
public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
	return ResponseEntity.ok().body(movieservice.createMovie(movie));
}

@PutMapping("/movies/{id}")
public ResponseEntity<Movie> updateMovie( @PathVariable long id,@RequestBody Movie movie){
	movie.setId(id);
	return ResponseEntity.ok().body(movieservice.updateMovie(movie));
}

@DeleteMapping("/movies/{id}")
public HttpStatus deleteMovie(@PathVariable long id){
	movieservice.deleteMovie(id);
	return HttpStatus.OK;
}
}
