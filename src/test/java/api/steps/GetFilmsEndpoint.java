package api.steps;

import api.endpoints.Routes;
import api.endpoints.responses.pojo.Films;
import io.restassured.RestAssured;

public class GetFilmsEndpoint extends Routes {
    private final Films films;
    public GetFilmsEndpoint(Films films) {
        this.films = films;
    }

    public void setCharactersFromMovieNewHope() {
        var filmsEndpointResponse = RestAssured.given().when().get(movie_url).then();
        films.setCharacters(filmsEndpointResponse.extract().jsonPath().getList("characters"));
    }
}
