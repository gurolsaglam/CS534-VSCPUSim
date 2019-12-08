public class Instruction {
    private String opCode; //TODO: could be made enum
    private int addressA;
    private int addressB;

    private String getOpCode() {
        return this.opCode;
    }

    private int getAddressA() {
        return this.addressA;
    }

    private int getAddressB() {
        return this.addressB;
    }
}
