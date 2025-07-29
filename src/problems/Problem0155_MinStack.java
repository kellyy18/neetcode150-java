package problems;

import java.util.Stack;
/*
 * Honestly, this problem is pretty straightforward. Just keep straight in your head how you need to 
 * update the min stack on each of the different operations.
 */
public class Problem0155_MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Problem0155_MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        // update minstack if there's no min value or if current value is less than the current minimum
        // note, we don't REPLACE the old minimum, we just push our current min on top
        // (in case )
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    

    public void pop() {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
