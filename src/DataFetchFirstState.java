public class DataFetchFirstState implements State {
    private VSCPUCore vscpuCore;
    public DataFetchFirstState(VSCPUCore vscpuCore) {
        this.vscpuCore = vscpuCore;
    }

    @Override
    public void fetchInstruction() {
    }

    @Override
    public void parseInstruction() {
        this.vscpuCore.setState(this.vscpuCore.getDataFetchSecondState());
    }

    @Override
    public void getSecondData() {
    }

    @Override
    public void executeInstruction() {
    }
}
