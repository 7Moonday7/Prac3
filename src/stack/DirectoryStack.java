package stack;

import java.util.Stack;

public class DirectoryStack {
    private final Stack<String> stack;

    public DirectoryStack() {
        this.stack = new Stack<>();
    }

    public void push(String directory) {
        stack.push(directory);
    }

    public String pop() {
        return stack.isEmpty() ? null : stack.pop();
    }

    public String peek() {
        return stack.isEmpty() ? null : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        System.out.println("Текущий стек:");
        for (String dir : stack) {
            System.out.println(dir);
        }
    }
}
