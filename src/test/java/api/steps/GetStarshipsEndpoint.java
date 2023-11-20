package api.steps;

import api.endpoints.RestService;
import api.endpoints.responses.pojo.Person;
import api.endpoints.responses.pojo.Starship;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetStarshipsEndpoint extends RestService {
    private static final Logger logger = LogManager.getLogger(GetStarshipsEndpoint.class);

    @Override
    protected String getBasePath() {
        return "starships/";
    }

    private final Person person;
    private final Starship starship;

    public GetStarshipsEndpoint(Person person, Starship starship) {
        this.person = person;
        this.starship = starship;
    }

    public List<String> getStarshipDetails() {
        for (String starshipUrl : person.getStarships()) {
            var getStarshipsEndpointResponse = given().when().get(starshipUrl).as(Starship.class);
            starship.setName(getStarshipsEndpointResponse.getName());
            starship.setStarshipClass(getStarshipsEndpointResponse.getStarshipClass());
            starship.setPilots(getStarshipsEndpointResponse.getPilots());
        }
        return null;
    }

    public String displayStarshipNameBiggsFlewOn() {
        logger.info("Starship he was flying on is " + starship.getName());
        return starship.getName();
    }

    public String getStarshipClass() {
        logger.info("Starship class is " + starship.getStarshipClass());
        return starship.getStarshipClass();
    }
}


