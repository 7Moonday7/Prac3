package processor;

import stack.DirectoryStack;
import input.InputSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryProcessor {
    private final DirectoryStack directoryStack;
    private final InputSource inputSource;

    public DirectoryProcessor(DirectoryStack directoryStack, InputSource inputSource) {
        this.directoryStack = directoryStack;
        this.inputSource = inputSource;
    }

    public List<String> processDirectory() {
        List<String> filesAndDirectories = new ArrayList<>();
        String directoryPath = inputSource.getInput(); // Используем путь, полученный от источника
               File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                filesAndDirectories.add(file.getName());
                if (file.isDirectory()) {
                    directoryStack.push(file.getAbsolutePath());
                }
            }
        } else {
            System.err.println("Указанный путь не является каталогом или не существует: " + directoryPath);
        }
        return filesAndDirectories;
    }
}
