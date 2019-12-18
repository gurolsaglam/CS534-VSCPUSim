//NULL OBJECT PATTERN implemented
public class NullObject extends InstrSet {
    private static NullObject nullObject = new NullObject();

    private NullObject(){
        this.opCode = "";
        this.addressA = 0;
        this.addressB = 0;
    }

    public static NullObject getInstance(String opCode) {
        nullObject.setOpCode(opCode);
        return nullObject;
    }

    public long getAddressA() {
        return this.addressA;
    }

    public long getAddressB() {
        return this.addressB;
    }

    public String toString() {
        return  this.opCode + " " + this.addressA + " " + this.addressB;
    }

    public final String getOpCode() {
        return this.opCode;
    }

    private void setOpCode(String opCode) {
        this.opCode = opCode;
    }
}
