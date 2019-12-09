import java.util.Iterator;

public class VSCPU {
    private ROM rom;
    private RAM ram;
    private VSCPUCore vscpuCore;

    public VSCPU(final Iterator iter1, final Iterator iter2) {
        rom =  new ROM(iter1);
        ram = new RAM(iter2);
        vscpuCore = new VSCPUCore(); //TODO find a way to give opcodes to initialize operators
    }

    public static void simulate(int type) {
        if (type == 0) {
            simulateAll();
        } else {
            simulateLine();
        }
    }

    private static void simulateAll() {
        System.out.println("simulate all code.");
    }

    private static void simulateLine() {
        System.out.println("simulate one line.");
    }

}
