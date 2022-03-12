package com.challenge.apidisney.domain.dao;

import com.challenge.apidisney.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m")
    <T> List<T> findAll(Class<T> type);

    //@Query("select m from Movie m where lower(m.title) like concat('%', lower(?1), '%') ")
    <T> List<T> findByTitleContaining(String title, Class<T> type);

    @Query("select m from Movie m join m.genres g where g.id=?1")
    <T> List<T> findByGenres(int id, Class<T> type);

    @Query("select m from Movie m order by m.creationDate asc")
    <T> List<T> findAllAndOrderByCreationDate(Class<T> type);
}
