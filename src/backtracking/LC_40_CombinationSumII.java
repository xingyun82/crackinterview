package backtracking;

import java.util.*;
/**
 *
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 * Created by xingyun on 15/8/19.
 */
public class LC_40_CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> canList = new ArrayList<Integer>();
        for(int i:candidates) canList.add(i);
        doCombinationSum(res, canList, new ArrayList<Integer>(), 0, target);
        return res;
    }

    public void doCombinationSum(List<List<Integer>> res, List<Integer> A, List<Integer> path, int last, int target) {
        if (target == 0) {
            if (path.size() > 0) {
                List<Integer> tmpPath = new ArrayList<Integer>();
                tmpPath.addAll(path);
                res.add(tmpPath);
            }
        }
        if (A == null || A.size() == 0) return;
        Set<Integer> sA = new HashSet<Integer>();
        sA.addAll(A);
        for (int i:sA) {
            if (i>=last && target>=i) {
                path.add(i);
                A.remove(A.indexOf(i));
                doCombinationSum(res, A, path, i, target - i);
                A.add(new Integer(i));
                path.remove(path.size() - 1);
            }
        }
    }

}
