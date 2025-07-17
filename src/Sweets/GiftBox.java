package Sweets;                                                  // Объявляем пакет Sweets

import java.util.ArrayList;                                                 // Импортируем класс ArrayList

public class GiftBox implements SweetBox {                                 // Создаем публичный класс GiftBox, реализующий интерфейс SweetBox
    private ArrayList<Sweet> sweets = new ArrayList<>();                   // Создаем приватный список для хранения сладостей

    public void addSweet(Sweet sweet) {                                   // Метод для добавления сладости
        sweets.add(sweet);                                               // Добавляем сладость в конец списка
    }

    public void removeSweet() {                                   // Метод для удаления последней сладости
        if (!sweets.isEmpty()) {                                    // Проверяем, что список не пустой
            sweets.remove(sweets.size() - 1);               // Удаляем последний элемент (size()-1 = индекс последнего)
        }
    }

    public void removeSweet(int index) {                      // Метод для удаления сладости по индексу
        if (index >= 0 && index < sweets.size()) {            // Проверяем, что индекс корректный (от 0 до размера-1)
            sweets.remove(index);                             // Удаляем элемент по указанному индексу
        }
    }

    public double getTotalWeight() {                                  // Метод для получения общего веса
        return sweets.stream().mapToDouble(Sweet::getWeight).sum();   // Создаем поток, преобразуем в веса, суммируем
    }

    public double getTotalPrice() {                                    // Метод для получения общей цены
        return sweets.stream().mapToDouble(Sweet::getPrice).sum();     // Создаем поток, преобразуем в цены, суммируем
    }

    public void printAllSweets() {                                    // Метод для вывода всех сладостей
        System.out.println("Сладости в коробке:");                    // Выводим заголовок
        for (Sweet sweet : sweets) {                                  // Перебираем все сладости в списке
            System.out.println(sweet.getInfo());                      // Выводим информацию о каждой сладости
        }
        System.out.println("Общий вес: " + getTotalWeight() + " г");                // Выводим общий вес
        System.out.println("Общая стоимость: " + getTotalPrice() + " руб\n");     // Выводим общую стоимость
    }

    public void optimizeByWeight(double maxWeight) {
        sweets.sort((a, b) -> Double.compare(a.getWeight(), b.getWeight()));

        while (getTotalWeight() > maxWeight && !sweets.isEmpty()) {
            Sweet removed = sweets.get(0);
            System.out.println("Удалена по весу: " + removed.getInfo());
            sweets.remove(0);
        }

        System.out.println("\nКоробка после оптимизации по весу:");
        printAllSweets();
    }

    public void optimizeByPrice(double maxWeight) {
        sweets.sort((a, b) -> Double.compare(a.getPrice(), b.getPrice())); // Сортировка по цене (дешёвые впереди)

        while (!sweets.isEmpty() && getTotalWeight() > maxWeight) {
            if (getTotalWeight() <= maxWeight) break;
            Sweet removed = sweets.remove(0);
            System.out.println("Удалена по цене: " + removed.getInfo());
        }
    }
}