package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
Goto is a jump instruction. It passes an int value to the virtual machine, this int value is the
address that it will jump to.
 */

public class GotoCode extends ByteCode {

    private int address;
    private String stringAddress;

    @Override
    public void execute(VirtualMachine virtualMachine) {
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

    public String getString() {
        String[] strArr = stringAddress.split("<");
        String func = strArr[0];
        return "GOTO " + stringAddress + "  \t" + func + "(" + address + ")";
    }
}
