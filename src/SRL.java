public class SRL implements LogicOperator {
    private int numA;
    private int numB;

    public SRL() {
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

    public int solve() {
        if (numB < 32) {
            return numA >>> numB;
        } else {
            return (numA << (numB - 32));
        }
    } //signed shift << >>, unsigned shift <<< >>>
}
