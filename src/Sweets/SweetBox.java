package Sweets;                           //Объявили пакет,имя пакета

public interface SweetBox { // interface ключевое слово для объявление интерфейса , SweetBox название интерфейса


    void addSweet(Sweet sweet);                     // Метод для добавления сладости в коробку
    void removeSweet();                             // Метод для удаления сладости (последней)
    void removeSweet(int index);                    // Метод для удаления сладости по индексу
    double getTotalWeight();                        // Метод возвращает общий вес всех сладостей
    double getTotalPrice();                         // Метод возвращает общую цену всех сладостей
    void printAllSweets();                          // Метод для вывода информации о всех сладостях
    void optimizeByWeight(double maxWeight);        // Метод оптимизации по весу (не превышать maxWeight)
    void optimizeByPrice(double maxWeight);         // Метод оптимизации по цене при ограничении веса
}

