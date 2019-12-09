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

    public int solve(boolean immediate, int pCounter) {
        return (immediate) ? (numA + numB):((numB == 0) ? numA: pCounter+1);
    }
}
