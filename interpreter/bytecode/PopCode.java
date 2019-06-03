package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
POP removed an item at the top of the stack. The number of items it removes is passed in as an argument.
 */

public class PopCode extends ByteCode {

    private int n;

    @Override
    public void execute(VirtualMachine virtualMachine) {
        for(int i = 0; i < n ; i++) {
            virtualMachine.popRunTimeStack();
        }
    }

    @Override
    public void init(ArrayList<String> arguments) {
        n = Integer.parseInt( arguments.get(0) );
    }

    @Override
    public Object getArgument(int index) {
        return n;
    }

    @Override
    public void setArgument( String arg) {
        //not needed
    }

    @Override
    public String getString() {
        return "POP " + n;
    }

}
