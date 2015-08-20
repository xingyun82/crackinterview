package math; /**
 * Created by xingyun on 15/3/7.
 */
import java.util.List;
import java.util.ArrayList;

public class LC_39_CombinationSum {

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

    public static void main(String[] args) {
        int[] candidates= new int[]{2,3,6,7};
        int target = 7;
        LC_39_CombinationSum inst = new LC_39_CombinationSum();
        List<List<Integer>> res = inst.combinationSum(candidates, target);
        for (List<Integer> l:res) {
            for (int i:l) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }




}
