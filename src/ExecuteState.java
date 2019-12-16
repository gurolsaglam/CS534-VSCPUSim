public class ExecuteState implements State {
    private VSCPUCore vscpuCore;
    public ExecuteState(VSCPUCore vscpuCore) {
        this.vscpuCore = vscpuCore;
    }

    @Override
    public boolean fetchInstruction() {
        return false;
    }

    @Override
    public boolean parseInstruction() {
        return false;
    }

    @Override
    public boolean getSecondData() {
        return false;
    }

    @Override
    public boolean executeInstruction() {
        this.vscpuCore.setState(this.vscpuCore.getInstructionFetchState());
        return true;
    }
}
