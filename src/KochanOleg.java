import java.io.*;
import java.nio.charset.StandardCharsets;

// Импорт библиотек, нужных для работы с файлами
// java.io.* - для чтения и записи файлов
// StandardCharsets - чтобы указать кодировку UTF-8, которая поддерживает кириллицу

// Объявили публичный класс с именем KochanOleg
public class KochanOleg {

    // Массив гласных букв (кириллица)
    private static final char[] vowels = {
            'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я',
            'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я'
    };

                                                             // private - модификатор доступа. Поле vowels доступно только внутри текущего класса.
                                                             // static - означает, что это поле принадлежит классу, а не отдельному объекту.
                                                             // final - означает, что значение поля нельзя изменить после инициализации (массив можно изменить, но нельзя присвоить новый массив).
                                                             // char[] - это массив символов
                                                             // vowels - имя массива в переводе с английского — гласные
                                                             // Внутри массива указаны все русские гласные как в нижнем так и в верхнем.

    // Проверка: является ли буква гласной
    private static boolean isVowel(char c) {
        for (char v : vowels) {                                   // Проходим по всем символам в массиве vowels
            if (c == v) {                                         // Сравниваем каждый символ с переданным
                return true;                                      // Если нашли совпадение - это гласная
            }
        }
        return false;                                             // Если не нашли - это не гласная
    }

    // Проверка: является ли буква кириллической
    private static boolean isCyrillicLetter(char c) {                                                                                // boolean- метод возвращает логическое значение (true или false).
        return (c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я') || c == 'ё' || c == 'Ё';                                             // isCyrillicLetter - имя метода
    }                                                                                                                                // (char c) - метод принимает один символ в качестве аргумента
                                                                                                                                     // return  - оператор возврата результата.

    public static void main(String[] args) {                                                                                         // public - метод доступен откуда угодно (требование для main).
        String inputFile = "input.txt";                                                                                              // static - метод принадлежит классу, а не объекту
        String outputFile = "output.txt";                                                                                            // void - метод ничего не возвращает.
                                                                                                                                     // main - специальный метод, с которого начинается выполнение программы.
        int vowelCount = 0;                                                                                                          // String[] args - массив аргументов командной строки (в данном случае не используется, но может быть).
        int consonantCount = 0;                                                                                                      // Объявляется строковая переменная inputFile. В неё записано имя входного файла, откуда будет считываться текст
                                                                                                                                     // Объявляется строковая переменная outputFile.В неё записано имя выходного файла, куда будет записан результат.
        try (                                                                                                                        // Переменная vowelCount хранит количество гласных букв, найденных в тексте, изначально значение 0.
                BufferedReader reader = new BufferedReader(                                                                          // Переменная consonantCount хранит количество согласных букв, изначально значение 0.
                        new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8)                                // BufferedReader reader - объект, читающий символы из файла с буфером
                );                                                                                                                   // InputStreamReader - преобразует байты в символы.
                BufferedWriter writer = new BufferedWriter(                                                                          // FileInputStream(inputFile) - открывает файл input.txt для чтения.
                        new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8)                             // StandardCharsets.UTF_8 - указывает, что текст читается в кодировке UTF-8.
                )                                                                                                                    // BufferedWriter writer - объект, записывающий символы в файл.
        ) {                                                                                                                          // OutputStreamWriter - преобразует символы в байты.
            int character;                                                                                                           // FileOutputStream(outputFile) - открывает файл output.txt для записи.
            while ((character = reader.read()) != -1) {                                                                              // UTF-8 - кодировка, подходящая для русского текста.
                char c = (char) character;                                                                                           // int character Объявляется переменная character, в которую будут построчно считываться символы из файла
                                                                                                                                     // while ((character = reader.read()) != -1) {, Запускается цикл, который читаeт по одному символу из файла.Метод read() возвращает символ (в виде int), если ещё не конец файла,-1, если файл закончился.
                if (isCyrillicLetter(c)) {                                                                                           // char c = (char) character; Преобразует считанное число character в реальный символ типа char.
                    if (isVowel(c)) {                                                                                                // if (isCyrillicLetter(c)) {, Проверяет, является ли символ русской буквой (используется ранее описанный метод isCyrillicLetter).
                        writer.write('a');                                                                                        // if (isVowel(c)) {, Если символ - русская буква, проверяет: гласная ли она.Используется метод isVowel
                        vowelCount++;                                                                                                // writer.write('a'); Если это гласная, в файл записывается символ 'a'
                    } else {                                                                                                         // vowelCount++; Увеличивается счётчик vowelCount (найдена гласная).
                        writer.write('м');                                                                                        // } else {, Если символ - не гласная, значит это согласная.
                        consonantCount++;                                                                                            // writer.write('м'); В файл записывается символ 'м', вместо исходной согласной
                    }                                                                                                                // consonantCount++; Увеличивается счётчик consonantCount
                } else {                                                                                                             // } else {, Если символ не русская буква, выполняется этот блок.
                    writer.write(c); // другие символы просто копируем, cимвол не обрабатывается, а записывается как есть в выходной файл.
                }
            }

            System.out.println("Количество гласных (заменённых на 'a'): " + vowelCount);                                   // Вывод в консоль
            System.out.println("Количество согласных (заменённых на 'м'): " + consonantCount);                             // Вывод в консоль

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());                                          // catch отлавливает ошибки, которые могут возникнуть при работе с файлами.
        }
    }
}
