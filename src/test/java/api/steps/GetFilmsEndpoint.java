package api.steps;

import api.endpoints.Routes;
import api.endpoints.responses.pojo.Films;
import io.restassured.RestAssured;

public class GetFilmsEndpoint extends Routes {

    Films films = new Films();

    public void getCharactersFromNewHope() {
        var response = RestAssured.given().when().get(movie_url).then();
        films.setCharacters(response.extract().jsonPath().getList("characters"));
        System.out.println(films.setCharacters(response.extract().jsonPath().getList("characters")));
    }
}
