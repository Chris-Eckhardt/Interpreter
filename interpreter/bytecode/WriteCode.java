package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
The write code is used to print output to the console. It takes prints the value at the top of the
runtime stack without removing it.
*/

public class WriteCode extends ByteCode {

    @Override
    public void execute(VirtualMachine virtualMachine) {
        System.out.println(virtualMachine.peekRunTimeStack());
    }

    @Override
    public void init(ArrayList<String> arguments) {

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
        return "WRITE";
    }

}
