package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dumping = false;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    protected void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;



        while(isRunning){
            ByteCode code = program.getCode(pc);
            code.execute(this );

            if(dumping == true && !(code instanceof DumpCode)) {
                printCodes(code);
                runStack.dump(); // Used to dump runstack state.
            }
            pc++;
        }

    }

    public void SetProgramCounter(int target) {
        pc = target;
    }

    public int getProgramCounter() {
        return pc;
    }

    public void setRunningState(boolean isRunning) {        // Set isRunning(True/False)
        this.isRunning = isRunning;
    }

    public int popRunTimeStack() { return runStack.pop(); }

    public void pushRunTimeStack(int val) { runStack.push(val); }

    public int peekRunTimeStack() {
        return runStack.peek();
    }

    public int loadRunTimeStack(int offset){
        return runStack.load(offset);
    }

    public int storeRunTimeStack(int offset) {
        return runStack.store(offset);
    }

    public void newFrameAt(int index) {
        runStack.newFrameAt(index);
    }

    public void pushReturnAddress(int n) {
        returnAddrs.push(n);
    }

    public int popReturnAddress() {
        return (int) returnAddrs.pop();
    }

    public void popFrame() {
        runStack.popFrame();
    }

    public void dump(boolean dumpStatus) {
        dumping = dumpStatus;
    }

    public void printCodes(ByteCode code) {
        System.out.println(code.getString());
    }
}
