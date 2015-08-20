package array;
import java.util.*;
/**
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 * Created by xingyun on 15/8/12.
 */
public class LC_209_MinSubArray {

    public int minSubArrayLen(int s, int[] nums) {
        int minLen = 0;
        if(nums == null) return minLen;

        int len = nums.length;
        int[] sums = new int[len];
        int[] minLens = new int[len];
        int preSum = 0;

        for(int i=0; i<len; ++i) {
            // the first case
            if(nums[i] >= s) return 1;

            sums[i] = preSum + nums[i];
            preSum = sums[i];
            // the last case
            if(sums[i] < s) minLens[i] = 0;
                // the second case
            else if(i>0){
                // if sum(k,i) >= s
                for(int k=i-1; k>=(minLens[i-1]>0?Math.max(0, i-1-minLens[i-1]):0); --k) {
                    if((sums[i-1]-sums[k]+nums[i]) >= s) {
                        minLens[i] = i-1-k+1;
                        break;
                    }
                }
                // else, minLens = i
                if(minLens[i] == 0) minLens[i] = i+1;

                // update minLen
                if(minLen == 0) {
                    minLen = minLens[i];
                } else {
                    minLen = Math.min(minLen, minLens[i]);
                }
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,1,1,1};
        LC_209_MinSubArray inst = new LC_209_MinSubArray();
        System.out.println(inst.minSubArrayLen(5, nums));
        Queue<Integer> q = new LinkedList<Integer>();

    }
}
