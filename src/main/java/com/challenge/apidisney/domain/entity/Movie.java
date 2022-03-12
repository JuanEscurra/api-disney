package com.challenge.apidisney.domain.entity;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "movies")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Identificador unico de la pelicula", position = 1)
    private Long id;

    @ApiModelProperty(value = "Imagen representativa de la pelicula", position = 2)
    private String image;

    @Column(unique = true, nullable = false)
    @ApiModelProperty(value = "Titulo de la pelicula", position = 3)
    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @ApiModelProperty(value = "Fecha de estreno de la pelicula", position = 4)
    private LocalDate creationDate;

    @Column(precision = 1)
    @ApiModelProperty(value = "Valoración de la pelicula", position = 4, notes = "0-5", dataType = "int")
    private Integer qualification;

    @ManyToMany
    @JoinTable(
            name = "movie_character",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private Set<Character> characters;

    @ManyToMany
    @JoinTable(
            name = "genre_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id.equals(movie.id) && title.equals(movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                ", qualification=" + qualification +
                '}';
    }
}
