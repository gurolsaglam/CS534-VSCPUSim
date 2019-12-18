public class CP implements LogicOperator {
    private static CP cp = new CP();

    private int numA;
    private int numB;

    private CP() {
    }

    public static CP getInstance(int numA, int numB) {
        cp.setNumA(numA);
        cp.setNumB(numB);
        return cp;
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
        return this.numB;
    }
}
