public class NAND implements Operator {
    private int numA;
    private int numB;

    public NAND() {
    }

    private int getNumA() {
        return this.numA;
    }

    private int getNumB() {
        return this.numB;
    }

    private void setNumA(int numA) {
        this.numA = numA;
    }

    private void setNumB(int numB) {
        this.numB = numB;
    }

    private int solve() {
        return ~(numA & numB);
    }
}
