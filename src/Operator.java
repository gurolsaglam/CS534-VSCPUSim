public interface Operator {
    private int numA;
    private int numB;

    private int getNumA();
    private int getNumB();
    private void setNumA(int numA);
    private void setNumB(int numB);
    private int solve();
    private int solve(boolean immediate, int pCounter); //for BZJ ad BZJi
}
