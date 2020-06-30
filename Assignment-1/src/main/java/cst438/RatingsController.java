package cst438;

import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RatingsController {

	@Autowired
	MovieRatingRepository movieRatingRepository;
	
	@GetMapping("/movies/new")
	public String addMovieRating(Model model) {
		MovieRating movieRating = new MovieRating();
		model.addAttribute("movieRating", movieRating);
		return "rating_form";
	}
	
	@PostMapping("/movies")
	public String processRatingForm(@Valid MovieRating movieRating, 
			BindingResult result, 
			Model model) {
		if (result.hasErrors()) {
			return "rating_form";
		}
		SimpleDateFormat formatter = new SimpleDateFormat("M-dd-yyyy hh:mm");
		String dateString = formatter.format(new java.util.Date()); 
		movieRating.setDateTime(dateString);
		movieRatingRepository.save(movieRating);
		Iterable<MovieRating> ratings = movieRatingRepository.findAllMovieRatingsOrderByTitleDateDesc();
		model.addAttribute("movieRatings", ratings);
		return "rating_list";
	}
	
	@GetMapping("/movies")
	public String getAllRatings(Model model) {
		Iterable<MovieRating> ratings = movieRatingRepository.findAllMovieRatingsOrderByTitleDateDesc();
		model.addAttribute("movieRatings", ratings);
		return "rating_list";
	}
}
