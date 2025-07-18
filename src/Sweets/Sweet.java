package Sweets;

public abstract class Sweet {
    protected String name;
    protected double weight;
    protected double price;

    public Sweet(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getInfo(); // теперь каждый подкласс сам реализует метод getInfo()
}
