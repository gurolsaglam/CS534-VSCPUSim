public class InstructionFetchState implements State{
    private VSCPUCore vscpuCore;
    public InstructionFetchState(VSCPUCore vscpuCore) {
        this.vscpuCore = vscpuCore;
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
