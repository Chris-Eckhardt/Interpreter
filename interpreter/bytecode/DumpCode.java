package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
All that DumpCode does is provide the dumping variable within the virtual machine with is dump state
( either true or false ). All other dumping operations are handled within their respective classes.
 */

public class DumpCode extends ByteCode{

    String dumpStatus;

    @Override
    public void execute(VirtualMachine virtualMachine) {
        switch(dumpStatus) {
            case "ON" :
                virtualMachine.dump(true);
                break;
            case "OFF" :
                virtualMachine.dump(false);
                break;
            default :
                //invalid argument dumping will remain false (just in case?)
                virtualMachine.dump(false);
                break;
        }
    }

    @Override
    public void init(ArrayList<String> arguments) {
        dumpStatus = arguments.get(0);

    }

    @Override
    public Object getArgument(int index) {
        return 0;
    }

    @Override
    public void setArgument(String arg) {

    }

    @Override
    public String getString() {
        return null;
    }

}
