public class InstructionFetchState implements State{
    private VSCPUCore vscpuCore;
    public InstructionFetchState(VSCPUCore vscpuCore) {
        this.vscpuCore = vscpuCore;
    }

    @Override
    public boolean fetchInstruction() {
        this.vscpuCore.setState(this.vscpuCore.getDataFetchFirstState());
        return true;
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
        return false;
    }
}
