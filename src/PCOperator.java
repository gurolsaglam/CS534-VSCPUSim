public interface PCOperator extends Operator {
    public int getNumA();
    public int getNumB();
    public void setNumA(int numA);
    public void setNumB(int numB);
    public long solve(boolean immediate, long pCounter); //for BZJ ad BZJi
}
