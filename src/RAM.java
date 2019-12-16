import java.util.ArrayList;

public class RAM implements Memory{
    private ArrayList<Integer> memory;

    public RAM(final LineIterator iterator) {
        memory = new ArrayList<Integer>();
        initializeMemory(iterator);
    }

    //BUILDER PATTERN
    private void initializeMemory(LineIterator iterator) {
        while (iterator.hasNext()) {
            String[] temp = ((String) iterator.next()).split(" ");
            int address = Integer.parseInt(temp[0].split(":")[0]);
            int data = Integer.parseInt(temp[1]);
            if (this.memory.size() <= address) {
                for (int i = this.memory.size(); i < address; i++) {
                    this.memory.add(0); //TODO NullObject or just 0?
                }
                this.memory.add(data);
            } else {
                this.memory.set(address, data);
            }
        }
    }

    public Object getFrom(int address) {
        return memory.get(address);
    }

    public void setData(int wrEn, int address, int data) {
        if (wrEn != 0) {
            memory.set(address, data);
        }
    }
}
