package api.steps;

import api.endpoints.responses.pojo.People;
import api.endpoints.responses.pojo.Starships;

import static io.restassured.RestAssured.given;

public class GetStarshipsEndpoint {

    private final People people;
    private final Starships starships;

    public GetStarshipsEndpoint(People people, Starships starships) {
        this.people = people;
        this.starships = starships;
    }

    public void findStarshipName() {
        for (String starshipUrl : people.getStarships()) {
            var getStarshipsEndpointResponse = given().when().get(starshipUrl).then();
            starships.setName(getStarshipsEndpointResponse.extract().jsonPath().getString("name"));
            starships.setStarshipClass(getStarshipsEndpointResponse.extract().jsonPath().getString("starship_class"));
            starships.setPilots(getStarshipsEndpointResponse.extract().jsonPath().getList("pilots"));
            System.out.println("Starship he was flying on is " + starships.getName());
        }
    }
}


