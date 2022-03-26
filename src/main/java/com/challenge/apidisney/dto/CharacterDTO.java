package com.challenge.apidisney.dto;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class CharacterDTO {

    private Long id;

    private String image;

    @Size(min = 3, message = "{name.not-size.valid}")
    @NotEmpty(message = "{name.not.empty}")
    private String name;

    @Min(value = 0, message = "{age.not-min.valid}")
    private Integer age;

    @Min(value = 0, message = "{weight.not-min.valid}")
    private Float weight;

    @NotEmpty(message = "{history.not.empty}")
    private String history;

    private Set<MovieDTO> movies;

    public CharacterDTO() {
    }

}
