package api.tests;

import api.constants.Constants;
import api.endpoints.responses.pojo.Film;
import api.endpoints.responses.pojo.Films;
import api.endpoints.responses.pojo.People;
import api.endpoints.responses.pojo.Starships;
import api.steps.GetFilmsEndpoint;
import api.steps.GetPeopleEndpoint;
import api.steps.GetStarshipsEndpoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;


public class StarWarsTests {
    private static final Logger logger = LogManager.getLogger(StarWarsTests.class);
    Film film = new Film();
    Films films = new Films();
    People people = new People();
    Starships starships = new Starships();
    GetFilmsEndpoint filmsEndpoint = new GetFilmsEndpoint(film, films);
    GetPeopleEndpoint peopleEndpoint = new GetPeopleEndpoint(film, films, people, starships);
    GetStarshipsEndpoint starshipsEndpoint = new GetStarshipsEndpoint(people, starships);

    @BeforeAll
    public static void startingExecution() {
        logger.info("Running tests");
    }

    @Test
    public void newTry() {
        filmsEndpoint.setCharactersFromMovieNewHope();
        // Assertions.assertEquals(Constants.NEW_HOPE, film.getTitle());
        peopleEndpoint.getCharacterList();
        // peopleEndpoint.isBiggsDarklighterAmongCharacters();
       /*  starshipsEndpoint.findStarshipName();
        Assertions.assertEquals(Constants.STARFIGHTER, starships.getStarshipClass());
        peopleEndpoint.isLukeAmongThePilots();
        Assertions.assertEquals(Constants.LUKE_SKYWALKER, people.getName());*/
    }

    @AfterAll
    public static void finishTest() {
        logger.info("Tests done");
    }
}
