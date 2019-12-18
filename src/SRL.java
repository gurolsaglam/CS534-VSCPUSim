public class SRL implements LogicOperator {
    private static SRL srl = new SRL();

    private int numA;
    private int numB;

    private SRL() {
    }

    public static SRL getInstance(int numA, int numB) {
        srl.setNumA(numA);
        srl.setNumB(numB);
        return srl;
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
        if (this.numB < 32) {
            return (long) (this.numA >>> this.numB) & 0xffffffffl;
        } else {
            return (long)(this.numA << (this.numB - 32)) & 0xffffffffl;
        }
    } //signed shift << >>, unsigned shift <<< >>>
}
