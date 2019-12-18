
public interface Memory {
    Object getFrom(long address); //TODO can we change Object to Word like a superclass for data and instruction and null object?
    private void initializeMemory(LineIterator iterator) {

    };

}
