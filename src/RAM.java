import java.util.ArrayList;

public class RAM implements Memory{
    private static RAM ram = null;
    private ArrayList<Integer> memory;

    private RAM(final LineIterator iterator) {
        memory = new ArrayList<Integer>();
        initializeMemory(iterator);
    }

    public static RAM getInstance(LineIterator iterator) {
        if (ram == null) {
            ram = new RAM(iterator);
        }
        return ram;
    }

    //BUILDER PATTERN
    private void initializeMemory(LineIterator iterator) {
        while (iterator.hasNext()) {
            String[] temp = ((String) iterator.next()).split(" ");
            int address = Integer.parseInt(temp[0].split(":")[0]);
            int data = Integer.parseInt(temp[1]);
            if (this.memory.size() <= address) {
                for (int i = this.memory.size(); i < address; i++) {
                    this.memory.add(0);
                }
                this.memory.add(data);
            } else {
                this.memory.set(address, data);
            }
        }
    }

    public Object getFrom(long address) {
        if (this.memory.size() <= address) {
            for (int i = this.memory.size(); i <= address; i++) {
                this.memory.add(0);
            }
        }
        return memory.get((int) address);
    }

    public void setData(int wrEn, long address, int data) {
        if (wrEn != 0) {
            memory.set((int) address, data);
        }
    }
}
