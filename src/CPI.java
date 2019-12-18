public class CPI implements LogicOperator {
    private static CPI cpi = new CPI();

    private int numA;
    private int numB;

    private CPI() {
    }

    public static CPI getInstance(int numA, int numB) {
        cpi.setNumA(numA);
        cpi.setNumB(numB);
        return cpi;
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
        return this.numB;
    }
}
