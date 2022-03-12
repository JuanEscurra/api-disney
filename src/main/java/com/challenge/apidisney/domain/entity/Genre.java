package com.challenge.apidisney.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "genres")
@ApiModel(description = "Representa un genero de una pelicula")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Identificador unico del genero", position = 1)
    private Integer id;

    @Column(unique = true, nullable = false)
    @ApiModelProperty(value = "Nombre del genero", position = 2)
    private String name;

    @ApiModelProperty(value = "Link de la imagen representativa", position = 3)
    private String image;

    public Genre() {
    }

    public Genre(Integer id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
}
