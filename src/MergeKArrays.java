
import java.util.*;
/**
 * Created by xingyun on 10/12/15.
 */
public class MergeKArrays {

    // List<int[]> or int[][]

// input = [[1,3,5], [2,5], [8], [1, 10]]

// output = [1, 1, 2, 3, 5, 5, 8, 10]

    class Node {
        int val;
        int index;
        public Node(int val, int index) { this.val = val; this.index = index; }
    }

    public int[] mergeKArrays(List<int[]> lists) {
        int[] res;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        }
        );
        int[] pointers = new int[lists.size()];
        //int counter = 0;
        int size = 0;
        // initialize the queue
        for(int i=0; i<lists.size(); ++i) {
            int[] nums = lists.get(i);
            size += nums.length;
            if(pointers[i] < nums.length) {
                queue.offer(new Node(nums[0], i));
            }
        }
        res = new int[size];
        int k = 0;
        //
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            res[k++] = node.val;
            int i = node.index;
            pointers[i]++;
            if(pointers[i] < lists.get(i).length) {
                int[] nums = lists.get(i);
                queue.offer(new Node(nums[pointers[i]], node.index));
            }
        }
        return res;
    }
}
