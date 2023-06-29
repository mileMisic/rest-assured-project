package api.steps;

import api.constants.Constants;
import api.endpoints.responses.pojo.Films;
import api.endpoints.responses.pojo.People;
import api.endpoints.responses.pojo.Starships;

import static io.restassured.RestAssured.given;

public class GetPeopleEndpoint extends People {
    private final Films films;
    private final People people;
    private final Starships starships;
    public GetPeopleEndpoint(Films films, People people, Starships starships) {
        this.films = films;
        this.people = people;
        this.starships = starships;
    }
    public void getCharacterList() {
        films.getCharacters();
    }

    public void isBiggsDarklighterAmongCharacters() {
        for (String characterUrl : films.getCharacters()) {
            var getPeopleEndpointResponse = given().when().get(characterUrl).then();
            String characterName = people.setName(getPeopleEndpointResponse.extract().jsonPath().getString("name"));
            if (characterName.equals(Constants.BIGGS_DARKLIGHTER)) {
                System.out.println("Found you, Biggs Darklighter!");
                people.setStarships(getPeopleEndpointResponse.extract().jsonPath().getList("starships"));
                break;
            }
        }

    }
    public void isLukeAmongThePilots() {
        for (String pilot : starships.getPilots()) {
            var getPeopleEndpointResponse = given().when().get(pilot).then();
            String pilotName = people.setName(getPeopleEndpointResponse.extract().jsonPath().getString("name"));
            if (pilotName.equals(Constants.LUKE_SKYWALKER)) {
                System.out.println("Use the force, Luke!");
                break;
            }
        }
    }
}
