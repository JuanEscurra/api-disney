# PersonajesApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteByIdUsingDELETE**](PersonajesApi.md#deleteByIdUsingDELETE) | **DELETE** /characters/{id} | Elimina un personaje por id ingresado
[**findByIdUsingGET**](PersonajesApi.md#findByIdUsingGET) | **GET** /characters/{id} | Busca un personaje por id ingresado
[**findByNameUsingGET**](PersonajesApi.md#findByNameUsingGET) | **GET** /characters | Busca personajes según la coincidencia de sus nombres (%_%))
[**saveUsingPOST**](PersonajesApi.md#saveUsingPOST) | **POST** /characters | Guarda un personaje
[**saveUsingPUT**](PersonajesApi.md#saveUsingPUT) | **PUT** /characters | Guarda un personaje


<a name="deleteByIdUsingDELETE"></a>
# **deleteByIdUsingDELETE**
> deleteByIdUsingDELETE(id)

Elimina un personaje por id ingresado

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PersonajesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PersonajesApi apiInstance = new PersonajesApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      apiInstance.deleteByIdUsingDELETE(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonajesApi#deleteByIdUsingDELETE");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**204** | No Content |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |

<a name="findByIdUsingGET"></a>
# **findByIdUsingGET**
> Character findByIdUsingGET(id)

Busca un personaje por id ingresado

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PersonajesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PersonajesApi apiInstance = new PersonajesApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      Character result = apiInstance.findByIdUsingGET(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonajesApi#findByIdUsingGET");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| id |

### Return type

[**Character**](Character.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="findByNameUsingGET"></a>
# **findByNameUsingGET**
> List&lt;Character&gt; findByNameUsingGET(name)

Busca personajes según la coincidencia de sus nombres (%_%))

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PersonajesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PersonajesApi apiInstance = new PersonajesApi(defaultClient);
    String name = "name_example"; // String | name
    try {
      List<Character> result = apiInstance.findByNameUsingGET(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonajesApi#findByNameUsingGET");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| name | [optional]

### Return type

[**List&lt;Character&gt;**](Character.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="saveUsingPOST"></a>
# **saveUsingPOST**
> Character saveUsingPOST(character)

Guarda un personaje

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PersonajesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PersonajesApi apiInstance = new PersonajesApi(defaultClient);
    Character character = new Character(); // Character | character
    try {
      Character result = apiInstance.saveUsingPOST(character);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonajesApi#saveUsingPOST");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **character** | [**Character**](Character.md)| character |

### Return type

[**Character**](Character.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**201** | Created |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="saveUsingPUT"></a>
# **saveUsingPUT**
> Character saveUsingPUT(character)

Guarda un personaje

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PersonajesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PersonajesApi apiInstance = new PersonajesApi(defaultClient);
    Character character = new Character(); // Character | character
    try {
      Character result = apiInstance.saveUsingPUT(character);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PersonajesApi#saveUsingPUT");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **character** | [**Character**](Character.md)| character |

### Return type

[**Character**](Character.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**201** | Created |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

