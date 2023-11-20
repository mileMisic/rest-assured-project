package api.steps;

import api.endpoints.RestService;
import api.endpoints.responses.pojo.Film;
import api.endpoints.responses.pojo.Films;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetFilmsEndpoint extends RestService {
    private static final Logger logger = LogManager.getLogger(GetFilmsEndpoint.class);
    private Film newHopeFilm;

    @Override
    protected String getBasePath() {
        return "films/";
    }
    private final Film film;

    public GetFilmsEndpoint(Film film) {
        this.film = film;
    }

    public Film findFilmNewHope(String filmTitle) {
        var filmsEndpointResponse = given().spec(REQUEST_SPECIFICATION).get().as(Films.class);
        List<Film> filmsList = filmsEndpointResponse.getResults();
        newHopeFilm  = getFilmByTitle(filmsList, filmTitle);
        return newHopeFilm;
    }

    public List<String> setCharactersFromFilmNewHope() {
        film.setCharacters(newHopeFilm.getCharacters());
        logger.info("Character URLs are: " + film.getCharacters());
        return film.getCharacters();
    }

    private Film getFilmByTitle(List<Film> filmsList, String title) {
        for (Film film : filmsList) {
            if (film.getTitle().equals(title)) {
                return film;
            }
        }
        return null;
    }
}

