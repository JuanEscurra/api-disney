package com.challenge.apidisney.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class GenreDTO {

    private Integer id;

    @NotEmpty(message = "{name.not.empty}")
    @Size(min = 3, message = "{name.not-size.valid}")
    private String name;

    private String image;
}
