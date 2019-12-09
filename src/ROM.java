import java.util.ArrayList;
import java.util.Iterator;

public class ROM{
    private ArrayList<Instruction> memory;

    public ROM(final Iterator iter) {
        memory = new ArrayList<Instruction>();
        while (iter.hasNext()) {
            memory.add((Instruction) iter.next());//TODO change this because iter will provide the "line" in asm file
        }
    }

    public Object getFrom(int address) {
        return memory.get(address);
    }
}
