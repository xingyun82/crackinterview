package backtracking;

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


}
