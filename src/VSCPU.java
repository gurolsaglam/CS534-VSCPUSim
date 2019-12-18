import javax.swing.*;

public class VSCPU {
    private ROM rom;
    private RAM ram;
    private VSCPUCore vscpuCore;
    private MessageMediator messageMediator;

    public VSCPU(LineIterator iter1, LineIterator iter2, JComponent jComponent) {
        rom =  new ROM(iter1);
        ram = new RAM(iter2);
        vscpuCore = new VSCPUCore();
        messageMediator = new MessageMediator(jComponent);
    }

    //STRATEGY PATTERN IS HERE
    protected boolean simulate(int type) {
        if (type == 0) {
            return simulateAll();
        } else {
            return simulateLine();
        }
    }

    private boolean simulateAll() {
        while (true) {
            boolean isFinished = this.simulateLine();
            if (isFinished) {
                return true;
            }
        }
    }

    private boolean simulateLine() {
        String simLine = this.getStars() + "\n";

        long pCounter = this.vscpuCore.getpCounter();
        Instruction instruction = (Instruction) this.rom.getFrom(pCounter);

        //get instruction
        simLine = simLine + this.getInstruction(pCounter) + "\n";

        long address1 = this.vscpuCore.parseInstruction(instruction);
        int data = (int) this.ram.getFrom(address1);

        long address2 = vscpuCore.writeDataAndSendNextAddress(data);
        data = (int) this.ram.getFrom(address2);

        //get memory before execution
        if (!this.vscpuCore.isJump()) {
            simLine = simLine + this.getMemory(true, address1, address2) + "\n";
        }

        long[] result = vscpuCore.execute(data);
        this.ram.setData((int) result[0], result[1], (int) result[2]);

        //get memory after execution
        if (!this.vscpuCore.isJump()) {
            simLine = simLine + this.getMemory(false, address1, address2) + "\n";
        }

        simLine = simLine + this.getStars() + "\n";

        if (result[0] == 0 && result[1] == Integer.MAX_VALUE && result[2] == Integer.MAX_VALUE) {
            simLine = simLine + this.getStars() + "\n";
            simLine = simLine + "The simulation has finished." + "\n";
            simLine = simLine + this.getStars() + "\n";
            this.messageMediator.sendMessage(simLine);
            return true;
        } else {
            this.messageMediator.sendMessage(simLine);
            return false;
        }
    }

    private String getStars() {
        return "* * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
    }

    private String getInstruction(long pCounter) {
        String result = "Program Counter\t: " + (int) pCounter + "\n";
        result = result + "Current instruction\t: " + ((Instruction) this.rom.getFrom(pCounter)).toString();
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
