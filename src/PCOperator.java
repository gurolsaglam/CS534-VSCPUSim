public interface PCOperator extends Operator {
    public int getNumA();
    public int getNumB();

    private void setNumA(int numA) {

    }

    private void setNumB(int numB) {

    }

    public long solve(boolean immediate, long pCounter); //for BZJ ad BZJi
}
