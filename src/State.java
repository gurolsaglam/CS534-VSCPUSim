//STATE PATTERN
public interface State {
    void fetchInstruction();

    void parseInstruction();

    void getSecondData();

    void executeInstruction();
}
