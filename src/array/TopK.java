package array;

import java.util.*;
/**
 * Created by xingyun on 15/9/9.
 */
public class TopK {

    public List<Integer> findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        // build up k size minimum heap
        for(int i=0; i<k; ++i) pq.offer(nums[i]);
        // replace the heap top if necessary
        for(int i=k; i<nums.length; ++i) {
            if(nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        // return heap top
        List<Integer> res = new ArrayList<Integer>();
        while(!pq.isEmpty()) {
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 6, 1, 2, 4, 5, 7, 10, 9, 8};
        TopK inst = new TopK();
        List<Integer> res = inst.findKthLargest(nums, 3);
        for(int i:res) System.out.print(i+" ");
    }
}
