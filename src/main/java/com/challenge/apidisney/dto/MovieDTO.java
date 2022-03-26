package com.challenge.apidisney.dto;

import com.challenge.apidisney.domain.entity.Character;
import com.challenge.apidisney.domain.entity.Genre;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@Data
public class MovieDTO {

    private Long id;
    private String image;

    @NotEmpty(message = "{title.not.empty}")
    @Size(min = 3, message = "{title.no-size.valid}")
    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate creationDate;

    @NotNull(message = "{qualification.not.null}")
    @Min(value = 0, message = "{qualification.not-min.valid}")
    @Max(value = 5, message = "{qualification.not-max.valid}")
    private Integer qualification;

    private Set<CharacterDTO> characters;
    private Set<GenreDTO> genres;

}
