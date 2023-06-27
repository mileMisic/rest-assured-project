package api.utilities;

import api.endpoints.Routes;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetNewHope extends Routes {

    private final String wantedPerson = "Biggs Darklighter";
    private String name;
    private List<String> starshipUrls;
    private List<String> pilotUrls;
    private String starshipName;
    private String starshipClass;
    private String pilotName;
    private List<String> characterUrls;

    public void getResponseForNewHope() {
        var response = given().when().get(movie_url).then().assertThat().body("title", Matchers.equalTo("A New Hope"));
        characterUrls = response.extract().jsonPath().getList("characters");
        System.out.println(characterUrls);
    }

    public void findBiggsDarklighter() {
        getResponseForNewHope();
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

    public void findStarship() {
        findBiggsDarklighter();
        for (String starshipUrl : starshipUrls) {
            var getStarshipObject = given().when().get(starshipUrl).then();
            starshipName = getStarshipObject.extract().jsonPath().getString("name");
            starshipClass = getStarshipObject.extract().jsonPath().getString("starship_class");
            pilotUrls = getStarshipObject.extract().jsonPath().getList("pilots");
            System.out.println("Starship he was flying on is " + starshipName);
        }
    }

    public void checkStarshipClass() {
        findStarship();
        Assertions.assertEquals("Starfighter", starshipClass);
    }

    public void isLukeAmongThePilots() {
        checkStarshipClass();
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
}
