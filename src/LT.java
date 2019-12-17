public class LT implements LogicOperator {
    private int numA;
    private int numB;

    public LT() {
    }

    public int getNumA() {
        return this.numA;
    }

    public int getNumB() {
        return this.numB;
    }

    public void setNumA(int numA) {
        this.numA = numA;
    }

    public void setNumB(int numB) {
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
