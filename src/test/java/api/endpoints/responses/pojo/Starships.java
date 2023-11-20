package api.endpoints.responses.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Starships {
    @JsonProperty("count")
    private int count;
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;
    @JsonProperty("results")
    private List<Starship> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Starship> getStarships() {
        return results;
    }

    public void setStarships(List<Starship> results) {
        this.results = results;
    }
}
