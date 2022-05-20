import java.util.List;
import Movie;

public interface MovieServiceInterface{
 List<Movie> getAllMovies();
 Movie getMovieById(id);
 Movie createMovie(Movie movie);
 Movie updateMovie(id);
 void deleteMovie(id);   
}