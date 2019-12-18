public class DataFetchSecondState implements State {
    private VSCPUCore vscpuCore;
    public DataFetchSecondState(VSCPUCore vscpuCore) {
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
        this.vscpuCore.setState(this.vscpuCore.getExecuteState());
    }

    @Override
    public void executeInstruction() {
    }
}
