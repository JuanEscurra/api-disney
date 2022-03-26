/*
 * REST API - DISNEY (CHALLENGE ALKEMY)
 * API para explorar el mundo de Disney, la cual permitirá conocer y modificar los personajes que lo componen y entender en qué películas estos participaron.
 *
 * The version of the OpenAPI document: v1.0.0
 * Contact: j.escurra.1999@gmail.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.Character;
import org.openapitools.client.model.Genre;

/**
 * Movie
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-25T21:17:28.839150-05:00[America/Lima]")
public class Movie {
  public static final String SERIALIZED_NAME_CHARACTERS = "characters";
  @SerializedName(SERIALIZED_NAME_CHARACTERS)
  private List<Character> characters = null;

  public static final String SERIALIZED_NAME_GENRES = "genres";
  @SerializedName(SERIALIZED_NAME_GENRES)
  private List<Genre> genres = null;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Long id;

  public static final String SERIALIZED_NAME_IMAGE = "image";
  @SerializedName(SERIALIZED_NAME_IMAGE)
  private String image;

  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  private String title;

  public static final String SERIALIZED_NAME_CREATION_DATE = "creationDate";
  @SerializedName(SERIALIZED_NAME_CREATION_DATE)
  private String creationDate;

  public static final String SERIALIZED_NAME_QUALIFICATION = "qualification";
  @SerializedName(SERIALIZED_NAME_QUALIFICATION)
  private Integer qualification;


  public Movie characters(List<Character> characters) {
    
    this.characters = characters;
    return this;
  }

  public Movie addCharactersItem(Character charactersItem) {
    if (this.characters == null) {
      this.characters = new ArrayList<Character>();
    }
    this.characters.add(charactersItem);
    return this;
  }

   /**
   * Get characters
   * @return characters
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<Character> getCharacters() {
    return characters;
  }


  public void setCharacters(List<Character> characters) {
    this.characters = characters;
  }


  public Movie genres(List<Genre> genres) {
    
    this.genres = genres;
    return this;
  }

  public Movie addGenresItem(Genre genresItem) {
    if (this.genres == null) {
      this.genres = new ArrayList<Genre>();
    }
    this.genres.add(genresItem);
    return this;
  }

   /**
   * Get genres
   * @return genres
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<Genre> getGenres() {
    return genres;
  }


  public void setGenres(List<Genre> genres) {
    this.genres = genres;
  }


  public Movie id(Long id) {
    
    this.id = id;
    return this;
  }

   /**
   * Identificador unico de la pelicula
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Identificador unico de la pelicula")

  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public Movie image(String image) {
    
    this.image = image;
    return this;
  }

   /**
   * Imagen representativa de la pelicula
   * @return image
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Imagen representativa de la pelicula")

  public String getImage() {
    return image;
  }


  public void setImage(String image) {
    this.image = image;
  }


  public Movie title(String title) {
    
    this.title = title;
    return this;
  }

   /**
   * Titulo de la pelicula
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Titulo de la pelicula")

  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public Movie creationDate(String creationDate) {
    
    this.creationDate = creationDate;
    return this;
  }

   /**
   * Fecha de estreno de la pelicula
   * @return creationDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Fecha de estreno de la pelicula")

  public String getCreationDate() {
    return creationDate;
  }


  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }


  public Movie qualification(Integer qualification) {
    
    this.qualification = qualification;
    return this;
  }

   /**
   * Valoración de la pelicula
   * @return qualification
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Valoración de la pelicula")

  public Integer getQualification() {
    return qualification;
  }


  public void setQualification(Integer qualification) {
    this.qualification = qualification;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Movie movie = (Movie) o;
    return Objects.equals(this.characters, movie.characters) &&
        Objects.equals(this.genres, movie.genres) &&
        Objects.equals(this.id, movie.id) &&
        Objects.equals(this.image, movie.image) &&
        Objects.equals(this.title, movie.title) &&
        Objects.equals(this.creationDate, movie.creationDate) &&
        Objects.equals(this.qualification, movie.qualification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(characters, genres, id, image, title, creationDate, qualification);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Movie {\n");
    sb.append("    characters: ").append(toIndentedString(characters)).append("\n");
    sb.append("    genres: ").append(toIndentedString(genres)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    qualification: ").append(toIndentedString(qualification)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

