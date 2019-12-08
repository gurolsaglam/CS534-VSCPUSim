public class SRL implements Operator {
    private int numA;
    private int numB;

    public SRL() {
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

    private int solve() {
        if (numB < 32) {
            return numA >>> numB;
        } else {
            return numA <<< (numB - 32);
        }
    } //signed shift << >>, unsigned shift <<< >>>
}
