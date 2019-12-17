public class CPI implements LogicOperator {
    private int numA;
    private int numB;

    public CPI() {
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
        return this.numB;
    }
}
