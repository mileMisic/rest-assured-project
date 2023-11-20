package api.endpoints.responses.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class People {
    @JsonProperty("count")
    private int count;
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;
    @JsonProperty("results")
    private List<Person> results;

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

    public List<Person> getCharacters() {
        return results;
    }

    public void setCharacters(List<Person> results) {
        this.results = results;
    }
}
