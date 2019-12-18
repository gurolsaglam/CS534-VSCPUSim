public class VSCPUCore {
    private static VSCPUCore vscpuCore = new VSCPUCore();
    private OperatorMediator operatorMediator;

    private final State instructionFetchState;
    private final State dataFetchFirstState;
    private final State dataFetchSecondState;
    private final State executeState;

    private long pCounter = 0;
    private State state;

    private String opCode;
    private long addressA;
    private long addressB;
    private int num1;
    private int num2;

    private VSCPUCore() {
        this.operatorMediator = OperatorMediator.getInstance();
        this.instructionFetchState = InstructionFetchState.getInstance(this);
        this.dataFetchFirstState = DataFetchFirstState.getInstance(this);
        this.dataFetchSecondState = DataFetchSecondState.getInstance(this);
        this.executeState = ExecuteState.getInstance(this);
        this.state = this.instructionFetchState;

    }

    public static VSCPUCore getInstance() {
        return vscpuCore;
    }

    protected State getInstructionFetchState() {
        return this.instructionFetchState;
    }

    protected State getDataFetchFirstState() {
        return this.dataFetchFirstState;
    }

    protected State getDataFetchSecondState() {
        return this.dataFetchSecondState;
    }

    protected State getExecuteState() {
        return this.executeState;
    }

    protected void setState(final State state) {
        this.state = state;
    }

    protected long getpCounter() {
        this.state.fetchInstruction();
        return this.pCounter;
    }

    protected long parseInstruction(Instruction instruction) {
        this.state.parseInstruction();
        this.opCode = instruction.getOpCode();
        this.addressA = instruction.getAddressA();
        this.addressB = instruction.getAddressB();
        if (this.operatorMediator.isCPI(this.opCode)) {
            return this.addressB;
        }
        return this.addressA;
    }

    protected long writeDataAndSendNextAddress(int data) {
        this.state.getSecondData();
        if (this.operatorMediator.isCPI(this.opCode)) {
            this.num2 = data;
            return this.num2;
        } else {
            this.num1 = data;
            return this.addressB;
        }
    }

    protected long[] execute(int data) {
        //Returns a three element array.
        //The first element is wrEn, can be 1 or 0.
        //The second is the address for the RAM,
        //the third is the data to be written.
        this.state.executeInstruction();
        this.num2 = data;

        long[] result = this.operatorMediator.resolveInstruction(this.pCounter, this.opCode, this.addressA, this.addressB, this.num1, this.num2);
        long pCounterNext = this.pCounter;
        if (result[0] == 0 && result[1] == 0) {
            pCounterNext = result[2];
        } else pCounterNext = this.pCounter + 1;

        if (this.pCounter == pCounterNext) { //Stop results, result = [0, MAX, MAX]
            result[1] = Integer.MAX_VALUE;
            result[2] = Integer.MAX_VALUE;
        }
        this.pCounter = pCounterNext;
        return result;
    }

    protected boolean isJump() {
        return this.operatorMediator.isJump(this.opCode);
    }
}
