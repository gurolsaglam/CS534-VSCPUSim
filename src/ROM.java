import java.util.ArrayList;
import java.util.Iterator;

public class ROM {
    private ArrayList<Instruction> memory;
    private ArrayList<Instruction> opCodeList;

        public ROM(final Iterator iter) {
            memory = new ArrayList<Instruction>();
            opCodeList = new ArrayList<Instruction>();
            while (iter.hasNext()) {
                memory.add((Instruction) iter.next());//TODO change this because iter will provide the "line" in asm file
            }
            opCodeList = orderOpCodes(opCodeList);
        }
        public Object getFrom(int address) {
            return memory.get(address);
        }

        private ArrayList<Instruction> orderOpCodes(ArrayList<Instruction> list) {

            for (int i = 0; i < memory.size(); i++) {
                for (int j = 0; j < i; j++) {
                    if (memory.get(j) == memory.get(i)) {
                        System.out.println("This opCode already exists.");
                    }
                }
                list.add(memory.get(i));

            }
        return list;
        }

        private ArrayList<Instruction> getOpCodeList () {
            return opCodeList;
        }
        //TODO getOPcodes

        private int getOpCodeListLength(){
            return opCodeList.size();
        }

    }

