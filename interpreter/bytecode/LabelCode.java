package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
Label code is pretty self-explanatory. It marks the destination for a jump instruction.
The next code after a label is the start of a function.
 */

public class LabelCode extends ByteCode {

    private String address;

    @Override
    public void execute(VirtualMachine virtualMachine) {
        // Labels do label things
    }

    @Override
    public void init(ArrayList<String> rawArguments) {
        address = rawArguments.get(0);
    }

    @Override
    public Object getArgument(int index) {
        return address;
    }

    @Override
    public void setArgument(String arg) {
        this.address = arg;
    }

    @Override
    public String getString() {
        return "LABEL " + address;
    }


}
