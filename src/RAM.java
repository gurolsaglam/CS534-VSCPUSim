import java.util.ArrayList;
import java.util.Iterator;

public class RAM implements Memory{
    private ArrayList<Integer> memory;

    public RAM(final Iterator iter) {
        memory = new ArrayList<Integer>();
        while (iter.hasNext()) {
            memory.add((Integer) iter.next());//TODO change this because iter will provide the "line" in asm file
        }
    }

    public Object getFrom(int address) {
        return memory.get(address);
    }

    public void setData(int address, int data) {
        memory.set(address, data);
    }
}
