public class VSCPU {
    private ROM rom;
    private RAM ram;
    private VSCPUCore vscpuCore;

    public VSCPU() {
        rom =  new ROM();
        ram = new RAM();
        vscpuCore = new VSCPUCore();
    }

    public void simulate(int type) {
        if (type == 0) {
            simulateAll();
        } else {
            simulateLine();
        }
    }

    private void simulateAll() {
        System.out.println("simulate all code.");
    }

    private void simulateLine() {
        System.out.println("simulate one line.");
    }

}
