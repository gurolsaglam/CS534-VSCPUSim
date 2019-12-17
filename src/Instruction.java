public class Instruction {
    private final String opCode; //TODO: could be made enum
    private final long addressA;
    private final long addressB;

    public Instruction(String opCode, long addressA, long addressB) {
        this.opCode = opCode;
        this.addressA = addressA;
        this.addressB = addressB;
    }

    final String getOpCode() {
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
        return "Instruction{" +
                "opCode='" + opCode + '\'' +
                ", addressA=" + addressA +
                ", addressB=" + addressB +
                '}';
    }
}
