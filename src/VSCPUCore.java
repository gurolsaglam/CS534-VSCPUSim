public class VSCPUCore {
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

    public VSCPUCore() {
        this.operatorMediator = OperatorMediator.getInstance();
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

    public long getpCounter() {
        this.state.fetchInstruction();
        return this.pCounter;
    }

    public long parseInstruction(Instruction instruction) {
        this.state.parseInstruction();
        this.opCode = instruction.getOpCode();
        this.addressA = instruction.getAddressA();
        this.addressB = instruction.getAddressB();
        if (this.operatorMediator.isCPI(this.opCode)) {
            return this.addressB;
        }
        return this.addressA;
    }

    public long writeDataAndSendNextAddress(int data) {
        this.state.getSecondData();
        if (this.operatorMediator.isCPI(this.opCode)) {
            this.num2 = data;
            return this.num2;
        } else {
            this.num1 = data;
            return this.addressB;
        }
    }

    public long[] execute(int data) {
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
