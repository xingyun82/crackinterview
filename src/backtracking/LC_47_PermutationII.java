package backtracking;

import java.util.*;
/**
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 * Created by xingyun on 15/8/19.
 */
public class LC_47_PermutationII {

    public List<List<Integer>> permuteUnique(int[] num) {
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
        HashSet<Integer> triedSet = new HashSet<Integer>();
        for (int i=0;i<nums.length;++i) {
            if (!flags[i] && !triedSet.contains(nums[i])) {
                triedSet.add(nums[i]);
                tmpRes.add(nums[i]);
                flags[i] = true;
                genFullPermutation(res, nums, flags, tmpRes);
                flags[i] = false;
                tmpRes.remove(tmpRes.size()-1);
            }
        }
    }
}
