import org.springframework.data.mongodb.repository.MongoRepository;
import Movie;

public interface MovieRepository extends MongoRepository<Movie, Long>{
    
}