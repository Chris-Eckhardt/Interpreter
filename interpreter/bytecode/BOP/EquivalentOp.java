package interpreter.bytecode.BOP;

public class EquivalentOp extends BOP {
    @Override
    public int execute(int arg1, int arg2) {
        if(arg1 == arg2) {
            return 1;
        } else {
            return 0;
        }
    }
}
