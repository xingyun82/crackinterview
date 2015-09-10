package backtracking;

import common.Utility;
import java.util.*;

/**
 *
 * Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

 * Created by xingyun on 15/8/19.
 */
public class LC_46_Permutations {


    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmpRes = new ArrayList<Integer>();
        boolean[] flags = new boolean[num.length];
        for (int i=0;i<num.length;++i) {
            flags[i] = false;
        }
        this.genFullPermutation(res, num, flags, tmpRes);
        return res;
    }

    public void genFullPermutation(List<List<Integer>> res, int[] nums, boolean[] flags, List<Integer> tmpRes) {
        if (tmpRes.size() == nums.length) {
            List<Integer> instRes = new ArrayList<Integer>(tmpRes);
            res.add(instRes);
            return;
        }
        for (int i=0;i<nums.length;++i) {
            if (!flags[i]) {
                tmpRes.add(nums[i]);
                flags[i] = true;
                genFullPermutation(res, nums, flags, tmpRes);
                flags[i] = false;
                tmpRes.remove(new Integer(nums[i]));
            }
        }
    }


    public List<List<Integer>> permute2(int[] num) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0) return res;
        List<Integer> nextCands = new ArrayList<Integer>();
        for(int i:num) nextCands.add(i);
        List<Integer> path = new ArrayList<Integer>();
        backtrack(res, path, nextCands);
        return res;

    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, List<Integer> nextCands) {
        if(nextCands.size() == 0) {
            List<Integer> tmpRes = new ArrayList<Integer>(path);
            res.add(tmpRes);
            return;
        }
        int n = nextCands.size();
        for(int i=0; i<n; ++i) {
            int cand = nextCands.get(i);
            nextCands.remove(i);
            path.add(cand);
            backtrack(res, path, nextCands);
            nextCands.add(i, cand);
            path.remove(path.size()-1);
        }
    }


    public static void main(String[] args) {
        LC_46_Permutations inst = new LC_46_Permutations();
        int[] num = {1,2,3,4,5,6,7,8};
        long start = System.currentTimeMillis();
        List<List<Integer>> res = inst.permute2(num);
        long end  = System.currentTimeMillis();

        Utility<Integer> u = new Utility<Integer>();
        u.printListCollection(res);
        System.out.println("time:" + (end-start) + "ms");
    }

}
