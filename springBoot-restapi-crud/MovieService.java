import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Movie;

@Service
@Transactional
public class MovieService implements MovieServiceInterface{
    
    @Autowired
    private MovieRepository movierepository;

    @Override
    public Movie createMovie(Movie movie){
        return movierepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie){
       Optional<Movie> movieDB = movierepository.findById(movie.getID());
       if( movieDB.isPresent()){
           Movie movieUpdate = movieDB.get();
           movieUpdate.setID(movie.getID());
           movieUpdate.setName(movie.getName());
           movieUpdate.setDescription(movie.getDescription());
           movierepository.save(movieUpdate);
           return movieUpdate;
       }
       else{
           throw new ResourceNotFoundException("Resource not found with ID " + movie.getID());
       }
    }

    @Override
    public List<Movie> getAllMovies(){
        return movierepository.findAll();
    }

    @Override
    public Movie getMovieById(long id){
        Optional<Movie> movieDB = movierepository.findById(id);
        if( movieDB.isPresent()){
            return movieDB.get();
        }
        else{
            throw new ResourceNotFoundException("Movie not found with id " + id);
        }
    }

    @Override
    public void deleteMovie(long id){
        Optional<Movie> movieDB = movierepository.findById(id);
        if (movieDB.isPresent()){
            movierepository.delete(movieDB.get());
        }
        else{
            throw new ResourceNotFoundException("Movie not found with id "+ id);
        }
    }
}