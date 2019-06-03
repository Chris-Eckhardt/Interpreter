package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
The RETURN class is responsible for setting the program counter after a function has completed.
It also pops the frame used by that function.
 */
public class ReturnCode extends ByteCode {

    private String arg = "";
    private int val;

    @Override
    public void execute(VirtualMachine virtualMachine) {
        // for dump
        val = virtualMachine.peekRunTimeStack();

        // main resp.
        virtualMachine.SetProgramCounter( virtualMachine.popReturnAddress() );
        virtualMachine.popFrame();

    }

    @Override
    public void init(ArrayList<String> arguments) {
        if(!arguments.isEmpty()) {
            arg = arguments.get(0);
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
        //exit <base-id>:<value>
        return "RETURN " + arg + "      \t EXIT arg: " + val;
    }


}
