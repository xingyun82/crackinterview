package backtracking;

import java.util.*;
/**
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 * Created by xingyun on 15/8/1.
 */
public class LC_77_Combination {

    // backtracking
    private void doBacktracking(List<List<Integer>> res, List<Integer> path, int cur, int n, int k) {
        if(path.size() == k) {
            List<Integer> tmpRes = new ArrayList<Integer>(path);
            res.add(tmpRes);
            return;
        }
        for(int i=cur+1; i<=n; ++i) {
            path.add(i);
            doBacktracking(res, path, i, n, k);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        doBacktracking(res, path, 0, n, k);
        return res;
    }

    public static void main(String[] args) {
        LC_77_Combination inst = new LC_77_Combination();
        List<List<Integer>> res = inst.combine(4,2);
        for(int i=0; i<res.size(); ++i) {
            for(int j:res.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }


    }
}
