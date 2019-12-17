public class DataFetchSecondState implements State {
    private VSCPUCore vscpuCore;
    public DataFetchSecondState(VSCPUCore vscpuCore) {
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
        this.vscpuCore.setState(this.vscpuCore.getExecuteState());
        return true;
    }

    @Override
    public boolean executeInstruction() {
        return false;
    }
}
