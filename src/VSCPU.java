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
    public boolean simulate(int type) {
        if (type == 0) {
            return simulateAll();
        } else {
            return simulateLine();
        }
    }

    private boolean simulateAll() { //TODO return a string "memories" of simulation, and in simulate all, we need X amount of string returned to publish to gui? Or maybe allocate the JTextArea to this method but this removes M-V-C.
        //Todo print a starting string?
        while (true) {
            long pCounter = this.vscpuCore.getpCounter();
            Instruction instruction = (Instruction) this.rom.getFrom(pCounter);

            long address = this.vscpuCore.parseInstruction(instruction);
            int data = (int) this.ram.getFrom(address);

            address = vscpuCore.writeDataAndSendNextAddress(data);
            data = (int) this.ram.getFrom(address);

            long[] result = vscpuCore.execute(data);
            this.ram.setData((int) result[0], result[1], (int) result[2]);
            if (result[0] == 0 && result[1] == Integer.MAX_VALUE && result[2] == Integer.MAX_VALUE) {
                System.out.println("The simulation has finished.");
                return true;
            }
            System.out.println("simulate all code."); //TODO print initial memory and final memory?
        }
    }

    private boolean simulateLine() {
        long pCounter = this.vscpuCore.getpCounter();
        Instruction instruction = (Instruction) this.rom.getFrom(pCounter);

        long address = this.vscpuCore.parseInstruction(instruction);
        int data = (int) this.ram.getFrom(address);

        address = vscpuCore.writeDataAndSendNextAddress(data);
        data = (int) this.ram.getFrom(address);

        long[] result = vscpuCore.execute(data);
        this.ram.setData((int) result[0], result[1], (int) result[2]);
        System.out.println("simulate one line.");
        if (result[0] == 0 && result[1] == Integer.MAX_VALUE && result[2] == Integer.MAX_VALUE) {
            System.out.println("The simulation has finished.");
            return true;
        } else {
            return false;
        }
    }

}
