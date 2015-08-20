package backtracking;

import java.util.*;
/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 *
 * Created by xingyun on 15/8/19.
 */
public class LC_90_SubsetII {

    private void doBacktracking(List<List<Integer>> res, List<Integer> path, int cur, int[] nums) {
        res.add(new ArrayList<Integer>(path));

        int pre = Integer.MAX_VALUE;
        for(int i=cur; i<nums.length; ++i) {
            if(nums[i] == pre) continue;
            path.add(nums[i]);
            doBacktracking(res, path, i+1, nums);
            path.remove(path.size()-1);
            pre = nums[i];
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(nums);
        doBacktracking(res, path, 0, nums);
        return res;
    }
}
