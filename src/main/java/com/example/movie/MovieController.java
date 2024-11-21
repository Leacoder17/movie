
package com.example.movie;

import com.example.movie.Movie;

import com.example.movie.MovieService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class MovieController {

    MovieService movieservice = new MovieService();

    @GetMapping("/movies")
    public ArrayList<Movie> getMovies() {
        return movieservice.getAllMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") int movieId) {
        return movieservice.getMovieById(movieId);
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieservice.addRecipe(movie);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable("movieId") int movieId, @RequestBody Movie movie) {
        return movieservice.updateMovie(movieId, movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieId) {
        movieservice.deleteMovie(movieId);
    }

}