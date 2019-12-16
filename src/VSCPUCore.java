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
    private int state = 0; //TODO will be a pattern

    private String opCode;
    private int addressA;
    private int addressB;
    private int num1;
    private int num2;

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

    public int getpCounter() {//TODO change state
        this.state = 1;
        return this.pCounter;
    }

    public void setpCounter(final int pCounter) {
        this.pCounter = pCounter;
    }

    public int parseInstruction(Instruction instruction) { //TODO change state
        this.opCode = instruction.getOpCode();
        this.addressA = instruction.getAddressA();
        this.addressB = instruction.getAddressB();
        this.state = 2;
        if (this.opCode.equals("CPI")) { //TODO is there a more elegant way for this? seems impractical.
            return this.addressB;
        }
        return this.addressA;
    }

    public int writeDataAndSendNextAddress(int data) { //TODO change state
        this.state = 3;
        if (this.opCode.equals("CPI")) {
            this.num2 = data;
            return this.num2;
        } else {
            this.num1 = data;
            return this.addressB;
        }
    }

    public int[] execute(int data) { //TODO change state
        this.state = 0;
        this.num2 = data;
        if (isJump(this.opCode)) {

        }
        if (this.opCode.equals("CPIi")) {

        } else {

        }
        return new int[3];
    }

    /*public int[] doOperation(Instruction instruction) {
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
    }*/

    private boolean isJump(String opCode) {
        if (opCode == "BZJ" || opCode == "BZJi") {
            return true;
        }
        return false;
    }
}
