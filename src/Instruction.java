public class Instruction {
    private String opCode; //TODO: could be made enum
    private int addressA;
    private int addressB;

    public Instruction(String opCode, int addressA, int addressB) {
        this.opCode = opCode;
        this.addressA = addressA;
        this.addressB = addressB;
    }

    String getOpCode() {
        return this.opCode;
    }

    private int getAddressA() {
        return this.addressA;
    }

    private int getAddressB() {
        return this.addressB;
    }
}
