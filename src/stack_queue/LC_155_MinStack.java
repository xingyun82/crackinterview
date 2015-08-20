package stack_queue;

/**
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.

 * Created by xingyun on 15/6/10.
 */
import java.util.Stack;

public class LC_155_MinStack {

    private Stack<Integer> intStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        intStack.push(x);
        if(minStack.empty() || x < minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if(intStack.empty()) return;
        int x = intStack.pop();
        if(x == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return intStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        LC_155_MinStack inst = new LC_155_MinStack();
        inst.push(0);
        System.out.println(inst.getMin());
        inst.push(1);
        System.out.println(inst.getMin());
        inst.push(0);
        System.out.println(inst.getMin());
        inst.pop();
        System.out.println(inst.getMin());
        //inst.pop();
        //System.out.println(inst.getMin());
        //inst.pop();
        //System.out.println(inst.getMin());
    }
}
