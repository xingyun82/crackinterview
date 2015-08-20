package math; /**
 * Created by xingyun on 15/3/7.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class LC_40_CombinationSum2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                //A.remove(A.indexOf(i));
                A.remove(new Integer(i));
                doCombinationSum(res, A, path, i, target - i);
                A.add(new Integer(i));
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates= new int[]{10,1,2,7,6,1,5};
        /*
        List<Integer> l = new ArrayList<Integer>();
        for(int i:candidates)l.add(i);
        l.remove(1);
        for(int i:l) System.out.println(i);
        */

        int target = 8;
        LC_40_CombinationSum2 inst = new LC_40_CombinationSum2();
        List<List<Integer>> res = inst.combinationSum(candidates, target);
        for (List<Integer> l:res) {
            for (int i:l) {
                System.out.print(i + ",");
            }
            System.out.println();
        }


    }




}
