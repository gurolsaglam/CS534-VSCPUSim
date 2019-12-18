public class Instruction extends InstrSet {


    public Instruction(String opCode, long addressA, long addressB) {
        this.opCode = opCode;
        this.addressA = addressA;
        this.addressB = addressB;
    }

    public final String getOpCode() {
        return this.opCode;
    }

    public long getAddressA() {
        return this.addressA;
    }

    public long getAddressB() {
        return this.addressB;
    }

    @Override
    public String toString() {
        return this.opCode + " " + this.addressA + " " + this.addressB;
    }
}
