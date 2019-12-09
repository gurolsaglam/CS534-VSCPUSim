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

    public int solve() {
        if (numA < numB) {
            return 1;
        } else {
            return 0;
        }
    }
}
