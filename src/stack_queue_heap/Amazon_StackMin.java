package stack_queue_heap;

import java.util.*;
/**
 * Created by xingyun on 10/8/15.
 */
public class Amazon_StackMin {

    List<Integer> data = new ArrayList<Integer>();
    List<Integer> mins = new ArrayList<Integer>(); // mins[i] means the mininum value from 0 to i

    public void push(int num) {
        data.add(num);
        if(mins.size() == 0) mins.add(num);
        else {
            mins.add(Math.min(mins.get(mins.size()-1), num));
        }
    }

    public int pop() {
        mins.remove(mins.size()-1);
        return data.remove(data.size() - 1);
    }

    public int min() {
        return mins.get(mins.size()-1);
    }

    public static void main(String[] args) {
        Amazon_StackMin inst = new Amazon_StackMin();
        inst.push(4);
        System.out.println(inst.min());
        inst.push(3);
        System.out.println(inst.min());
        inst.push(2);
        System.out.println(inst.min());
        inst.push(5);
        System.out.println(inst.min());
        System.out.println(inst.pop());
        System.out.println(inst.pop());
        System.out.println(inst.pop());
        System.out.println(inst.pop());
    }
}
