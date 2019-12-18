import java.util.ArrayList;

public class ROM{
    private static ROM rom = null;
    private final ArrayList<InstrSet> memory;

    private ROM(final LineIterator iterator) {
        this.memory = new ArrayList<InstrSet>();
        this.initializeMemory(iterator);
    }

    public static ROM getInstance(LineIterator iterator) {
        if (rom == null) {
            rom = new ROM(iterator);
        }
        return rom;
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
                    if (this.memory.get(0) == null) {
                        this.memory.add(NullObject.getInstance("ADD"));
                    } else {
                        this.memory.add(NullObject.getInstance(this.memory.get(0).getOpCode()));
                    }
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
                if (this.memory.get(0) == null) {
                    this.memory.add(NullObject.getInstance("ADD"));
                } else {
                    this.memory.add(NullObject.getInstance(this.memory.get(0).getOpCode()));
                }
            }
        }
        return this.memory.get((int) address);
    }
}
