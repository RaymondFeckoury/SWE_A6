package com.example.service;

import java.util.List;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.model.Movie;

public interface MovieService {
	
	@ResponseBody
	List<Movie> getAllMovies();
	public void save(Movie movie);
	
}
