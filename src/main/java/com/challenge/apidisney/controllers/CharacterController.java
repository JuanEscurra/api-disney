package com.challenge.apidisney.controllers;

import com.challenge.apidisney.domain.dao.CharacterRepository;
import com.challenge.apidisney.domain.entity.Character;
import com.challenge.apidisney.domain.projections.CharacterIN;
import com.challenge.apidisney.dto.CharacterDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "characters")
public class CharacterController {

    private final CharacterRepository repository;
    private final ObjectMapper mapper;

    @Autowired
    public CharacterController(CharacterRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<CharacterIN>> findAll() {
        List<CharacterIN> characters = repository.findAll(CharacterIN.class);
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> findById(@PathVariable Long id) {
        Character character = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("El personaje con id " + id + " no existe.");
        });
        return new ResponseEntity<>(mapper.convertValue(character, CharacterDTO.class), HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT}, consumes = "application/json", produces = "application/json")
    public ResponseEntity<CharacterDTO> save(@Valid @RequestBody CharacterDTO characterDTO) {
        Character newCharacter = repository.save(mapper.convertValue(characterDTO, Character.class));
        if(newCharacter != null) {
            return new ResponseEntity<>(mapper.convertValue(newCharacter, CharacterDTO.class), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Character character = repository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("El personaje con id " + id + " no existe.");
        });
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(params = {"name"})
    public ResponseEntity<List<CharacterIN>> findByName(@RequestParam String name) {
        List<CharacterIN> characters = repository.findByNameContaining(name, CharacterIN.class);
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

    @GetMapping(params = {"age"})
    public ResponseEntity<List<CharacterIN>> findByAge(@RequestParam int age) {
        List<CharacterIN> characters = repository.findByAge(age, CharacterIN.class);
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

    @GetMapping(params = {"movies"})
    public ResponseEntity<List<CharacterIN>> findByMovie(@RequestParam(name = "movies") long idMovie) {
        List<CharacterIN> characters = repository.findByMovies(idMovie, CharacterIN.class);
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }
}
