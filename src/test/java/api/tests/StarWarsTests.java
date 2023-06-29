package api.tests;

import api.constants.Constants;
import api.endpoints.responses.pojo.Films;
import api.endpoints.responses.pojo.People;
import api.endpoints.responses.pojo.Starships;
import api.steps.GetFilmsEndpoint;
import api.steps.GetNewHope;
import api.steps.GetPeopleEndpoint;
import api.steps.GetStarshipsEndpoint;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;


public class StarWarsTests {

    GetNewHope tests = new GetNewHope();
    Films films = new Films();
    People people = new People();
    Starships starships = new Starships();
    GetFilmsEndpoint filmsEndpoint = new GetFilmsEndpoint(films);
    GetPeopleEndpoint peopleEndpoint = new GetPeopleEndpoint(films, people, starships);
    GetStarshipsEndpoint starshipsEndpoint = new GetStarshipsEndpoint(people, starships);

    @BeforeAll
    public static void startingExecution() {
        System.out.println("Running tests");
    }

    @Test
    public void newTry() {
        filmsEndpoint.setCharactersFromMovieNewHope();
        peopleEndpoint.getCharacterList();
        peopleEndpoint.isBiggsDarklighterAmongCharacters();
        starshipsEndpoint.findStarshipName();
        Assertions.assertEquals(Constants.STARFIGHTER, starships.getStarshipClass());
        peopleEndpoint.isLukeAmongThePilots();
        Assertions.assertEquals(Constants.LUKE_SKYWALKER, people.getName());
    }

    @AfterAll
    public static void finishTest() {
        System.out.println("Tests done");
    }
}
