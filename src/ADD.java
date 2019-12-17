public class ADD implements LogicOperator {
    private int numA;
    private int numB;

    public ADD() {
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
        return (long)(this.numA + this.numB) & 0xffffffffl;
    }
}
