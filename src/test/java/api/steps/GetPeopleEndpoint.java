package api.steps;

import api.endpoints.responses.pojo.Films;
import api.endpoints.responses.pojo.People;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetPeopleEndpoint extends People {

    GetFilmsEndpoint filmsEndpoint = new GetFilmsEndpoint();

    Films films = new Films();
    List<String> characterUrls;



    public void getCharacterList() {
        films.getCharacters();
        System.out.println(films.getCharacters());
    }

    /*public void isBiggsDarklighterAmongCharacters() {
        for (String characterUrl : films.getCharacters()) {
            var getCharacterObject = given().when().get(characterUrl).then();
            String characterName = people.setName(getCharacterObject.extract().jsonPath().getString("name"));
            if (characterName.equals("Biggs Darklighter")) {
                System.out.println("Found you");
                starshipUrls = getCharacterObject.extract().jsonPath().getList("starships");
                System.out.println(starshipUrls);
                break;
            }
        }
    }*/
}
