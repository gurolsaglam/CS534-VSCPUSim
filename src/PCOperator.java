public interface PCOperator extends Operator {
    public int getNumA();
    public int getNumB();
    public void setNumA(int numA);
    public void setNumB(int numB);
    public int solve(boolean immediate, int pCounter); //for BZJ ad BZJi
}
