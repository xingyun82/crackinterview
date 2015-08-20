package array;

import java.util.*;
/**
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 * Created by xingyun on 15/8/19.
 */
public class LC_16_3SumClosest {

    public int threeSumClosest(int[] num, int target) {
        int closestDelta = Integer.MAX_VALUE;
        int closestSum = 0;
        if (num == null || num.length == 0) return 0;
        List<Integer> numList = new ArrayList<Integer>();
        for(int i:num) {
            numList.add(i);
        }
        Collections.sort(numList);
        int i = 0;
        int size = numList.size();
        while (i < size) {
            int num1 = numList.get(i);
            int j = i+1;
            int k = size-1;
            while (j < k) {
                int num2 = numList.get(j);
                int num3 = numList.get(k);
                int sum2 = num2+num3;
                int d = target-num1;
                if (sum2 == d) {
                    return target;
                }
                int delta = Math.abs(sum2+num1-target);
                if(delta < closestDelta) {
                    closestDelta = delta;
                    closestSum = sum2+num1;
                }
                if (sum2>d) {
                    do {k--;} while(j<k && numList.get(k) == num3);
                }
                if (sum2<d) {
                    do {j++;} while(j<k && numList.get(j) == num2);
                }
            }
            do {i++;} while (i<numList.size() && numList.get(i) == num1);
        }
        return closestSum;
    }
}
