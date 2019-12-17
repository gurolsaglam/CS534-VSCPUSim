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

    public long solve() {
        if (this.numB < 32) {
            return (long) (this.numA >>> this.numB) & 0xffffffffl;
        } else {
            return (long)(this.numA << (this.numB - 32)) & 0xffffffffl;
        }
    } //signed shift << >>, unsigned shift <<< >>>
}
