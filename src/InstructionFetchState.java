public class InstructionFetchState implements State{
    private static InstructionFetchState instructionFetchState = null;
    private VSCPUCore vscpuCore;
    private InstructionFetchState(VSCPUCore vscpuCore) {
        this.vscpuCore = vscpuCore;
    }

    public static InstructionFetchState getInstance(VSCPUCore vscpuCore) {
        if (instructionFetchState == null) {
            instructionFetchState = new InstructionFetchState(vscpuCore);
        }
        return instructionFetchState;
    }

    @Override
    public void fetchInstruction() {
        this.vscpuCore.setState(this.vscpuCore.getDataFetchFirstState());
    }

    @Override
    public void parseInstruction() {
    }

    @Override
    public void getSecondData() {
    }

    @Override
    public void executeInstruction() {
    }
}
