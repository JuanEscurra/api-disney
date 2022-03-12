package com.challenge.apidisney.domain.dao;

import com.challenge.apidisney.domain.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    List<Character> findByNameContaining(String name);
    List<Character> findByAge(Integer age);

    @Query("select c from Character c join c.movies m where m.id=?1")
    <T> List<T> findByMovies(long id, Class<T> type);

    @Query("select c from Character c")
    <T> List<T> findAll(Class<T> type);
}
