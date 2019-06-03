package interpreter.bytecode;

import interpreter.bytecode.BOP.*;
import interpreter.VirtualMachine;

import java.util.ArrayList;

/*
This class uses the BOP package, BOP parent class, and associated sub-classes to perform binary operations.
BopCode functions almost identically to how our calculator did in the first assignment with only minor differences.
 */

public class BopCode extends ByteCode {

    private String operator;


    @Override
    public void execute(VirtualMachine virtualMachine) {

        BOP bop = BOP.getBOP(operator);
        int operand2 = virtualMachine.popRunTimeStack();
        int operand1 = virtualMachine.popRunTimeStack();
        virtualMachine.pushRunTimeStack( bop.execute(operand1, operand2) );

    }

    @Override
    public void init(ArrayList<String> arguments) {
        this.operator = arguments.get(0);
    }

    @Override
    public Object getArgument(int index) {
        return null;
    }

    @Override
    public void setArgument( String arg) {

    }

    @Override
    public String getString() {
        return "BOP " + operator;
    }

}
