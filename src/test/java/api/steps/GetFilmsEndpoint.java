package api.steps;

import api.constants.Constants;
import api.endpoints.RestService;
import api.endpoints.responses.pojo.Film;
import api.endpoints.responses.pojo.Films;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GetFilmsEndpoint extends RestService {
    private static final Logger logger = LogManager.getLogger(GetFilmsEndpoint.class);

    @Override
    protected String getBasePath() {
        return "films/";
    }

    private Film film;
    private final Films films;

    public GetFilmsEndpoint(Film film, Films films) {
        this.film = film;
        this.films = films;
    }

    public void setCharactersFromMovieNewHope() {
        var filmsEndpointResponse = RestAssured.given().spec(REQUEST_SPECIFICATION).get().as(Films.class);
        List<Film> filmsList = filmsEndpointResponse.getResults();
        Film newHopeFilm = getFilmByTitle(filmsList, Constants.NEW_HOPE);
        film = newHopeFilm;
        film.setCharacters(newHopeFilm.getCharacters());
        logger.info("Characters from film New Hope are: " + film.getCharacters());
    }

    public Film getFilmByTitle(List<Film> filmsList, String title) {
        for (Film film : filmsList) {
            if (film.getTitle().equals(title)) {
                return film;
            }
        }
        return null;
    }
}

