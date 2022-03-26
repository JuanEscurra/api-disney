package com.challenge.apidisney.controllers;

import com.challenge.apidisney.domain.dao.MovieRepository;
import com.challenge.apidisney.domain.entity.Movie;
import com.challenge.apidisney.domain.projections.MovieITF;
import com.challenge.apidisney.dto.MovieDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "movies")
public class MovieController {

    private final MovieRepository repository;
    private final ObjectMapper mapper;

    @Autowired
    public MovieController(MovieRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<MovieITF>> findAll() {
        List<MovieITF> movies = repository.findAll(MovieITF.class);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
        Movie movie = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("El personaje con id " + id + " no existe.");
        });
        return new ResponseEntity<>(mapper.convertValue(movie, MovieDTO.class), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<MovieDTO> save(@Valid @RequestBody MovieDTO movieDTO) {
        Movie newMovie = repository.save(mapper.convertValue(movieDTO, Movie.class));
        return new ResponseEntity<>(mapper.convertValue(newMovie, MovieDTO.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        Movie movie = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("La pelicula o serie con id " + id + " no existe.");
        });
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(params = {"name"})
    public ResponseEntity<List<MovieITF>> findByName(@RequestParam String name) {
        List<MovieITF> movies = repository.findByTitleContaining(name, MovieITF.class);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(params = {"genre"})
    public ResponseEntity<List<MovieITF>> findByGenre(@RequestParam(name = "genre") int id) {
        List<MovieITF> movies = repository.findByGenres(id, MovieITF.class);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(params = {"order"})
    public ResponseEntity<List<MovieITF>> sortList(@RequestParam String order) {
        List<MovieITF> movies = repository.findAllAndOrderByCreationDate(MovieITF.class);
        if(order.equals("ASC")) return new ResponseEntity<>(movies, HttpStatus.OK);
        Collections.reverse(movies);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
}
