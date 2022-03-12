package com.challenge.apidisney.controllers;

import  com.challenge.apidisney.domain.dao.CharacterRepository;
import com.challenge.apidisney.domain.entity.Character;
import com.challenge.apidisney.domain.projections.CharacterIN;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "characters")
@Api(description = "Conjunto de operaciones para manipular entidades de personajes", tags = "Personajes")
public class CharacterController {

    private final CharacterRepository repository;

    @Autowired
    public CharacterController(CharacterRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ApiOperation(value = "Busca todos los personajes")
    public ResponseEntity<List<CharacterIN>> findAll() {
        List<CharacterIN> characters = repository.findAll(CharacterIN.class);
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca un personaje por id ingresado")
    public ResponseEntity<Character> findById(@PathVariable Long id) {
        Character character = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("El personaje con id " + id + " no existe.");
        });
        return new ResponseEntity<>(character, HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT}, consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Guarda un personaje")
    public ResponseEntity<Character> save(@RequestBody Character character) {
        System.out.println("character = " + character);
        Character newCharacter = repository.save(character);
        if(newCharacter != null) {
            return new ResponseEntity<>(newCharacter, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Elimina un personaje por id ingresado")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Character character = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("El personaje con id " + id + " no existe.");
        });

        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(params = {"name"})
    @ApiOperation(value = "Busca personajes según la coincidencia de sus nombres (%_%))")
    public ResponseEntity<List<Character>> findByName(
            @ApiParam() @RequestParam String name) {
        System.out.println("name: " + name);
        List<Character> characters = repository.findByNameContaining(name);

        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

    @GetMapping(params = {"age"})
    @ApiOperation(value = "Busca personajes según la edad ingresada)", hidden = true)
    public ResponseEntity<List<Character>> findByAge(@RequestParam int age) {
        List<Character> characters = repository.findByAge(age);
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

    @GetMapping(params = {"movies"})
    @ApiOperation(value = "Busca personajes que hayan participado en una pelicula o serie (id)", hidden = true)
    public ResponseEntity<List<CharacterIN>> findByMovie(@RequestParam(name = "movies") long idMovie) {
        List<CharacterIN> characters = repository.findByMovies(idMovie, CharacterIN.class);
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }
}
