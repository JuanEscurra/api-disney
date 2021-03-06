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
import org.openapitools.client.model.Movie;

/**
 * Representa a un personaje de disney
 */
@ApiModel(description = "Representa a un personaje de disney")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-03-25T21:17:28.839150-05:00[America/Lima]")
public class Character1 {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Long id;

  public static final String SERIALIZED_NAME_IMAGE = "image";
  @SerializedName(SERIALIZED_NAME_IMAGE)
  private String image;

  public static final String SERIALIZED_NAME_NAME = "name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_AGE = "age";
  @SerializedName(SERIALIZED_NAME_AGE)
  private Integer age;

  public static final String SERIALIZED_NAME_WEIGHT = "weight";
  @SerializedName(SERIALIZED_NAME_WEIGHT)
  private Float weight;

  public static final String SERIALIZED_NAME_HISTORY = "history";
  @SerializedName(SERIALIZED_NAME_HISTORY)
  private String history;

  public static final String SERIALIZED_NAME_MOVIES = "movies";
  @SerializedName(SERIALIZED_NAME_MOVIES)
  private List<Movie> movies = null;


  public Character1 id(Long id) {
    
    this.id = id;
    return this;
  }

   /**
   * Identificador unico del personaje
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Identificador unico del personaje")

  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public Character1 image(String image) {
    
    this.image = image;
    return this;
  }

   /**
   * Imagen del personaje
   * @return image
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Imagen del personaje")

  public String getImage() {
    return image;
  }


  public void setImage(String image) {
    this.image = image;
  }


  public Character1 name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Nombre del personaje
   * @return name
  **/
  @ApiModelProperty(example = "Micky mouse", required = true, value = "Nombre del personaje")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public Character1 age(Integer age) {
    
    this.age = age;
    return this;
  }

   /**
   * Edad del personaje
   * @return age
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "12", value = "Edad del personaje")

  public Integer getAge() {
    return age;
  }


  public void setAge(Integer age) {
    this.age = age;
  }


  public Character1 weight(Float weight) {
    
    this.weight = weight;
    return this;
  }

   /**
   * Peso del personaje
   * @return weight
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "12.54", value = "Peso del personaje")

  public Float getWeight() {
    return weight;
  }


  public void setWeight(Float weight) {
    this.weight = weight;
  }


  public Character1 history(String history) {
    
    this.history = history;
    return this;
  }

   /**
   * Historia del personaje
   * @return history
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Historia del personaje")

  public String getHistory() {
    return history;
  }


  public void setHistory(String history) {
    this.history = history;
  }


  public Character1 movies(List<Movie> movies) {
    
    this.movies = movies;
    return this;
  }

  public Character1 addMoviesItem(Movie moviesItem) {
    if (this.movies == null) {
      this.movies = new ArrayList<Movie>();
    }
    this.movies.add(moviesItem);
    return this;
  }

   /**
   * Conjunto de peliculas en las que ha participado
   * @return movies
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Conjunto de peliculas en las que ha participado")

  public List<Movie> getMovies() {
    return movies;
  }


  public void setMovies(List<Movie> movies) {
    this.movies = movies;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Character1 character1 = (Character1) o;
    return Objects.equals(this.id, character1.id) &&
        Objects.equals(this.image, character1.image) &&
        Objects.equals(this.name, character1.name) &&
        Objects.equals(this.age, character1.age) &&
        Objects.equals(this.weight, character1.weight) &&
        Objects.equals(this.history, character1.history) &&
        Objects.equals(this.movies, character1.movies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, image, name, age, weight, history, movies);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Character1 {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    history: ").append(toIndentedString(history)).append("\n");
    sb.append("    movies: ").append(toIndentedString(movies)).append("\n");
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

