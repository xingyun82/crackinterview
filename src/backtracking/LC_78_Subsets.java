package backtracking;

import common.Utility;
import java.util.*;
/**
 *
 * Given a set of distinct integers, nums, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 * Created by xingyun on 15/8/19.
 */
public class LC_78_Subsets {

    // backtracking
    private void doBacktracking(List<List<Integer>> res, List<Integer> path, int cur, int[] nums) {
        List<Integer> tmpRes = new ArrayList<Integer>(path);
        res.add(tmpRes);

        for(int i=cur+1; i<nums.length; ++i) {
            path.add(nums[i]);
            doBacktracking(res, path, i, nums);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        // sort nums
        Arrays.sort(nums);
        // get all subset by backtracking
        doBacktracking(res, path, -1, nums);
        return res;
    }

    /*
    // backtracking
    private void doBacktracking(List<List<Integer>> res, List<Integer> path, int cur, int[] nums, int k) {
        List<Integer> tmpRes = new ArrayList<Integer>(path);
        if(path.size() == k) {
            res.add(tmpRes);
        }
        if(path.size() > k) return;

        for(int i=cur+1; i<nums.length; ++i) {
            path.add(nums[i]);
            doBacktracking(res, path, i, nums, k);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        // sort nums
        Arrays.sort(nums);
        // get all subset by backtracking
        doBacktracking(res, path, -1, nums, k);
        return res;
    }
     */


    public static void main(String[] args) {
        LC_78_Subsets inst = new LC_78_Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> res = inst.subsets(nums);
        Utility<Integer> u = new Utility<Integer>();
        u.printListCollection(res);
    }
}
