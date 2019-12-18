public abstract class InstrSet {
    protected  String opCode; //TODO: could be made enum
    protected  long addressA;
    protected  long addressB;

    public abstract String getOpCode();
}
