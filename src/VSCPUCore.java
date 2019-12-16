public class VSCPUCore {
    private ADD add;
    private NAND nand;
    private SRL srl;
    private LT lt;
    private CP cp;
    private CPI cpi;
    private BZJ bzj;
    private MUL mul;

    private final State instructionFetchState;
    private final State dataFetchFirstState;
    private final State dataFetchSecondState;
    private final State executeState;

    private int pCounter = 0;
    private State state;

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

        this.instructionFetchState = new InstructionFetchState(this);
        this.dataFetchFirstState = new DataFetchFirstState(this);
        this.dataFetchSecondState = new DataFetchSecondState(this);
        this.executeState = new ExecuteState(this);
        this.state = this.instructionFetchState;

    }

    public State getInstructionFetchState() {
        return this.instructionFetchState;
    }

    public State getDataFetchFirstState() {
        return this.dataFetchFirstState;
    }

    public State getDataFetchSecondState() {
        return this.dataFetchSecondState;
    }

    public State getExecuteState() {
        return this.executeState;
    }

    public void setState(final State state) {
        this.state = state;
    }

    public int getpCounter() {
        this.state.fetchInstruction();
        return this.pCounter;
    }

    public int parseInstruction(Instruction instruction) {
        this.state.parseInstruction();
        this.opCode = instruction.getOpCode();
        this.addressA = instruction.getAddressA();
        this.addressB = instruction.getAddressB();
        if (this.opCode.equals("CPI")) { //TODO is there a more elegant way for this? seems impractical.
            return this.addressB;
        }
        return this.addressA;
    }

    public int writeDataAndSendNextAddress(int data) {
        this.state.getSecondData();
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
        this.state.executeInstruction();
        this.num2 = data;
        int pCounterNext = this.pCounter;
        int[] result = new int[3];
        if (this.isJump(this.opCode)) {
            result[0] = 0;
            result[1] = 0;
            result[2] = 0;
            if (this.opCode.equals("BZJi")) {
                this.bzj.setNumA(this.num1);
                this.bzj.setNumB(this.addressB);
                pCounterNext = this.bzj.solve(true, pCounter);
            } else {
                this.bzj.setNumA(this.num1);
                this.bzj.setNumB(this.num2);
                pCounterNext = this.bzj.solve(false, pCounter);
            }
        } else {
            pCounterNext = this.pCounter + 1;
            result[0] = 1;
            if (this.opCode.equals("CPIi")) {
                result[1] = this.num1;
            } else {
                result[1] = this.addressA;
            }

            //TODO resolve mediator to solve operation? VERY UGLY
            if (this.opCode.equals("ADD")) {
                this.add.setNumA(this.num1);
                this.add.setNumB(this.num2);
                result[2] = this.add.solve();
            } else if (this.opCode.equals("ADDi")) {
                this.add.setNumA(this.num1);
                this.add.setNumB(this.addressB);
                result[2] = this.add.solve();
            } else if (this.opCode.equals("NAND")) {
                this.nand.setNumA(this.num1);
                this.nand.setNumB(this.num2);
                result[2] = this.nand.solve();
            } else if (this.opCode.equals("NANDi")) {
                this.nand.setNumA(this.num1);
                this.nand.setNumB(this.addressB);
                result[2] = this.nand.solve();
            } else if (this.opCode.equals("SRL")) {
                this.srl.setNumA(this.num1);
                this.srl.setNumB(this.num2);
                result[2] = this.srl.solve();
            } else if (this.opCode.equals("SRLi")) {
                this.srl.setNumA(this.num1);
                this.srl.setNumB(this.addressB);
                result[2] = this.srl.solve();
            } else if (this.opCode.equals("LT")) {
                this.lt.setNumA(this.num1);
                this.lt.setNumB(this.num2);
                result[2] = this.lt.solve();
            } else if (this.opCode.equals("LTi")) {
                this.lt.setNumA(this.num1);
                this.lt.setNumB(this.addressB);
                result[2] = this.lt.solve();
            } else if (this.opCode.equals("CP")) {
                this.cp.setNumA(this.num1);
                this.cp.setNumB(this.num2);
                result[2] = this.cp.solve();
            } else if (this.opCode.equals("CPi")) {
                this.cp.setNumA(this.num1);
                this.cp.setNumB(this.addressB);
                result[2] = this.cp.solve();
            } else if (this.opCode.equals("CPI")) {
                this.cpi.setNumA(this.num1);
                this.cpi.setNumB(this.num2);
                result[2] = this.cpi.solve();
            } else if (this.opCode.equals("CPIi")) {
                this.cpi.setNumA(this.num1);
                this.cpi.setNumB(this.num2);
                result[2] = this.cpi.solve();
            } else if (this.opCode.equals("MUL")) {
                this.mul.setNumA(this.num1);
                this.mul.setNumB(this.num2);
                result[2] = this.mul.solve();
            } else if (this.opCode.equals("MULi")) {
                this.mul.setNumA(this.num1);
                this.mul.setNumB(this.addressB);
                result[2] = this.mul.solve();
            } else {
                System.out.println("Unrecognized operation.");
                System.out.println(new Instruction(this.opCode, this.addressA, this.addressB).toString());
                result[0] = 0;
                result[1] = 0;
                result[2] = 0;
            }

        }

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
