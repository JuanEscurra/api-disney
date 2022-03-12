package com.challenge.apidisney.domain.entity;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "characters")
@ApiModel(description = "Representa a un personaje de disney")
public class Character implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Identificador unico del personaje", position = 1)
    private Long id;

    @ApiModelProperty(value = "Imagen del personaje", position = 2)
    private String image;

    @Column(unique = true, nullable = false)
    @ApiModelProperty(value = "Nombre del personaje", required = true, example = "Micky mouse", position = 3)
    private String name;

    @ApiModelProperty(value = "Edad del personaje", example = "12", position = 4)
    private Integer age;

    @Column(scale = 2)
    @ApiModelProperty(value = "Peso del personaje", example = "12.54", position = 5)
    private Float weight;

    @Column(length = 1200)
    @ApiModelProperty(value = "Historia del personaje", position = 6)
    private String history;

    @ManyToMany(mappedBy = "characters")
    @JsonBackReference
    @ApiModelProperty(value = "Conjunto de peliculas en las que ha participado", position = 7)
    private Set<Movie> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return id.equals(character.id) && name.equals(character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", history='" + history + '\'' +
                '}';
    }


}
