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


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.Character;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PersonajesApi
 */
@Ignore
public class PersonajesApiTest {

    private final PersonajesApi api = new PersonajesApi();

    
    /**
     * Elimina un personaje por id ingresado
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteByIdUsingDELETETest() throws ApiException {
        Long id = null;
        api.deleteByIdUsingDELETE(id);

        // TODO: test validations
    }
    
    /**
     * Busca un personaje por id ingresado
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findByIdUsingGETTest() throws ApiException {
        Long id = null;
        Character response = api.findByIdUsingGET(id);

        // TODO: test validations
    }
    
    /**
     * Busca personajes según la coincidencia de sus nombres (%_%))
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findByNameUsingGETTest() throws ApiException {
        String name = null;
        List<Character> response = api.findByNameUsingGET(name);

        // TODO: test validations
    }
    
    /**
     * Guarda un personaje
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void saveUsingPOSTTest() throws ApiException {
        Character character = null;
        Character response = api.saveUsingPOST(character);

        // TODO: test validations
    }
    
    /**
     * Guarda un personaje
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void saveUsingPUTTest() throws ApiException {
        Character character = null;
        Character response = api.saveUsingPUT(character);

        // TODO: test validations
    }
    
}
