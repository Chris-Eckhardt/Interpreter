package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {


        // clone framepointer to arraylist
        ArrayList<Integer> framePointerClone = new ArrayList<>();
        framePointerClone.addAll(framePointer);


        String str = "";

        // frame init is not required
        for (Iterator<Integer> it = framePointerClone.iterator(); it.hasNext(); ) {
            int aValue = it.next();
            if(aValue == 0) {
                it.remove();
            }
        }

        str = str + "[";

        for(int i = 0; i < runTimeStack.size(); i++) {

            if (framePointerClone.isEmpty()) {
                str = str + runTimeStack.get(i);

                if (i + 1 < runTimeStack.size()) {
                    str = str + ",";
                }

            } else {

                str = str + runTimeStack.get(i);

                if(i + 1 == framePointerClone.get(0)){
                    str = str + "] [";
                    framePointerClone.remove(0);
                } else {
                    str = str + ",";
                }

            }
        }

        str = str + "]";

        System.out.println(str);

    }

    public int peek() {
        if(runTimeStack.size() > 0) {
            return runTimeStack.get(runTimeStack.size() - 1);
        } else {
            return 0;
        }
    }

    public int pop() {
        if(runTimeStack.size() > 0) {
            return runTimeStack.remove(runTimeStack.size() - 1);
        } else {
            return 0;
        }
    }

    public void newFrameAt(int offset) {

        framePointer.push(runTimeStack.size() - offset);

    }

    public void popFrame() {
        int savedReturnValue = this.pop();
        int targetIndex = framePointer.pop();
        int i;

        while(targetIndex <= runTimeStack.size() - 1) {
            i = runTimeStack.size() - 1;
            runTimeStack.remove(i);
        }

        runTimeStack.add(savedReturnValue);

    }
    
    public int store(int offset) {
        int lastElement = runTimeStack.size() - 1;
        int value = runTimeStack.remove(lastElement);
        int offsetIndex = framePointer.peek() + offset;
        runTimeStack.set(offsetIndex, value);

        return value;
    }

    public int load(int offset) {
        int offsetIndex = framePointer.peek() + offset;
        int offsetValue = runTimeStack.get( offsetIndex );

        return offsetValue;
    }


    public Integer push(Integer val) { // return type in push was originally "Integer"
        runTimeStack.add(val);
        return val;
    }
    
}
