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
        //Returns a three element array.
        //The first element is wrEn, can be 1 or 0.
        //The second is the address for the RAM,
        //the third is the data to be written.
        this.state = 0;
        this.num2 = data;
        int pCounterNext = this.pCounter;
        int[] result = new int[3];
        if (isJump(this.opCode)) {
            result[0] = 0;
            result[1] = 0;
            result[2] = 0;
            bzj.setNumA(this.num1);
            bzj.setNumB(this.num2);
            if (this.opCode.equals("BZJi")) {
                pCounterNext = bzj.solve(true, pCounter);
            } else {
                pCounterNext = bzj.solve(false, pCounter);
            }
        } else {
            pCounterNext = pCounter + 1;
            result[0] = 1;
            if (this.opCode.equals("CPIi")) {
                result[1] = this.num1;
            } else {
                result[1] = this.addressA;
            }
        }
        //TODO resolve mediator to solve operation?
        result[2] = 0;
        if (this.pCounter == pCounterNext) { //Stop results, result = [0, MAX, MAX]
            result[1] = Integer.MAX_VALUE;
            result[2] = Integer.MAX_VALUE;
        }
        this.pCounter = pCounterNext;
        return result;
    }

    private boolean isJump(String opCode) {
        if (opCode.equals("BZJ") || opCode.equals("BZJi")) { //TODO ugly code
            return true;
        }
        return false;
    }
}
