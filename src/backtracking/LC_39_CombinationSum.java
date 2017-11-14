package backtracking;

import java.util.*;

/**
 *
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:
 [7]
 [2, 2, 3]

 * Created by xingyun on 15/8/19.
 */
public class LC_39_CombinationSum {


    /*
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> canList = new ArrayList<Integer>();
        for(int i:candidates) canList.add(i);
        //Collections.sort(canList);
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
        for (int i:A) {
            if (i>=last && target>=i) {
                path.add(i);
                doCombinationSum(res, A, path, i, target - i);
                path.remove(path.size() - 1);
            }
        }
    }
    */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        doCombinationSum(res, candidates, path, 0, target);
        return res;
    }

    public void doCombinationSum(List<List<Integer>> res, int[] candidates, List<Integer> path, int i, int target) {
        // check if should terminated
        if(target < 0) return;
        // check if we find a path
        if(target == 0) {
            if(path.size() > 0) {
                List<Integer> tmp = new ArrayList<Integer>(path);
                res.add(tmp);
            }
            return;
        }
        // do back tracking
        for(int j=i; j<candidates.length; ++j) {
            path.add(candidates[j]);
            doCombinationSum(res, candidates, path, j, target - candidates[j]);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2};
        int target = 1;
        LC_39_CombinationSum inst = new LC_39_CombinationSum();
        List<List<Integer>> res = inst.combinationSum(candidates, target);

        for(int i=0; i<res.size(); ++i) {
            for(int j:res.get(i)) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

}
