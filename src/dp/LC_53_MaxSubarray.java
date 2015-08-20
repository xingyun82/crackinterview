package dp;

import java.util.*;
/**
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.

 * Created by xingyun on 15/8/19.
 */
public class LC_53_MaxSubarray {

    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) return 0;
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> subArray = new ArrayList<Integer>();
        int subSum = Integer.MIN_VALUE;
        int resSum = Integer.MIN_VALUE;
        for (int i=0;i<A.length;++i) {
            if(i==0) {
                //subArray.add(i);
                //res.add(i);
                resSum = A[i];
                subSum = A[i];
            } else {
                if (subSum>0) {
                    //subArray.add(i);
                    subSum += A[i];
                } else {
                    //subArray.clear();
                    //subArray.add(i);
                    subSum = A[i];
                }
                if (subSum>resSum) {
                    resSum = subSum;
                    //res.clear();
                    //res.addAll(subArray);
                }
            }
        }
        return resSum;
    }

}
