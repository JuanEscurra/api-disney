package com.challenge.apidisney.controllers;

import com.challenge.apidisney.domain.dao.MovieRepository;
import com.challenge.apidisney.domain.entity.Movie;
import com.challenge.apidisney.domain.projections.MovieITF;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "movies")
@Api(description = "Conjunto de operaciones para manipular entidades de peliculas", tags = "Peliculas")
public class MovieController {

    private final MovieRepository repository;

    @Autowired
    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Busca todos las peliculas")
    public ResponseEntity<List<MovieITF>> findAll() {
        List<MovieITF> movies = repository.findAll(MovieITF.class);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca una pelicula según su identificador")
    public ResponseEntity<Movie> findById(@PathVariable Long id) {
        Movie movie = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("El personaje con id " + id + " no existe.");
        });
        System.out.println("movie = " + movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    @ApiOperation(value = "Guarda un pelicula")
    public ResponseEntity<Movie> save(@RequestBody Movie movie) {
        Movie newMovie = repository.save(movie);

        if(newMovie != null) {
            return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Elimina un personaje por el identificador")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        Movie movie = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("La pelicula o serie con id " + id + " no existe.");
        });
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(params = {"name"})
    @ApiOperation(value = "Buscar peliculas por coincidencias con el nombre (%_%)", tags = "Peliculas")
    public ResponseEntity<List<MovieITF>> findByName(@RequestParam String name) {
        List<MovieITF> movies = repository.findByTitleContaining(name, MovieITF.class);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(params = {"genre"})
    @ApiOperation(value = "Buscar peliculas según genero")
    public ResponseEntity<List<MovieITF>> findByGenre(@RequestParam(name = "genre") int id) {

        List<MovieITF> movies = repository.findByGenres(id, MovieITF.class);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(params = {"order"})
    @ApiOperation(value = "Buscar toda las peliculas y ordenarlo por fecha (ASC|DESC)")
    public ResponseEntity<List<MovieITF>> sortList(@RequestParam String order) {
        List<MovieITF> movies = repository.findAllAndOrderByCreationDate(MovieITF.class);
        if(order.equals("ASC")) return new ResponseEntity<>(movies, HttpStatus.OK);
        Collections.reverse(movies);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
