public class ROM{
    private ArrayList<Instruction> memory;

    public ROM(Iterator iter) {
        memory = new ArrayList<Instruction>();
        while (iter.hasNext()) {
            memory.add(iter.next());//TODO change this because iter will provide the "line" in asm file
        }
    }
}
