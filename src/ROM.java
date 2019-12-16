import java.util.ArrayList;

public class ROM{
    private final ArrayList<Instruction> memory;
    private final ArrayList<Instruction> opCodeList;

    public ROM(final LineIterator iterator) {
        this.memory = new ArrayList<Instruction>();
        this.opCodeList = new ArrayList<Instruction>();
        while (iterator.hasNext()) {
            String temp = (String) iterator.next();
            String[] temp2 = temp.split(" ");
            String opCode = temp2[0];
            int addressA = Integer.parseInt(temp2[1]);
            int addressB = Integer.parseInt(temp2[2]);
            this.memory.add(new Instruction(opCode, addressA, addressB));
        }
        for(int i = 0; i < this.memory.size(); i++){
            for(int j = 0; j < i; j++){
                if(this.memory.get(j) == memory.get(i)){
                    System.out.println("This opCode already exists.");
                }
            }
            this.opCodeList.add(this.memory.get(i));
        }
    }

    public Object getFrom(int address) {
        return memory.get(address);
    }


    public ArrayList<Instruction> getOpCodeList(){
        return opCodeList;
    }
    //TODO getOPcodes
}
