package api.steps;

import api.constants.Constants;
import api.endpoints.responses.pojo.Film;
import api.endpoints.responses.pojo.Films;
import api.endpoints.responses.pojo.People;
import api.endpoints.responses.pojo.Starships;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class GetPeopleEndpoint {
    private static final Logger logger = LogManager.getLogger(GetPeopleEndpoint.class);
    private Film film;
    private Films films;
    private final People people;
    private final Starships starships;

    public GetPeopleEndpoint(Film film, Films films, People people, Starships starships) {
        this.film = film;
        this.films = films;
        this.people = people;
        this.starships = starships;
    }

    public void getCharacterList() {
        film.getCharacters();
    }

    public void isBiggsDarklighterAmongCharacters() {
        for (String characterUrl : film.getCharacters()) {
            var getPeopleEndpointResponse = given().when().get(characterUrl).as(People.class);
            String characterName = getPeopleEndpointResponse.getName();
            if (characterName.equals(Constants.BIGGS_DARKLIGHTER)) {
                logger.info("Found you, Biggs Darklighter!");
                //people.setStarships(getPeopleEndpointResponse.extract().jsonPath().getList("starships"));
                break;
            }
        }
    }


    public void isLukeAmongThePilots() {
        for (String pilot : starships.getPilots()) {
            var getPeopleEndpointResponse = given().when().get(pilot).then();
            String pilotName = people.setName(getPeopleEndpointResponse.extract().jsonPath().getString("name"));
            if (pilotName.equals(Constants.LUKE_SKYWALKER)) {
                logger.info("Use the force, Luke!");
                break;
            }
        }
    }
}
