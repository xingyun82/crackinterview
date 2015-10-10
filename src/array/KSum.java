package array;

import java.util.*;
/**
 * Created by xingyun on 10/6/15.
 */
public class KSum {

    public List<List<Integer>> ksum(int[] num, int K, int target) {
        Arrays.sort(num);
        return ksum(num, K, target, 0);
    }

    public List<List<Integer>> ksum(int[] num, int K, int target, int p) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(K == 2) {

            int i = p, j = num.length - 1;
            while(i < j) {
                if(i>p && num[i] == num[i-1]) {
                    i++; continue;
                }
                int sum = num[i] + num[j];
                if(sum == target) {
                    List<Integer> tuple = new ArrayList<Integer>();
                    tuple.add(num[i++]);
                    tuple.add(num[j--]);
                    res.add(tuple);
                } else if(sum > target) {
                    j--;
                } else if(sum < target) {
                    i++;
                }
            }

            return res;
        }
        for(int i=p; i<num.length; ++i) {
            if(i>p && num[i] == num[i-1]) continue;
            List<List<Integer>> ksum = ksum(num, K-1, target - num[i], i+1);
            for(List<Integer> tuple:ksum) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(num[i]);
                tmp.addAll(tuple);
                res.add(tmp);
            }
        }

        return res;
    }



    public static void main(String[] args) {
        int[] num = {-1, 0, 1, };
    }
}

