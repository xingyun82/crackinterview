package string;

import java.util.*;
/**
 * Created by xingyun on 15/8/22.
 */
public class LC_38_CountAndSay {


    public String countAndSay(int n) {
        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        queue1.offer(1);
        Queue<Integer> queue = queue1;
        int i = 0;
        while(i<n) {
            int pre = -1;
            int count = 0;
            while(!queue.isEmpty()) {
                int e = queue.poll();
                if(pre == -1) { count = 1; pre = e; }
                else if(e == pre) count++;
                else {
                    queue2.offer(count);
                    queue2.offer(pre);
                    pre = e;
                    count=1;
                }
            }
            queue2.offer(count);
            queue2.offer(pre);
            // swap queue1 and queue2
            queue = queue2;
            queue2 = queue1;
            queue1 = queue;
            i++;
        }
        // pop number from queue to string
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC_38_CountAndSay inst = new LC_38_CountAndSay();
        System.out.println(inst.countAndSay(3));
    }
}
