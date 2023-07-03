package api.endpoints;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class RestService {

    public static final String BASE_URL = "https://swapi.dev/api/";
    protected RequestSpecification REQUEST_SPECIFICATION;

    protected abstract String getBasePath();

    public RestService() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(getBasePath())
                .setContentType(ContentType.JSON)
                .build();
    }
}
