//NULL OBJECT PATTERN
public class NullObject extends InstrSet {

    public NullObject(){
        this.opCode = null;
    }
    public long getAddressA() {
        return -1;
    }

    public long getAddressB() {
        return -1;
    }

    public String toString() {
        return  "null";
    }

    public final String getOpCode() {
        return "null";
    }
}
