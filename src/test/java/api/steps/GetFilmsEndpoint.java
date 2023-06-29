package api.steps;

import api.constants.Constants;
import api.endpoints.Routes;
import api.endpoints.responses.pojo.Films;
import io.restassured.RestAssured;

public class GetFilmsEndpoint extends Routes {
    private final Films films;
    public GetFilmsEndpoint(Films films) {
        this.films = films;
    }

    public void setCharactersFromMovieNewHope() {
        var filmsEndpointResponse = RestAssured.given().when().get(films_url).then();
        films.setTitle(filmsEndpointResponse.extract().jsonPath().getString("results[0].title"));
        if (films.getTitle().equals(Constants.NEW_HOPE)) {
        films.setCharacters(filmsEndpointResponse.extract().jsonPath().getList("results[0].characters"));
        }
    }
}
