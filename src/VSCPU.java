public class VSCPU {
    private ROM rom;
    private RAM ram;
    private VSCPUCore vscpuCore;

    public VSCPU(LineIterator iter1, LineIterator iter2) {
        rom =  new ROM(iter1);
        ram = new RAM(iter2);
        vscpuCore = new VSCPUCore();
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
        while (true) {
            boolean isFinished = this.simulateLine();
            if (isFinished) {
                return true;
            }
        }
    }

    private boolean simulateLine() {
        System.out.println(this.getStars());

        long pCounter = this.vscpuCore.getpCounter();
        Instruction instruction = (Instruction) this.rom.getFrom(pCounter);

        //print instruction
        System.out.println(this.getInstruction(pCounter));

        long address1 = this.vscpuCore.parseInstruction(instruction);
        int data = (int) this.ram.getFrom(address1);

        long address2 = vscpuCore.writeDataAndSendNextAddress(data);
        data = (int) this.ram.getFrom(address2);

        //print memory before execution
        System.out.println(this.getMemory(true, address1, address2));

        long[] result = vscpuCore.execute(data);
        this.ram.setData((int) result[0], result[1], (int) result[2]);

        //print memory after execution
        System.out.println(this.getMemory(false, address1, address2));

        System.out.println(this.getStars());

        if (result[0] == 0 && result[1] == Integer.MAX_VALUE && result[2] == Integer.MAX_VALUE) {
            System.out.println(this.getStars());
            System.out.println("The simulation has finished.");
            System.out.println(this.getStars());
            return true;
        } else {
            return false;
        }
    }

    private String getStars() {
        return "* * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
    }

    private String getInstruction(long pCounter) {
        String result = "Program Counter\t: " + (int) pCounter + "\n";
        result = result + ((Instruction) this.rom.getFrom(pCounter)).toString();
        return result;
    }

    private String getMemory(boolean isBefore, long address1, long address2) {
        String result = "Memory content ";
        if (isBefore) {
            result = result + "before ";
        } else {
            result = result + "after ";
        }
        result = result + "executing instruction";
        result = result + "\nmem[" + (int) address1 + "]\t\t: " + Long.toString((int) this.ram.getFrom(address1) & 0xFFFFFFFFl);
        result = result + "\nmem[" + (int) address2 + "]\t\t: " + Long.toString((int) this.ram.getFrom(address2) & 0xFFFFFFFFl);
        return result;
    }

}
