import java.util.ArrayList;

public class RAM implements Memory{
    private ArrayList<Integer> memory;

    public RAM(final LineIterator iterator) {
        memory = new ArrayList<Integer>();
        while (iterator.hasNext()) {
            memory.add((Integer) iterator.next());//TODO change this because iter will provide the "line" in asm file
        }
    }

    public Object getFrom(int address) {
        return memory.get(address);
    }

    public void setData(int address, int data) {
        memory.set(address, data);
    }
}
