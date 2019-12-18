public class ADD implements LogicOperator {
    private static ADD add = new ADD();

    private int numA;
    private int numB;

    private ADD() {
    }

    public static ADD getInstance(int numA, int numB) {
        add.setNumA(numA);
        add.setNumB(numB);
        return add;
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
        return (long)(this.numA + this.numB) & 0xffffffffl;
    }
}
