package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
load code takes a value already in the runtime stack and pushes the value to the top of the stack.
The value is identified as being at the offset passed in as an argument. the value is copied and not removed.
 */

public class LoadCode extends ByteCode {

    private int arg1;
    private String arg2 = "";

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int value = virtualMachine.loadRunTimeStack(arg1);
        virtualMachine.pushRunTimeStack(value);

    }

    @Override
    public void init(ArrayList<String> arguments) {
        arg1 = Integer.parseInt( arguments.get(0) );

        if(arguments.size() > 1) {
            arg2 = arguments.get(1);
        }

    }

    @Override
    public Object getArgument(int index) {
        return null;
    }

    @Override
    public void setArgument(String arg) {

    }

    @Override
    public String getString() {
        if (arg2 == "") {
            return "LOAD " + arg1;
        } else {
            return "LOAD " + arg1 + " " + arg2 + "       \t int " + arg2 + " = " + arg1;
        }
    }

}
