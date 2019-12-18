public class ExecuteState implements State {
    private VSCPUCore vscpuCore;
    public ExecuteState(VSCPUCore vscpuCore) {
        this.vscpuCore = vscpuCore;
    }

    @Override
    public void fetchInstruction() {
    }

    @Override
    public void parseInstruction() {
    }

    @Override
    public void getSecondData() {
    }

    @Override
    public void executeInstruction() {
        this.vscpuCore.setState(this.vscpuCore.getInstructionFetchState());
    }
}
