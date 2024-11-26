package input;

import java.util.Scanner;

public class ConsoleInputSource implements InputSource {
    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к каталогу: ");
        return scanner.nextLine();
    }
}
