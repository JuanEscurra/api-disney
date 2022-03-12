package com.challenge.apidisney;

import com.challenge.apidisney.domain.dao.GenreRepository;
import com.challenge.apidisney.domain.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ApiDisneyApplication {
    /*
    @Autowired
    private GenreRepository genreRepository;*/

    public static void main(String[] args) {
        SpringApplication.run(ApiDisneyApplication.class, args);
    }

    /*
    @Bean
    CommandLineRunner runner() {
        return args -> {
            System.out.println("insertGenres");
            List<Genre> genres = List.of(
                    new Genre(1, "Comedia","https://3.bp.blogspot.com/-pksXJ_FOEtc/TantbTEuHCI/AAAAAAAAAGw/Na9Q-21qcGE/s1600/LasSindrome2.jpg"),
                    new Genre(2, "Ciencia Ficción", "https://3.bp.blogspot.com/-pksXJ_FOEtc/TantbTEuHCI/AAAAAAAAAGw/Na9Q-21qcGE/s1600/LasSindrome2.jpg"),
                    new Genre(3, "Musical", "https://3.bp.blogspot.com/-pksXJ_FOEtc/TantbTEuHCI/AAAAAAAAAGw/Na9Q-21qcGE/s1600/LasSindrome2.jpg"),
                    new Genre(4, "Fantasia", "https://3.bp.blogspot.com/-pksXJ_FOEtc/TantbTEuHCI/AAAAAAAAAGw/Na9Q-21qcGE/s1600/LasSindrome2.jpg"),
                    new Genre(5, "Drama", "https://3.bp.blogspot.com/-pksXJ_FOEtc/TantbTEuHCI/AAAAAAAAAGw/Na9Q-21qcGE/s1600/LasSindrome2.jpg")
            );
            genreRepository.saveAll(genres);
        };
    }
    */
}
