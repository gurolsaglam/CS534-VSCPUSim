public class BZJ implements PCOperator {
    private int numA;
    private int numB;

    public BZJ() {
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

    public long solve(boolean immediate, long pCounter) {
        return (immediate) ? ((long)(this.numA + this.numB) & 0xffffffffl):((this.numB == 0) ? this.numA: (long)(pCounter+1) & 0xffffffffl);
    }
}
