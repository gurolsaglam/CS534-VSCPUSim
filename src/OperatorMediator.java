//MEDIATOR PATTERN
public class OperatorMediator {
    //SINGLETON PATTERN
    private static OperatorMediator operatorMediator = new OperatorMediator();

    private ADD add;
    private NAND nand;
    private SRL srl;
    private LT lt;
    private CP cp;
    private CPI cpi;
    private BZJ bzj;
    private MUL mul;

    private String opCode;
    private long addressA;
    private long addressB;
    private int num1;
    private int num2;

    private OperatorMediator () {

    }

    public static OperatorMediator getInstance() {
        return operatorMediator;
    }

    public boolean isCPI(String opCode) {
        return opCode.equals("CPI");
    }

    public long[] resolveInstruction(long pCounter, String opCode, long addressA, long addressB, int num1, int num2) {
        this.opCode = opCode;
        this.addressA = addressA;
        this.addressB = addressB;
        this.num1 = num1;
        this.num2 = num2;

        long[] result = new long[3];
        if (this.isJump(this.opCode)) {
            result[0] = 0;
            result[1] = 0;
            result[2] = 0;
            if (this.opCode.equals("BZJi")) {
                this.bzj = BZJ.getInstance(this.num1, (int) this.addressB);
                result[2] = this.bzj.solve(true, pCounter);
            } else {
                this.bzj = BZJ.getInstance(this.num1, this.num2);
                result[2] = this.bzj.solve(false, pCounter);
            }
        } else {
            result[0] = 1;
            if (this.opCode.equals("CPIi")) {
                result[1] = this.num1;
            } else {
                result[1] = this.addressA;
            }


            if (this.opCode.equals("ADD")) {
                this.add = ADD.getInstance(this.num1, this.num2);
                result[2] = this.add.solve();
            } else if (this.opCode.equals("ADDi")) {
                this.add = ADD.getInstance(this.num1, (int) this.addressB);
                result[2] = this.add.solve();
            } else if (this.opCode.equals("NAND")) {
                this.nand = NAND.getInstance(this.num1, this.num2);
                result[2] = this.nand.solve();
            } else if (this.opCode.equals("NANDi")) {
                this.nand = NAND.getInstance(this.num1, (int) this.addressB);
                result[2] = this.nand.solve();
            } else if (this.opCode.equals("SRL")) {
                this.srl = SRL.getInstance(this.num1, this.num2);
                result[2] = this.srl.solve();
            } else if (this.opCode.equals("SRLi")) {
                this.srl = SRL.getInstance(this.num1, (int) this.addressB);
                result[2] = this.srl.solve();
            } else if (this.opCode.equals("LT")) {
                this.lt = LT.getInstance(this.num1, this.num2);
                result[2] = this.lt.solve();
            } else if (this.opCode.equals("LTi")) {
                this.lt = LT.getInstance(this.num1, (int) this.addressB);
                result[2] = this.lt.solve();
            } else if (this.opCode.equals("CP")) {
                this.cp = CP.getInstance(this.num1, this.num2);
                result[2] = this.cp.solve();
            } else if (this.opCode.equals("CPi")) {
                this.cp = CP.getInstance(this.num1, (int) this.addressB);
                result[2] = this.cp.solve();
            } else if (this.opCode.equals("CPI")) {
                this.cpi = CPI.getInstance(this.num1, this.num2);
                result[2] = this.cpi.solve();
            } else if (this.opCode.equals("CPIi")) {
                this.cpi = CPI.getInstance(this.num1, this.num2);
                result[2] = this.cpi.solve();
            } else if (this.opCode.equals("MUL")) {
                this.mul = MUL.getInstance(this.num1, this.num2);
                result[2] = this.mul.solve();
            } else if (this.opCode.equals("MULi")) {
                this.mul = MUL.getInstance(this.num1, (int) this.addressB);
                result[2] = this.mul.solve();
            } else {
                System.out.println("Unrecognized operation.");
                System.out.println(new Instruction(this.opCode, this.addressA, this.addressB).toString());
                result[0] = 0;
                result[1] = 0;
                result[2] = 0;
            }

        }
        return result;
    }

    private boolean isJump(String opCode) {
        if (opCode.equals("BZJ") || opCode.equals("BZJi")) {
            return true;
        }
        return false;
    }
}
