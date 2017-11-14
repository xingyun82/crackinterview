package stack_queue_heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LC_347_TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else {
                if (queue.peek().getValue() < entry.getValue()) {
                    queue.poll();
                    queue.offer(entry);
                }
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,1,4,1,4,4};
        int k = 2;
        LC_347_TopKFrequentElements inst = new LC_347_TopKFrequentElements();
        System.out.println(inst.topKFrequent(nums, 2));
    }
}
