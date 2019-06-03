package interpreter.bytecode.BOP;

import java.util.HashMap;

/*
This abstract BOP class contains a hashmap used by the BopCode bytecode class to identify which operation needs to be
performed. The getBOP() method does this. This class also contains the abstract execute method. All subclasses use this
method to do their assigned tasks.

I will not comment for every BOP subclass because their purposes are obvious.
 */

public abstract class BOP {

    private static HashMap<String, BOP> opTable;

    static {
        opTable =  new HashMap<>();
        opTable.put( "+", new AddOp() );
        opTable.put( "-", new SubOp() );
        opTable.put( "*", new MultOp() );
        opTable.put( "/", new DivOp() );
        opTable.put( "<", new LtOp() );
        opTable.put( ">", new GtOp() );
        opTable.put( ">=", new GteOp() );
        opTable.put( "<=", new LteOp() );
        opTable.put( "==", new EquivalentOp() );
        opTable.put( "!=", new NotEquivalentOp() );
        opTable.put( "|", new OrOp() );
        opTable.put( "&", new AndOp() );
    }

    public static BOP getBOP(String arg) {
        return opTable.get(arg);
    }

    ////////// ABSTRACT METHOD ///////////

    public abstract int execute(int arg1, int arg2);



}
