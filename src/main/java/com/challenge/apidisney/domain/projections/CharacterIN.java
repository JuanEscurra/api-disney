package com.challenge.apidisney.domain.projections;

import com.challenge.apidisney.domain.entity.Character;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(subTypes = Character.class, description = "Representa un personaje de disney, pero con reducida información.")
public interface CharacterIN {

    @ApiModelProperty(value = "Identificador unico del personaje")
    Long getId();

    @ApiModelProperty(value = "Imagen del personaje")
    String getImage();

    @ApiModelProperty(value = "Nombre del personaje", required = true)
    String getName();
}
