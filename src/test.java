import java.util.*;
/**
 * Created by xingyun on 15/8/18.
 */
public class test {

    public static void main(String[] args) {

        String str = new String();
        str.isEmpty();

        List<Integer> l = new ArrayList<Integer>();
        l.isEmpty();
        l.add(1);

        Stack<Integer> s = new Stack<Integer>();
        s.isEmpty();
        s.push(1);
        s.pop();
        s.peek();

        Queue<Integer> q = new LinkedList<Integer>();
        q.isEmpty();
        q.offer(1);
        q.poll();
        q.peek();

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        pq.isEmpty();
        pq.poll();
        pq.offer(1);
        pq.peek();


    }
}
