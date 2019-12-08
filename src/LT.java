public class LT implements Operator {
    private int numA;
    private int numB;

    public LT() {
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
        if (numA < numB) {
            return 1;
        } else {
            return 0;
        }
    }
}
