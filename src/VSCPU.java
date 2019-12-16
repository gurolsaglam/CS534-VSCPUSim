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
        //Todo print a starting string?
        while (true) {
            int pCounter = this.vscpuCore.getpCounter();
            Instruction instruction = (Instruction) this.rom.getFrom(pCounter);

            int address = this.vscpuCore.parseInstruction(instruction);
            int data = (int) this.ram.getFrom(address);

            address = vscpuCore.writeDataAndSendNextAddress(data);
            data = (int) this.ram.getFrom(address);

            int[] result = vscpuCore.execute(data);
            this.ram.setData(result[0], result[1], result[2]);

            if (result[0] == 0 && result[1] == Integer.MAX_VALUE && result[2] == Integer.MAX_VALUE) {
                System.out.println("The simulation has finished.");
                break;
            }
            System.out.println("simulate all code."); //TODO print initial memory and final memory?
        }
    }

    private void simulateLine() {
        System.out.println("simulate one line.");
    }

}
