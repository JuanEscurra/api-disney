# PelculasApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteByIdUsingDELETE1**](PelculasApi.md#deleteByIdUsingDELETE1) | **DELETE** /movies/{id} | Elimina un personaje por el identificador
[**findByIdUsingGET1**](PelculasApi.md#findByIdUsingGET1) | **GET** /movies/{id} | Busca una película según su identificador
[**findByNameUsingGET1**](PelculasApi.md#findByNameUsingGET1) | **GET** /movies | Buscar películas por coincidencias con el nombre (%_%)
[**saveUsingPOST1**](PelculasApi.md#saveUsingPOST1) | **POST** /movies | Guarda un película
[**saveUsingPUT1**](PelculasApi.md#saveUsingPUT1) | **PUT** /movies | Guarda un película


<a name="deleteByIdUsingDELETE1"></a>
# **deleteByIdUsingDELETE1**
> deleteByIdUsingDELETE1(id)

Elimina un personaje por el identificador

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PelculasApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PelculasApi apiInstance = new PelculasApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      apiInstance.deleteByIdUsingDELETE1(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling PelculasApi#deleteByIdUsingDELETE1");
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

<a name="findByIdUsingGET1"></a>
# **findByIdUsingGET1**
> Movie findByIdUsingGET1(id)

Busca una película según su identificador

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PelculasApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PelculasApi apiInstance = new PelculasApi(defaultClient);
    Long id = 56L; // Long | id
    try {
      Movie result = apiInstance.findByIdUsingGET1(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PelculasApi#findByIdUsingGET1");
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

[**Movie**](Movie.md)

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

<a name="findByNameUsingGET1"></a>
# **findByNameUsingGET1**
> List&lt;MovieITF&gt; findByNameUsingGET1(name)

Buscar películas por coincidencias con el nombre (%_%)

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PelculasApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PelculasApi apiInstance = new PelculasApi(defaultClient);
    String name = "name_example"; // String | name
    try {
      List<MovieITF> result = apiInstance.findByNameUsingGET1(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PelculasApi#findByNameUsingGET1");
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
 **name** | **String**| name |

### Return type

[**List&lt;MovieITF&gt;**](MovieITF.md)

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

<a name="saveUsingPOST1"></a>
# **saveUsingPOST1**
> Movie saveUsingPOST1(movie)

Guarda un película

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PelculasApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PelculasApi apiInstance = new PelculasApi(defaultClient);
    Movie movie = new Movie(); // Movie | movie
    try {
      Movie result = apiInstance.saveUsingPOST1(movie);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PelculasApi#saveUsingPOST1");
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
 **movie** | [**Movie**](Movie.md)| movie |

### Return type

[**Movie**](Movie.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**201** | Created |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="saveUsingPUT1"></a>
# **saveUsingPUT1**
> Movie saveUsingPUT1(movie)

Guarda un película

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PelculasApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PelculasApi apiInstance = new PelculasApi(defaultClient);
    Movie movie = new Movie(); // Movie | movie
    try {
      Movie result = apiInstance.saveUsingPUT1(movie);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PelculasApi#saveUsingPUT1");
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
 **movie** | [**Movie**](Movie.md)| movie |

### Return type

[**Movie**](Movie.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**201** | Created |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

