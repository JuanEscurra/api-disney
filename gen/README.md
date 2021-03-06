# openapi-java-client

REST API - DISNEY (CHALLENGE ALKEMY)
- API version: v1.0.0
  - Build date: 2022-03-25T21:17:28.839150-05:00[America/Lima]

API para explorar el mundo de Disney, la cual permitirá conocer y modificar los
personajes que lo componen y entender en qué películas estos participaron.

  For more information, please visit [https://github.com/JuanEscurra](https://github.com/JuanEscurra)

*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>v1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "org.openapitools:openapi-java-client:v1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/openapi-java-client-v1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.GeneralesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    GeneralesApi apiInstance = new GeneralesApi(defaultClient);
    try {
      apiInstance.authLoginPost();
    } catch (ApiException e) {
      System.err.println("Exception when calling GeneralesApi#authLoginPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*GeneralesApi* | [**authLoginPost**](docs/GeneralesApi.md#authLoginPost) | **POST** /auth/login | login
*GeneralesApi* | [**registerUsingPOST**](docs/GeneralesApi.md#registerUsingPOST) | **POST** /auth/register | register
*PelculasApi* | [**deleteByIdUsingDELETE1**](docs/PelculasApi.md#deleteByIdUsingDELETE1) | **DELETE** /movies/{id} | Elimina un personaje por el identificador
*PelculasApi* | [**findByIdUsingGET1**](docs/PelculasApi.md#findByIdUsingGET1) | **GET** /movies/{id} | Busca una película según su identificador
*PelculasApi* | [**findByNameUsingGET1**](docs/PelculasApi.md#findByNameUsingGET1) | **GET** /movies | Buscar películas por coincidencias con el nombre (%_%)
*PelculasApi* | [**saveUsingPOST1**](docs/PelculasApi.md#saveUsingPOST1) | **POST** /movies | Guarda un película
*PelculasApi* | [**saveUsingPUT1**](docs/PelculasApi.md#saveUsingPUT1) | **PUT** /movies | Guarda un película
*PersonajesApi* | [**deleteByIdUsingDELETE**](docs/PersonajesApi.md#deleteByIdUsingDELETE) | **DELETE** /characters/{id} | Elimina un personaje por id ingresado
*PersonajesApi* | [**findByIdUsingGET**](docs/PersonajesApi.md#findByIdUsingGET) | **GET** /characters/{id} | Busca un personaje por id ingresado
*PersonajesApi* | [**findByNameUsingGET**](docs/PersonajesApi.md#findByNameUsingGET) | **GET** /characters | Busca personajes según la coincidencia de sus nombres (%_%))
*PersonajesApi* | [**saveUsingPOST**](docs/PersonajesApi.md#saveUsingPOST) | **POST** /characters | Guarda un personaje
*PersonajesApi* | [**saveUsingPUT**](docs/PersonajesApi.md#saveUsingPUT) | **PUT** /characters | Guarda un personaje


## Documentation for Models

 - [Character](docs/Character.md)
 - [Character1](docs/Character1.md)
 - [CharacterIN](docs/CharacterIN.md)
 - [Genre](docs/Genre.md)
 - [Movie](docs/Movie.md)
 - [MovieITF](docs/MovieITF.md)
 - [User](docs/User.md)
 - [UserDTO](docs/UserDTO.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

j.escurra.1999@gmail.com

