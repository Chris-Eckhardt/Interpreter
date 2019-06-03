package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
Store just asks the VM to pop the top of the stack and stores it at a given offset.
 */

public class StoreCode extends ByteCode{

    int val;
    String stringArg = "";
    int offset;

    @Override
    public void execute(VirtualMachine virtualMachine) {
        val = virtualMachine.storeRunTimeStack(offset);
    }

    @Override
    public void init(ArrayList<String> arguments) {
        offset = Integer.parseInt(arguments.get(0));
        if(arguments.size() > 1) {
            stringArg = arguments.get(1);
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
        if (stringArg == "") {
            return "STORE " + offset;
        } else {
            return "LOAD " + offset + " " + stringArg + "   \t int " + stringArg + " = " + offset;
        }
    }

}
