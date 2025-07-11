import java.io.*;                                                                       // Импортируем всё из java.io для работы с файлами и потоками ввода-вывода
import java.util.Scanner;                                                               // Импортируем класс Scanner для чтения ввода с клавиатуры
import java.util.ArrayList;                                                   // Импортируем список для хранения строк

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);                                                               // Создаём объект Scanner, чтобы читать строки, с помощью System.in которые вводит пользователь с клавиатуры
        System.out.println();
        while (true) {                                                                                          // Запускаем бесконечный цикл, чтобы программа постоянно работала, пока не скажем выйти
            System.out.print("Введите путь к файлу (или 'exit' для выхода , ну мало ли вдруг забыл 'input.txt'): ");         // Попросить пользователя ввести путь к файлу или команду выхода

            String inputFile = scanner.nextLine().trim();                               // Считать строку, введённую пользователем, убрать пробелы в начале и конце

            if (inputFile.equalsIgnoreCase("exit")) {                       // Проверяем, ввёл ли пользователь слово "exit" (без учёта регистра)
                System.out.println("Выход из программы.");                             // Если да, выводим сообщение об выходе
                break;                                                                 // Прерываем цикл — программа закончится
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {             // Пытаемся открыть файл по введённому пути и создать "читалку" с буфером
                String line;                                                                          // Объявляем переменную для хранения каждой строки из файла

                ArrayList<String> lines = new ArrayList<>();                                           // Создаём список для хранения всех строк, чтоб потом смог определить последню строку и вывод 3 строчки был без "," наа конце

                while ((line = reader.readLine()) != null) {                                          // Читаем файл построчно, пока не достигнем конца
                    lines.add(line);                                                                  // Добавляем каждую строку в список
                }

                for (int i = 0; i < lines.size(); i++) {                                              // Проходим по всем строкам
                    String[] part = lines.get(i).split("=", 2);                               // Разбиваем строку на 2 части до знака  '=' после знака . Первая часть "one" Вторая часть "two" part-часть
                    String one = part[0].trim();                                                       // Часть до знака  '=' part[0] - 1 часть строки
                    String two = part[1].trim();                                                       // Часть после знака  '=' part[1] - 2 часть строки

                    if (i == lines.size() - 1) {                                                       // Если это последняя строка
                        System.out.println("\"" + one + "\": <" + two + ">");                          // Без запятой
                    } else {
                        System.out.println("\"" + one + "\": <" + two + ">,");                         // Остальные строки с запятой
                    }
                }

            } catch (IOException e) {                                                                   // Если возникла ошибка при чтении файла (например, файл не найден), поймаем её здесь
                System.out.println("Ошибка при чтении файла: " + e.getMessage());                      // Выведем сообщение об ошибке Защита от ошибок во время чтения файла
            }

            System.out.println();  // разделение для строчек в консоли
        }
    }
}
