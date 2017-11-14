package array;

import java.util.*;

/**
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)

 Hint: Two pointers
 * Created by xingyun on 15/8/19.
 */
public class LC_15_3Sum {

    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) return res;
        List<Integer> numList = new ArrayList<Integer>();
        for(int i:num) {
            numList.add(i);
        }
        Collections.sort(numList);
        int num1 = numList.get(0);
        int i = 0;
        while (i < numList.size()) {
            num1 = numList.get(i);
            int j = i+1;
            int k = numList.size()-1;
            while (j < k) {
                int num2 = numList.get(j);
                int num3 = numList.get(k);
                int sum2 = num2+num3;
                if (sum2>-num1) k--;
                if (sum2<-num1) j++;
                if (sum2 == -num1) {
                    List<Integer> l = Arrays.asList(num1, num2, num3);
                    res.add(l);
                    do {
                        k--;
                    } while (j<k && numList.get(k) == num3);
                    do {
                        j++;
                    } while (j<k && numList.get(j) == num2);
                }
            }
            do {
                i++;
            } while (i<numList.size() && numList.get(i) == num1);
        }

        return res;
    }

}
