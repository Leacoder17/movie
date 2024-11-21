
package com.example.movie;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.example.movie.Movie;
import com.example.movie.MovieRepository;

import java.util.*;

// Do not modify the below code

public class MovieService implements MovieRepository {

    private static HashMap<Integer, Movie> movieList = new HashMap<>();

    public MovieService() {
        movieList.put(1, new Movie(1, "Avengers: Endgame", "Robert Downey Jr."));
        movieList.put(2, new Movie(2, "Avatar", "Sam Worthington"));
        movieList.put(3, new Movie(3, "Titanic", "Leonardo DiCaprio"));
        movieList.put(4, new Movie(4, "Star Wars: The Force Awakens", "Daisy Ridley"));
        movieList.put(5, new Movie(5, "Jurassic World", "Chris Pratt"));
    }

    // Do not modify the above code

    int uniqueId = 6;

    public ArrayList<Movie> getAllMovies() {
        Collection<Movie> movieCollection = movieList.values();
        ArrayList<Movie> Movies = new ArrayList<>(movieCollection);

        return Movies;
    }

    public Movie getMovieById(int movieId) {
        Movie movie = movieList.get(movieId);

        if (movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return movie;
    }

    public Movie addMovie(Movie movie) {
        movie.setMovieId(uniqueId);
        movieList.put(uniqueId, movie);
        uniqueId += 1;

        return movie;

    }

    public Movie updateMovie(int movieId, Movie movie) {
        Movie updatedmovie = movieList.get(movieId);

        if (updatedmovie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (movie.getMovieName() != null) {
            updatedmovie.setMovieName(movie.getMovieName());
        }
        if (movie.getLeadActor() != null) {
            updatedmovie.setLeadActor(movie.getLeadActor());
        }

        return updatedmovie;
    }

    public void deleteMovie(int movieId) {
        Movie movie = movieList.get(movieId);

        if (movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            movieList.remove(movieId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
