public class NAND implements LogicOperator {
    private static NAND nand = new NAND();

    private int numA;
    private int numB;

    private NAND() {
    }

    public static NAND getInstance(int numA, int numB) {
        nand.setNumA(numA);
        nand.setNumB(numB);
        return nand;
    }

    public int getNumA() {
        return this.numA;
    }

    public int getNumB() {
        return this.numB;
    }

    private void setNumA(int numA) {
        this.numA = numA;
    }

    private void setNumB(int numB) {
        this.numB = numB;
    }

    public long solve() {
        return (long)(~(this.numA & this.numB)) & 0xffffffffl;
    }
}
