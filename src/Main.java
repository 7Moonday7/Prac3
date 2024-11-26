import input.*;
import processor.DirectoryProcessor;
import stack.DirectoryStack;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Выбор источника ввода
            InputSource inputSource = selectInputSource();

            // Создание стека
            DirectoryStack directoryStack = new DirectoryStack();

            // Создание процессора с выбранным источником ввода и стеком
            DirectoryProcessor processor = new DirectoryProcessor(directoryStack, inputSource);

            // Обработка каталога
            List<String> filesAndDirectories = processor.processDirectory();
            
            if (filesAndDirectories != null && !filesAndDirectories.isEmpty()) {
                // Вывод списка файлов и каталогов
                System.out.println("Содержимое каталога:");
                for (String file : filesAndDirectories) {
                    System.out.println(file);
                }

                // Вывод стека
                System.out.println("\nСтек каталогов:");
                directoryStack.printStack();
            }

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static InputSource selectInputSource() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите способ ввода данных:");
        System.out.println("1. Переменная");
        System.out.println("2. Консоль");
        System.out.println("3. Файл");
        System.out.println("4. Выход");

        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // пропуск новой строки
                switch (choice) {
                    case 1:
                        return new VariableInputSource("C:/example/directory");
                    case 2:
                        return new ConsoleInputSource();
                    case 3:
                        System.out.print("Введите путь к файлу: ");
                        String filePath = scanner.nextLine();
                        return new FileInputSource(filePath);
                    case 4:
                        System.out.println("Выход из программы.");
                        scanner.close();
                        System.exit(0);
                        return null; // Завершаем программу
                    default:
                        throw new IllegalArgumentException("Неверный выбор");
                }
            } catch (Exception e) {
                System.err.println("Ошибка ввода. Попробуйте снова.");
                scanner.nextLine(); // Очищаем буфер ввода, чтобы избежать зацикливания
            }
        }
    }
}
