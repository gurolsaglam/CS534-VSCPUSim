//NULL OBJECT PATTERN implemented
public class NullObject extends InstrSet {

    public NullObject(String opCode){
        this.opCode = opCode;
        this.addressA = 0;
        this.addressB = 0;
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
}
