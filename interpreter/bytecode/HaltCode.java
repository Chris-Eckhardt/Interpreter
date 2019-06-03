package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
Halt is responsible for passing the boolean value to a setter in the virtual machine class. This value tells the virtual
machine whether or not to continue processing ByteCodes. Halt is supposed to be called at the completion of a program.
 */

public class HaltCode extends ByteCode {

    @Override
    public void execute(VirtualMachine virtualMachine) {

        /*
        calls public setter method in VM class
         */

        virtualMachine.setRunningState(false);
    }

    @Override
    public void init(ArrayList<String> arguments) {

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
        return "HALT";
    }

}
