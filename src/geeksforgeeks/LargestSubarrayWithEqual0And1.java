package geeksforgeeks;

import java.util.*;
/**
 *
 * Given an array containing only 0s and 1s, find the largest subarray which contain
 * equal no of 0s and 1s. Expected time complexity is O(n).

 Examples:

 Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
 Output: 1 to 6 (Starting and Ending indexes of output subarray)

 Input: arr[] = {1, 1, 1, 1}
 Output: No such subarray

 Input: arr[] = {0, 0, 1, 1, 0}
 Output: 0 to 3 Or 1 to 4

 * Created by xingyun on 15/9/11.
 */
public class LargestSubarrayWithEqual0And1 {


    /**
     * O(n) algorithm:
     * 1. consider all the 0 as -1, and get the sumleft[i] (sum from 0 to i)
     * 2. suppose [i, j] is a subarray, which contains the same 0 and 1, then there are two cases:
     *   a. the subarray start from 0(i.g. i=0), then sumleft[j] should be = 0;
     *      in this case, we just find the right most sumleft[i] which equals to 0, then i+1 is what we want
     *   b. the subarray not start from 0 (i.g. i!=0), then sumleft[i] should be equals to sumleft[j]
     *      int his case, we can construct a hashmap, which map each sumleft to the first occurence
     *      that is sumleft -> i,  then for each sumleft, we compare the current j with i, and get the
     *      lareget i-j+1
     */

    public int largestLenWithEqual0And1(int[] sumleft) {
        for(int i:sumleft) {
            System.out.print(i+",");
        }

        int n = sumleft.length;
        int maxLen = -1;
        int s = -1;

        // for case a
        for(int i=0; i<n; ++i) {
            if(sumleft[i] == 0) {
                maxLen = i+1;
                s = 0;
            }
        }
        // for case b
        HashMap<Integer, Integer> firstPosMap = new HashMap<Integer, Integer>();
        for(int i=0; i<n; ++i) {
            if(!firstPosMap.containsKey(sumleft[i])) {
                firstPosMap.put(sumleft[i], i);
            } else {
                int j = firstPosMap.get(sumleft[i]);
                if(i-j > maxLen) {
                    maxLen = i-j;
                    s = j+1;
                }
            }
        }
        System.out.println("maxLen:" + maxLen + ", startIdx:" + s);
        return maxLen;
    }


    public int largestSubarray(int[] A) {
        int n = A.length;
        int[] sumleft = new int[n];

        sumleft[0] = (A[0] == 0?-1:1);
        for(int i=1; i<n; ++i) {
            sumleft[i] = sumleft[i-1] + (A[i] == 0?-1:1);
        }
        return largestLenWithEqual0And1(sumleft);

    }

    /*
    扩展到二维矩阵
     */
    public int largestSubMatrixWithEqual0And1(int[][] M) {
        int m = M.length;
        int n = M[0].length;

        int maxArea = 0;
        for(int i=0; i<m; ++i) {
            int[] sum = new int[n];
            for(int j=i; j<m; ++j) {
                for(int k=0; k<n; ++k) {
                    sum[k] += (M[j][k] == 0?-1:1);
                }
                int[] sumleft = new int[n];
                sumleft[0] = sum[0];
                for(int k=1; k<n; ++k) {
                    sumleft[k] += sumleft[k-1] + sum[k];
                }
                int len = largestLenWithEqual0And1(sumleft);
                maxArea = Math.max(maxArea, len*(j-i+1));
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        /*
        LargestSubarrayWithEqual0And1 inst = new LargestSubarrayWithEqual0And1();
        int[] A = {1, 0, 1, 1, 0};
        System.out.println(inst.largestSubarray(A));
        */
        LargestSubarrayWithEqual0And1 inst = new LargestSubarrayWithEqual0And1();
        int[][] M = new int[3][];
        M[0] = new int[]{1,0,1,1,0};
        M[1] = new int[]{0,1,0,1,1};
        M[2] = new int[]{1,0,0,0,1};
        System.out.println(inst.largestSubMatrixWithEqual0And1(M));
    }
}
