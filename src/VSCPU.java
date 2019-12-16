public class VSCPU {
    private ROM rom;
    private RAM ram;
    private VSCPUCore vscpuCore;

    public VSCPU(LineIterator iter1, LineIterator iter2) {
        rom =  new ROM(iter1);
        ram = new RAM(iter2);
        vscpuCore = new VSCPUCore(); //TODO find a way to give opcodes to initialize operators or maybe Proxies will initialize operations anyway?
    }

    //STRATEGY PATTERN IS HERE
    public void simulate(int type) {
        if (type == 0) {
            simulateAll();
        } else {
            simulateLine();
        }
    }

    private void simulateAll() {
        int pCounter = vscpuCore.getpCounter(); //TODO change state in the core
        Instruction instruction = (Instruction) rom.getFrom(pCounter);
        int[] result = vscpuCore.doOperation(instruction);
        if (result[0] == 1) {
            vscpuCore.setpCounter(result[1]);
        } else {
            ram.setData(result[1], result[2]);
            vscpuCore.setpCounter(pCounter + 1);
        }

        System.out.println("simulate all code.");
    }

    private void simulateLine() {
        System.out.println("simulate one line.");
    }

}
