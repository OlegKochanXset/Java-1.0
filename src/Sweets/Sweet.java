package Sweets;                            // package - создали пакет Swett имя пакета. Sweets- С АНГЛИСКОГО сладости

public abstract class Sweet {                // public - модификатор доступа , abstract - ключевое слово означает что класс абстрактный , не можем сорздать объект, только унаследовать!!!
    protected String name;                   // protected модификатор доступа , поле доступно в этом классе и его наследниках.
    protected double weight;                 // тип данных double дробные чтсла , например 3,23  weight с англиского вес!
    protected double price;                  // price - имя переменой в цене
    protected String uniqueProperty;         // uniqueProperty имя переменой с ангилского уникальное свойство .

   public Sweet(String name, double weight, double price, String uniqueProperty) {        // Sweet-имя конструктора и перечисление полей
       this.name = name;                                                                  // создаем ссылку this .
       this.weight = weight;
       this.price = price;
       this.uniqueProperty = uniqueProperty;

   }

    public double getWeight() {                             //public — модификатор доступа, метод доступен отовсюду,double — тип возвращаемого значения
        return weight;                                      // getWeight — имя метода (получить вес),
                                                            // return- ключевое слово для возврата значения из метода.
                                                            // () — пустой список параметров
    }                                                       // double — тип возвращаемого значения.

    public double getPrice() {                              //getPrice - имя метода получить цену
        return price;
    }

    public String getInfo(){                                 //создаёт и возвращает текстовую строку с полной информацией о сладости. название  вес цена и добовляет уникальное свойство.
        return name + " | Вес: " + weight + " г | Цена: " + price + " руб | " + uniqueProperty;
    }

}
