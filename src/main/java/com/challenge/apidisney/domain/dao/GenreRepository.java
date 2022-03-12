package com.challenge.apidisney.domain.dao;

import com.challenge.apidisney.domain.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
