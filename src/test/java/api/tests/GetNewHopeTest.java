/*package api.tests;

import api.endpoints.Routes;
import jdk.jfr.Description;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.restassured.RestAssured.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GetNewHopeTest extends Routes {

    private final String wantedPerson = "Biggs Darklighter";
    private String name;
    private List<String> starshipUrls;
    private List<String> pilotUrls;
    private String starshipName;
    private String starshipClass;
    private String pilotName;
    private List<String> characterUrls;

    @Test
    @Order(1)
    @Description("Find film with a title ”A New Hope”")
    public void getResponseForNewHope() {
        var response = given().when().get(movie_url).then().assertThat().body("title", Matchers.equalTo("A New Hope"));
        characterUrls = response.extract().jsonPath().getList("characters");
    }

    @Test
    @Order(2)
    @Description("Find person named Biggs Darklighter among the characters that were part of that film")
    public void findBiggsDarklighter() {
        for (String characterUrl : characterUrls) {
            var getCharacterObject = given().when().get(characterUrl).then();
            name = getCharacterObject.extract().jsonPath().getString("name");
            if (name.equals(wantedPerson)) {
                System.out.println("Found you");
                starshipUrls = getCharacterObject.extract().jsonPath().getList("starships");
                System.out.println(starshipUrls);
                break;
            }
        }
    }
    @Test
    @Order(3)
    @Description("Find which starship Biggs was flying on")
    public void findStarship() {
        for (String starshipUrl : starshipUrls) {
            var getStarshipObject = given().when().get(starshipUrl).then();
            starshipName = getStarshipObject.extract().jsonPath().getString("name");
            starshipClass = getStarshipObject.extract().jsonPath().getString("starship_class");
            pilotUrls = getStarshipObject.extract().jsonPath().getList("pilots");
            System.out.println("Starship he was flying on is " + starshipName);
        }
    }
    @Test
    @Order(4)
    @Description("Is starship class “Starfighter”")
    public void checkStarshipClass() {
        Assertions.assertEquals("Starfighter", starshipClass);
    }
    @Test
    @Order(5)
    @Description("Luke Skywalker is among pilots that were also flying this kind of starship")
    public void isLukeAmongThePilots() {
        for (String pilot : pilotUrls) {
            var getPilotObject = given().when().get(pilot).then();
            pilotName = getPilotObject.extract().jsonPath().getString("name");
            if (pilotName.equals("Luke Skywalker")) {
                Assertions.assertEquals("Luke Skywalker", pilotName);
                System.out.println("Use the force, Luke!");
                break;
            }
        }
    }
} */
