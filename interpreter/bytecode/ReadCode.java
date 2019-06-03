package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

/*
The read code asks the user for input in the form of an string. The string is then converted into an int.
If the value can't be converted into an int (because it is a non-numeric character), then it will loop
around and ask again. Once the value passes the test it is pushed to the stack.
 */

public class ReadCode extends ByteCode {

    @Override
    public void execute(VirtualMachine virtualMachine) {
        // 1 - prompt user for input
        // 2 - verify input is integer
        // 3 - push to stack
        String input = "";
        int num = 0;
        boolean pass = false;
        Scanner scanner = new Scanner(System.in);

        while(!pass) { // will need loop here
            System.out.print("Please enter an Integer value: ");
            input = scanner.next();

                try {
                    num = Integer.parseInt(input);
                    pass = true;
                } catch (NumberFormatException ex) {
                    pass = false;
                }


            //System.out.println(input + " is being pushed to the stack"); // THIS IS A TEST
        }
        virtualMachine.pushRunTimeStack(num);

    }

    @Override
    public void init(ArrayList<String> arguments) {

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
        return "READ";
    }


}
