package interpreter.bytecode.BOP;

public class OrOp extends BOP {

    @Override
    public int execute(int arg1, int arg2) {
        if(arg1 == 1 || arg2 == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}
