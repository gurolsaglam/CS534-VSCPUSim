public class DataFetchFirstState implements State {
    private VSCPUCore vscpuCore;
    public DataFetchFirstState(VSCPUCore vscpuCore) {
        this.vscpuCore = vscpuCore;
    }

    @Override
    public boolean fetchInstruction() {
        return false;
    }

    @Override
    public boolean parseInstruction() {
        this.vscpuCore.setState(this.vscpuCore.getDataFetchSecondState());
        return true;
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
