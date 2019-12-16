//STATE PATTERN
public interface State {
    boolean fetchInstruction();

    boolean parseInstruction();

    boolean getSecondData();

    boolean executeInstruction();
}
