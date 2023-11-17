package nl.tv.NOVIopdrachtcontroller.model;

public class Television {
    private String name;
    private int price;

    public Television() {
    }

    public Television( String name, int price) {

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

}
