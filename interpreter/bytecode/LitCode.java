package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
Lit code takes an immediate value and pushes it onto the top of the runtime stack.
 */

public class LitCode extends ByteCode {

    private int num;
    private String var = "";

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.pushRunTimeStack(num);
    }

    @Override
    public void init(ArrayList<String> arguments) {
        num = Integer.parseInt(arguments.get(0));
        if(arguments.size() > 1) {
            var = arguments.get(1);
        }
    }

    @Override
    public Object getArgument(int index) {
        return null;
    }

    @Override
    public void setArgument( String arg) {

    }

    @Override
    public String getString() {
        if(var == "") {
            return "LIT " + num;
        } else {
            return "LIT " + num + " " + var + "     \tint " + var + " = " + num;
        }
    }


}
