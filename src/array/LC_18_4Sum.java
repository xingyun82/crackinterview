package array;

import java.util.*;
/**
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 * Created by xingyun on 15/8/19.
 */
public class LC_18_4Sum {


    class Pair {
        int ai, bi, a, b;
        Pair(int ai, int bi, int a, int b) {
            this.ai = ai;
            this.bi = bi;
            this.a = a;
            this.b = b;
        }

        boolean equals(Pair p) {
            return a == p.a && b == p.b;
        }
    }
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        Map<Integer, List<Pair>> mapping = new TreeMap<Integer, List<Pair>>();
        for (int i=0; i<num.length-1; i++)
            for (int j=i+1; j<num.length; j++) {
                int sum = num[i] + num[j];
                List<Pair> comb = mapping.containsKey(sum) ? mapping.get(sum) : new ArrayList<Pair>();
                Pair pair = new Pair(i, j, num[i], num[j]);
                comb.add(pair);
                if (!mapping.containsKey(sum)) mapping.put(sum, comb);
            }

        List<Integer> sumKeys = new ArrayList<Integer>();
        for (int sum : mapping.keySet()) {
            sumKeys.add(sum);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i=0; i<sumKeys.size(); i++) {
            int sum1 = sumKeys.get(i);
            if (sum1 > target/2) break;
            if (mapping.containsKey(target - sum1)) {
                int sum2 = target - sum1;
                Pair prevA = null;
                for (Pair comb1 : mapping.get(sum1)) {
                    if (prevA!=null && comb1.equals(prevA)) continue;
                    prevA = comb1;
                    Pair prevB = null;
                    for (Pair comb2 : mapping.get(sum2)) {
                        if (prevB != null && comb2.equals(prevB)) continue;
                        if (comb1.bi < comb2.ai) {
                            prevB = comb2;
                            List<Integer> quadraple = new ArrayList<Integer>();
                            quadraple.add(comb1.a); quadraple.add(comb1.b);
                            quadraple.add(comb2.a); quadraple.add(comb2.b);
                            result.add(quadraple);
                        }
                    }
                }
            }
        }
        return result;
    }
}
