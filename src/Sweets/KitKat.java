package Sweets;

public class KitKat extends Sweet {
    private String texture; // уникальное свойство для KitKat

    public KitKat() {
        super("KitKat", 145, 38);  // только 3 параметра: name, weight, price
        this.texture = "С хрустящей вафлей";
    }

    @Override
    public String getInfo() {
        return name + " | Вес: " + weight + " г | Цена: " + price + " руб | Текстура: " + texture;
    }
}