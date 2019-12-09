import java.util.ArrayList;
import java.util.Iterator;

public interface Memory {

    public Object getFrom(int address); //TODO can we change Object to Word like a superclass for data and instruction and null object?
}
