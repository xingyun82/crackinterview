package stack_queue;

import java.util.*;
/**
 *
 * Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 Notes:
 You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 Update (2015-06-11):
 The class name of the Java function had been updated to MyStack instead of Stack.

 * Created by xingyun on 15/8/20.
 */
public class LC_225_ImplementStackUsingQueue {

    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    boolean flag = true;

    // Push element x onto stack.
    public void push(int x) {
        if(flag) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(flag) {
            while(!queue1.isEmpty()) {
                int i = queue1.poll();
                if(!queue1.isEmpty()) {
                    queue2.offer(i);
                }
            }
        } else {
            while(!queue2.isEmpty()) {
                int i = queue2.poll();
                if(!queue2.isEmpty()) {
                    queue1.offer(i);
                }
            }
        }
        flag = !flag;

    }

    // Get the top element.
    public int top() {
        int top = -1;
        if(flag) {
            while(!queue1.isEmpty()) {
                int i = queue1.poll();
                if(queue1.isEmpty()) {
                    top = i;
                }
                queue2.offer(i);
            }
        } else {
            while(!queue2.isEmpty()) {
                int i = queue2.poll();
                if(queue2.isEmpty()) {
                    top = i;
                }
                queue1.offer(i);
            }
        }
        flag = !flag;
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
