
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        String line;
        ByteCode bc;
        Class c;
        Program p = new Program();


        try{
            while((line = byteSource.readLine()) != null) {
                bc = null;
                c = null;
                String className = "";
                ArrayList<String> arguments = new ArrayList<>();

                String[] tokens = line.split("\\s");

                //System.out.println(tokens[i]); // THIS IS A TEST

                //use first token to create bytecode instance
                className = CodeTable.getClassName(tokens[0]);


                // GET CLASS
                try {
                    c = Class.forName("interpreter.bytecode." + className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                // CREATE INSTANCE
                try {
                    bc = (ByteCode) c.getDeclaredConstructor().newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                // load all other tokens to arguments ArrayList
                if (tokens.length > 1) {
                    for (int j = 1; j < tokens.length; j++) {

                        arguments.add(tokens[j]);

                    }
                    // send args to init() if any
                    if (bc != null) {
                        bc.init(arguments);
                    }
                }


                //add to program's ByteCode ArrayList
                p.addCode(bc);
            }
        } catch(IOException e){
            System.out.println("ERROR : @loadCodes()");
        }

        //////////////// RETURN NEW PROGRAM ///////////////
        p.resolveAddrs();

        return p;
    }
}
