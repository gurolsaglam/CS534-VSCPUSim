public class VSCPUCore {
    private ADD add;
    private NAND nand;
    private SRL srl;
    private LT lt;
    private CP cp;
    private CPI cpi;
    private BZJ bzj;
    private MUL mul;

    public VSCPUCore() {
        add = new ADD();
        nand = new NAND();
        srl = new SRL();
        lt = new LT();
        cp = new CP();
        cpi = new CPI();
        bzj = new BZJ();
        mul = new MUL();
    }


}
