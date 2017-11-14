package dp;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?

 */
public class LC_300_LIS {


    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        for (int i=0; i<nums.length; ++i) {
            dp[i] = 1;
            for (int j=0; j<i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 3};
        LC_300_LIS inst = new LC_300_LIS();
        System.out.println(inst.lengthOfLIS(nums));
    }
}
