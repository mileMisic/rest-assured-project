package api.endpoints.responses.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class People {
    private String name;
    private String height;
    private String mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    private String gender;
    @JsonProperty("homeworld")
    private String homeWorld;
    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;
    private String created;
    private String edited;
    private String url;

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public List<String> getStarships() {
        return starships;
    }

    public List<String> setStarships(List<String> starships) {
        this.starships = starships;
        return starships;
    }
}
