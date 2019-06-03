package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
CallCode is responsible for storing the appropriate return address to its stack and
reassigning the program counter to that of the new function being called.

Call is used just before a function call to facilitate this.
 */

public class CallCode extends ByteCode {

    private int address;
    private String stringAddress;

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.pushReturnAddress( virtualMachine.getProgramCounter() );
        virtualMachine.SetProgramCounter(address);
    }

    public void init(ArrayList<String> rawArguments) {
        stringAddress = rawArguments.get(0);
    }

    public String getArgument(int index){
        return stringAddress;
    }

    @Override
    public void setArgument( String arg) {
        this.address = Integer.parseInt( arg );
    }

    @Override
    public String getString() {
        String[] strArr = stringAddress.split("<");
        String func = strArr[0];
        return "Call " + stringAddress + "      \t" + func + "(" + address + ")";
    }

}
