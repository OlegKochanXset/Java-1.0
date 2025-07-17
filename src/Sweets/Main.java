package Sweets;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GiftBox box = new GiftBox();

        // Добавим сладости в коробку
        box.addSweet(new Twix());
        box.addSweet(new KitKat());
        box.addSweet(new NapoleonCake());


        // Выводим все сладости в начале
        System.out.println("\nИзначальное содержимое коробки:");
        box.printAllSweets();

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Оптимизация по весу");
            System.out.println("2 - Оптимизация по цене");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Выход из программы.");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Введите максимальный вес коробки (в граммах): ");
                    double maxWeight = scanner.nextDouble();
                    box.optimizeByWeight(maxWeight);
                    System.out.println("Коробка после оптимизации по весу:");
                    box.printAllSweets();
                    break;

                case 2:
                    System.out.print("Введите максимальный вес коробки (в граммах), для оптимизации по цене: ");
                    double maxWeightForPrice = scanner.nextDouble();
                    box.optimizeByPrice(maxWeightForPrice);
                    System.out.println("Коробка после оптимизации по цене:");
                    box.printAllSweets();
                    break;

                default:
                    System.out.println("Неверный ввод. Пожалуйста, выберите 1, 2 или 0.");
            }
        }

        scanner.close();
    }
}