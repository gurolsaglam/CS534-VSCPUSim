public class BZJ implements Operator {
    private int numA;
    private int numB;

    public BZJ() {
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

    private int solve(boolean immediate, int pCounter) {
        return (immediate) ? (numA + numB):((numB == 0) ? numA: pCounter+1);
    }
}
