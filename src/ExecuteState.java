public class ExecuteState implements State {
    private static ExecuteState executeState = null;
    private VSCPUCore vscpuCore;
    private ExecuteState(VSCPUCore vscpuCore) {
        this.vscpuCore = vscpuCore;
    }

    public static ExecuteState getInstance(VSCPUCore vscpuCore) {
        if (executeState == null) {
            executeState = new ExecuteState(vscpuCore);
        }
        return executeState;
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
