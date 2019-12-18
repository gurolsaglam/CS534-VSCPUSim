import java.util.ArrayList;

public class ROM{
    private final ArrayList<InstrSet> memory;

    public ROM(final LineIterator iterator) {
        this.memory = new ArrayList<InstrSet>();
        this.initializeMemory(iterator);
    }

    //BUILDER PATTERN
    private void initializeMemory(LineIterator iterator) {
        while (iterator.hasNext()) {
            String[] temp = ((String) iterator.next()).split(" ");
            int address = Integer.parseInt(temp[0].split(":")[0]);
            String opCode = temp[1];
            int addressA = Integer.parseInt(temp[2]);
            int addressB = Integer.parseInt(temp[3]);
            if (this.memory.size() <= address) {
                for (int i = this.memory.size(); i < address; i++) {
                    this.memory.add(new NullObject());
                }
                this.memory.add(new Instruction(opCode, addressA, addressB));
            } else {
                this.memory.set(address, new Instruction(opCode, addressA, addressB));
            }
        }
    }

    public Object getFrom(long address) {
        if (this.memory.size() <= address) {
            for (int i = this.memory.size(); i <= address; i++) {
                this.memory.add(new NullObject());
            }
        }
        return this.memory.get((int) address);
    }
}
