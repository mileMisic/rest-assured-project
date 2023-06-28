package api.endpoints.responses.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Films {
    @JsonProperty("title")
    private String title;
    @JsonProperty("episode_id")
    private String episodeId;
    @JsonProperty("opening_crawl")
    private String openingCrawl;
    @JsonProperty("director")
    private String director;
    @JsonProperty("producer")
    private String producer;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("characters")
    private List<String> characters;
    @JsonProperty("starships")
    private List<String> starships;
    @JsonProperty("vehicles")
    private List<String> vehicles;
    @JsonProperty("species")
    private List<String> species;
    @JsonProperty("created")
    private String created;
    @JsonProperty("edited")
    private String edited;
    @JsonProperty("url")
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public List<String> setCharacters(List<String> characters) {
        this.characters = characters;
        return characters;
    }
}
