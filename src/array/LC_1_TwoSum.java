package array;

import java.util.*;

/**
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2

 * Created by xingyun on 15/8/19.
 */
public class LC_1_TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return null;
        HashMap<Integer, List<Integer>> numberMap = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<numbers.length; ++i) {
            if (numberMap.containsKey(numbers[i])) {
                numberMap.get(numbers[i]).add(i);
            } else {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(i);
                numberMap.put(numbers[i], l);
            }

            if (numberMap.containsKey(target - numbers[i])) {
                int index1 = numberMap.get(target - numbers[i]).get(0);
                if (index1 != i) {
                    int[] res = new int[]{index1+1, i+1};
                    return res;
                }
            }
        }
        return null;
    }
}
