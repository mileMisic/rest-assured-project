package api.endpoints.responses.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Starships {
    private String name;
    private String model;

    private String manufacturer;
    @JsonProperty("cost_in_credits")
    private String costInCredits;

    private String length;
    @JsonProperty("max_atmosphering_speed")
    private String maxAtmoSpeed;

    private String crew;

    private String passengers;
    @JsonProperty("cargo_capacity")
    private String cargoCapacity;

    private String consumables;
    @JsonProperty("hyperdrive_rating")
    private String hyperdriveRating;
    @JsonProperty("MGLT")
    private String mglt;

    @JsonProperty("starship_class")
    private String starshipClass;


    private List<String> pilots;

    private List<String> films;

    private String created;

    private String edited;

    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }


    public List<String> getPilots() {
        return pilots;
    }

    public void setPilots(List<String> pilots) {
        this.pilots = pilots;
    }

}
