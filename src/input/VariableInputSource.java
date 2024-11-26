package input;

public class VariableInputSource implements InputSource {
    private final String input;

    public VariableInputSource(String input) {
        this.input = input;
    }

    @Override
    public String getInput() {
        return input;
    }
}
