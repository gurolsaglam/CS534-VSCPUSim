import java.util.Enumeration;

public class BZJ implements PCOperator {
    private static BZJ bzj = new BZJ();

    private int numA;
    private int numB;

    private BZJ() {
    }

    public static BZJ getInstance(int numA, int numB) {
        bzj.setNumA(numA);
        bzj.setNumB(numB);
        return bzj;
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

    public long solve(boolean immediate, long pCounter) {
        return (immediate) ? ((long)(this.numA + this.numB) & 0xffffffffl):((this.numB == 0) ? this.numA: (long)(pCounter+1) & 0xffffffffl);
    }
}
