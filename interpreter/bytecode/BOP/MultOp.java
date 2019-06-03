package interpreter.bytecode.BOP;

public class MultOp extends BOP {
    @Override
    public int execute(int arg1, int arg2) {
        return arg1 * arg2;
    }
}
