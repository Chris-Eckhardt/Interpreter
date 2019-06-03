package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
ArgsCode creates a new frame (usually after a function call) this frame is the space within
the stack where this function can store its values.
 */

public class ArgsCode extends ByteCode {

    private int arg;

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.newFrameAt(arg);
    }

    @Override
    public void init(ArrayList<String> arguments) {
        arg = Integer.parseInt( arguments.get(0) );
    }

    @Override
    public Object getArgument(int index) {
        return arg;
    }

    @Override
    public void setArgument( String arg) {

    }

    @Override
    public String getString() {
        return "ARGS " + arg;
    }

}
