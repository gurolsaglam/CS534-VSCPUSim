public class DataFetchFirstState implements State {
    private static DataFetchFirstState dataFetchFirstState = null;
    private VSCPUCore vscpuCore;
    private DataFetchFirstState(VSCPUCore vscpuCore) {
        this.vscpuCore = vscpuCore;
    }

    public static DataFetchFirstState getInstance(VSCPUCore vscpuCore) {
        if (dataFetchFirstState == null) {
            dataFetchFirstState = new DataFetchFirstState(vscpuCore);
        }
        return dataFetchFirstState;
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
