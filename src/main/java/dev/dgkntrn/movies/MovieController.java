package dev.dgkntrn.movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return movieService.allMovies().isEmpty() ? new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.NO_CONTENT)
                : new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Movie> getSingleMovie(@PathVariable String imdbId) {
        return movieService.singleMovie(imdbId) == null ? new ResponseEntity<Movie>(movieService.singleMovie(imdbId),HttpStatus.NOT_FOUND)
                : new ResponseEntity<Movie>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }    
}
