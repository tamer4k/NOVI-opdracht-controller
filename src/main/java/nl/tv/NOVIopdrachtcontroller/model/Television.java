package nl.tv.NOVIopdrachtcontroller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Television {

    private UUID id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")

    private int price;

    public Television() {
    }

    public Television(UUID id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Television(String name, int price) {

        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
