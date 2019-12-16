public class VSCPUCore {
    private ADD add;
    private NAND nand;
    private SRL srl;
    private LT lt;
    private CP cp;
    private CPI cpi;
    private BZJ bzj;
    private MUL mul;

    private int pCounter = 0;

    public VSCPUCore() {
        add = new ADD(); //TODO make these proxies and let them initialize actual operations during simulation
        nand = new NAND();
        srl = new SRL();
        lt = new LT();
        cp = new CP();
        cpi = new CPI();
        bzj = new BZJ();
        mul = new MUL();
    }

    public int getpCounter() {
        return this.pCounter;
    }

    public void setpCounter(final int pCounter) {
        this.pCounter = pCounter;
    }

    public int[] doOperation(Instruction instruction) {
        int[] result = new int[3];
        if (isJump(instruction)) {
            result[0] = 1;
            if (instruction.getOpCode() == "BZJi") {
                result[1] = bzj.solve(true, pCounter);
            } else {
                result[1] = bzj.solve(false, pCounter);
            }
        } else {
            result[0] = 0;
            result[1] = 1; //TODO resolve what operation it is and resolve the writing address and the data
            result[2] = 1;
        }
        return result;
    }

    private boolean isJump(Instruction instruction) {
        String opCode = instruction.getOpCode();
        if (opCode == "BZJ" || opCode == "BZJi") {
            return true;
        }
        return false;
    }
}
