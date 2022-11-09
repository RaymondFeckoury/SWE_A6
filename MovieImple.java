package com.example.service.imple;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.repo.*;
import com.example.demo.model.Movie;
import com.example.service.MovieService;

@Service
public class MovieImple implements MovieService {
	
	@Autowired
	MovieRepo movierepo;
	
	@Override
	@ResponseBody
	public List<Movie> getAllMovies() {
		return movierepo.findAll();
	}
	
	
	@Override
	public void save(Movie movie) {
		movierepo.save(movie);
	}
	
}
