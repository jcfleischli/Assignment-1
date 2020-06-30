package cst438;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRatingRepository extends CrudRepository<MovieRating, Long> {
	
	@Query("select m from MovieRating m order by title, date_time desc")
	List<MovieRating> findAllMovieRatingsOrderByTitleDateDesc();
	
} 


