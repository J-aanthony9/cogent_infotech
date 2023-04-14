package cogent.infotech.com.controller;

import cogent.infotech.com.entity.Movie;
import cogent.infotech.com.exceptions.ResourceNotFoundException;
import cogent.infotech.com.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id " + id));
        movie.setName(updatedMovie.getName());
        movie.setReleaseDate(updatedMovie.getReleaseDate());
        movie.setGenre(updatedMovie.getGenre());
        return movieRepository.save(movie);
    }

    @GetMapping("/{name}")
    public Movie getMovieByName(@PathVariable String name) {
        return movieRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with name " + name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getAllMoviesByGenre(@PathVariable String genre) {
        return movieRepository.findByGenre(genre);
    }
}

