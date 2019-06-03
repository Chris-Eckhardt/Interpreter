package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
This is the parent class to all byteCodes. It contains all the methods required for the ByteCodes
to do their assigned tasks.
 */

public abstract class ByteCode {

    public abstract void execute(VirtualMachine virtualMachine);

    public abstract void init(ArrayList<String> arguments);

    public abstract Object getArgument(int index);

    public abstract void setArgument(String arg);

    public abstract String getString();

}
