public class MUL implements LogicOperator {
    private int numA;
    private int numB;

    public MUL() {
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
        return numA * numB;
    }
}
