package Sweets;

public class NapoleonCake extends Sweet {
    private String creamType;  // уникальное свойство для торта Наполеон

    public NapoleonCake() {
        super("Наполеон", 120, 80);  // вызываем конструктор с 3 параметрами
        this.creamType = "С ягодным кремом";
    }

    @Override
    public String getInfo() {
        return name + " | Вес: " + weight + " г | Цена: " + price + " руб | Крем: " + creamType;
    }
}