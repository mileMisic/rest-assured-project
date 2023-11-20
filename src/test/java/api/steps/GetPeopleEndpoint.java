package api.steps;

import api.endpoints.RestService;
import api.endpoints.responses.pojo.Film;
import api.endpoints.responses.pojo.Person;
import api.endpoints.responses.pojo.Starship;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class GetPeopleEndpoint extends RestService {
    private static final Logger logger = LogManager.getLogger(GetPeopleEndpoint.class);

    @Override
    protected String getBasePath() {
        return "people/";
    }

    private final Film film;
    private final Person person;
    private final Starship starship;

    public GetPeopleEndpoint(Film film, Person person, Starship starship) {
        this.film = film;
        this.person = person;
        this.starship = starship;
    }

    public boolean isBiggsDarklighterAmongCharacters(String character) {
        for (String characterUrl : film.getCharacters()) {
            var peopleEndpointResponse = given().when().get(characterUrl).as(Person.class);
            String characterName = peopleEndpointResponse.getName();
            if (characterName.equals(character)) {
                logger.info("Found you, Biggs Darklighter!");
                person.setStarships(peopleEndpointResponse.getStarships());
                return true;
            }
        }
        return false;
    }

    public boolean isLukeAmongThePilots(String lukeSkywalker) {
        for (String pilot : starship.getPilots()) {
            var peopleEndpointResponse = given().when().get(pilot).as(Person.class);
            String pilotName = peopleEndpointResponse.getName();
            if (pilotName.equals(lukeSkywalker)) {
                person.setName(pilotName);
                logger.info(pilotName);
                return true;
            }
        }
        return false;
    }
}
