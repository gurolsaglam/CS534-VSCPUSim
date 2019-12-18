public class LT implements LogicOperator {
    private static LT lt = new LT();

    private int numA;
    private int numB;

    private LT() {
    }

    public static LT getInstance(int numA, int numB) {
        lt.setNumA(numA);
        lt.setNumB(numB);
        return lt;
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
        if ((this.numA & 0xffffffffl) < (this.numB & 0xffffffffl)) {
            return 1L;
        } else {
            return 0L;
        }
    }
}
