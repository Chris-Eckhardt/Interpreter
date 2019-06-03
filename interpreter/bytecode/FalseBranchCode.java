package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
This class just checks what the result of the previous binary operation was. If it was equal to 0, the
operation resulted in a value of false and the program will jump to the assigned address.
 */

public class FalseBranchCode extends ByteCode {

    private int address;
    private String stringAddress;

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if( virtualMachine.popRunTimeStack() == 0) {
            virtualMachine.SetProgramCounter(address);
        }
    }

    public void init(ArrayList<String> rawArguments) {
        stringAddress = rawArguments.get(0);
    }

    public String getArgument(int index){
        return stringAddress;
    }

    public void setArgument( String arg) {
        this.address = Integer.parseInt( arg );
    }

    public String getString() {
        String[] strArr = stringAddress.split("<");
        String func = strArr[0];
        return "FALSEBRANCH " + stringAddress + "   \t" + func + "(" + address + ")";
    }


}
