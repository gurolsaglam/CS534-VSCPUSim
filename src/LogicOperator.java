public interface LogicOperator extends Operator {
    public int getNumA();
    public int getNumB();
    public void setNumA(int numA);
    public void setNumB(int numB);
    public long solve();
}
