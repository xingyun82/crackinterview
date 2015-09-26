package backtracking;

import java.util.*;
/**
 * Created by xingyun on 9/20/15.
 */
public class CombinationSumIII {

    private void backtracking(List<List<Integer>> res, List<Integer> path, int i, int k, int n) {
        if(path.size() > k || n < 0) return;
        if(path.size() == k && n == 0) {
            List<Integer> tmp = new ArrayList<Integer>(path);
            res.add(tmp);
            return;
        }
        for(int j=i+1; j<10; ++j) {
            path.add(j);
            backtracking(res, path, j, k, n-j);
            path.remove(path.size()-1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        backtracking(res, path, 0, k, n);
        return res;
    }

    public static void main(String[] args) {
        CombinationSumIII inst = new CombinationSumIII();
        List<List<Integer>> res  = inst.combinationSum3(3, 2);
        for(List<Integer> tmp:res) {
            for(int i:tmp) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
}
