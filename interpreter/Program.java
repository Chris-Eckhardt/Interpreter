package interpreter;

import interpreter.bytecode.*;

import java.util.ArrayList;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) { return this.program.get(pc); }

    public int getSize() {
        return this.program.size();
    }

    public void addCode(ByteCode bc) { program.add(bc); }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param //program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() {

        for(int i = 0; i < program.size(); i++) {

            if( program.get(i) instanceof FalseBranchCode
                    || program.get(i) instanceof CallCode
                    || program.get(i) instanceof GotoCode) {

                for(int j = 0; j < program.size(); j++) {

                    if(program.get(j) instanceof LabelCode) {

                        if( ( program.get(j)).getArgument(0).equals( program.get(i).getArgument(0) ) ) {
                            program.get(i).setArgument(  Integer.toString( program.indexOf( program.get(j) ) ) );
                        }
                    }
                }
            }
        }
    }




}
