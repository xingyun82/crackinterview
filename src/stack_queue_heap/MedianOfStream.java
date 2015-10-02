package stack_queue_heap;

import java.util.*;

/**
 * Created by xingyun on 9/27/15.
 */

class IntegerStream {

    int[] nums;

    int cur = 0;

    public IntegerStream(int[] nums) {
        this.nums = nums;
    }

    public boolean hasNext() {
        return cur < nums.length;
    }

    public int next() {
        return nums[cur++];
    }

}

public class MedianOfStream {

    public int median(IntegerStream stream) {
        int median = 0;
        long count = 0;
        // max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        // min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        while(stream.hasNext()) {
            int num = stream.next();
            if(count == 0) median = num;
            else if(count == 1) {
                maxHeap.offer(Math.min(median, num));
                minHeap.offer(Math.max(median, num));
                median = (median + num)/2;
            } else {
                if(count%2 == 0) {
                    if(num > minHeap.peek()) {
                        median = minHeap.poll();
                        minHeap.offer(num);
                    } else if(num < maxHeap.peek()) {
                        median = maxHeap.poll();
                        maxHeap.offer(num);
                    } else {
                        median = num;
                    }
                } else {
                    if(num >= median) {
                        maxHeap.offer(median);
                        minHeap.offer(num);
                    } else {
                        minHeap.offer(median);
                        maxHeap.offer(num);
                    }
                    median = (maxHeap.peek()+minHeap.peek())/2;
                }
            }
            count++;
        }
        return median;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,1,3,8,9,7,5,2, 10};
        IntegerStream stream = new IntegerStream(nums);
        MedianOfStream inst = new MedianOfStream();
        System.out.println(inst.median(stream));
        Random r  = new Random();

    }
}
