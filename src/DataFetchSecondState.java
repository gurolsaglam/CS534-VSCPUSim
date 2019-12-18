public class DataFetchSecondState implements State {
    private static DataFetchSecondState dataFetchSecondState = null;
    private VSCPUCore vscpuCore;
    private DataFetchSecondState(VSCPUCore vscpuCore) {
        this.vscpuCore = vscpuCore;
    }

    public static DataFetchSecondState getInstance(VSCPUCore vscpuCore) {
        if (dataFetchSecondState == null) {
            dataFetchSecondState = new DataFetchSecondState(vscpuCore);
        }
        return dataFetchSecondState;
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
