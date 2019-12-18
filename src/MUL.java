public class MUL implements LogicOperator {
    private static MUL mul = new MUL();

    private int numA;
    private int numB;

    private MUL() {
    }

    public static MUL getInstance(int numA, int numB) {
        mul.setNumA(numA);
        mul.setNumB(numB);
        return mul;
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
        return (long)(numA * numB) & 0xffffffffl;
    }
}
