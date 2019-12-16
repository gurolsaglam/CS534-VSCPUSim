public class Instruction {
    private final String opCode; //TODO: could be made enum
    private final int addressA;
    private final int addressB;

    public Instruction(String opCode, int addressA, int addressB) {
        this.opCode = opCode;
        this.addressA = addressA;
        this.addressB = addressB;
    }

    final String getOpCode() {
        return this.opCode;
    }

    private int getAddressA() {
        return this.addressA;
    }

    private int getAddressB() {
        return this.addressB;
    }
}
