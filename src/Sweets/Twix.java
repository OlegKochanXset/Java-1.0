package Sweets;

public class Twix extends Sweet {
    private String filling; // уникальное свойство для Twix

    public Twix() {
        super("Twix", 50, 35);  // теперь вызываем super только с 3 параметрами
        this.filling = "С карамелью и печеньем";
    }

    @Override
    public String getInfo() {
        return name + " | Вес: " + weight + " г | Цена: " + price + " руб | Начинка: " + filling;
    }
}

