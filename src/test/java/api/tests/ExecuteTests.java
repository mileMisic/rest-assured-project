package api.tests;

import api.utilities.GetNewHope;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExecuteTests {

    GetNewHope tests = new GetNewHope();

    @BeforeAll
    public static void startingExecution() {
        System.out.println("Running tests");
    }

    @Test
    @Order(1)
    @Description("Find film with a title ”A New Hope”")
    public void findFilmNewHope() {
        tests.getResponseForNewHope();
    }

    @Test
    @Order(2)
    @Description("Find person named Biggs Darklighter among the characters that were part of that film")
    public void findBiggsDarklighter() {
        tests.findBiggsDarklighter();
    }

    @Test
    @Order(3)
    @Description("Find which starship Biggs was flying on")
    public void findStarship() {
        tests.findStarship();
    }
    @Test
    @Order(4)
    @Description("Is starship class “Starfighter”")
    public void checkStarshipClass() {
        tests.checkStarshipClass();
    }
    @Test
    @Order(5)
    @Description("Luke Skywalker is among pilots that were also flying this kind of starship")
    public void isLukeAmongThePilots() {
       tests.isLukeAmongThePilots();
    }
}
