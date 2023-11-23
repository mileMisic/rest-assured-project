package api.tests;

import api.constants.Constants;
import api.endpoints.responses.pojo.Film;
import api.endpoints.responses.pojo.Person;
import api.endpoints.responses.pojo.Starship;
import api.steps.GetFilmsEndpoint;
import api.steps.GetPeopleEndpoint;
import api.steps.GetStarshipsEndpoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;


public class StarWarsTests {
    private static final Logger logger = LogManager.getLogger(StarWarsTests.class);
    Film film = new Film();
    Person person = new Person();
    Starship starship = new Starship();
    GetFilmsEndpoint filmsEndpoint = new GetFilmsEndpoint(film);
    GetPeopleEndpoint peopleEndpoint = new GetPeopleEndpoint(film, person, starship);
    GetStarshipsEndpoint starshipsEndpoint = new GetStarshipsEndpoint(person, starship);

    @BeforeAll
    public static void startingExecution() {
        logger.info("Running tests");
    }

    @Test
    public void StarWarsTest() {
        filmsEndpoint.findFilmNewHope(Constants.NEW_HOPE);
        filmsEndpoint.setCharactersFromFilmNewHope();
        Assertions.assertTrue(peopleEndpoint.isNameAmongCharacters(Constants.BIGGS_DARKLIGHTER), "Biggs Darklighter is not among characters");
        starshipsEndpoint.getStarshipDetails();
        starshipsEndpoint.displayStarshipNameBiggsFlewOn();
        Assertions.assertEquals(Constants.STARFIGHTER, starshipsEndpoint.getStarshipClass(), "Starship class found is not Starfighter!");
        Assertions.assertTrue(peopleEndpoint.isNameAmongThePilots(Constants.LUKE_SKYWALKER), "Luke Skywalker is not among the pilots");
    }

    @AfterAll
    public static void finishTest() {
        logger.info("Tests done");
    }
}
