package greedy;

import java.util.HashMap;
import java.util.Map;

public class LC_659_SplitArrayIntoConsecutiveSubSequences {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
        for (int i : nums) freq.put(i, freq.getOrDefault(i,0) + 1);
        for (int i : nums) {
            if (freq.get(i) == 0) continue;
            // if current element can be appended to a previous consecutive sequence.
            else if (appendfreq.getOrDefault(i,0) > 0) {
                appendfreq.put(i, appendfreq.get(i) - 1);
                appendfreq.put(i+1, appendfreq.getOrDefault(i+1,0) + 1);
            }
            // or if current element can start a new consecutive sequence.
            else if (freq.getOrDefault(i+1,0) > 0 && freq.getOrDefault(i+2,0) > 0) {
                freq.put(i+1, freq.get(i+1) - 1);
                freq.put(i+2, freq.get(i+2) - 1);
                appendfreq.put(i+3, appendfreq.getOrDefault(i+3,0) + 1);
            }
            else return false;
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,5,5};
        LC_659_SplitArrayIntoConsecutiveSubSequences inst = new LC_659_SplitArrayIntoConsecutiveSubSequences();
        System.out.println(inst.isPossible(nums));
    }
}
