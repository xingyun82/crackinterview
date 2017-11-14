package dp;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

 Find the maximum coins you can collect by bursting the balloons wisely.

 Note:
 (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

 Example:

 Given [3, 1, 5, 8]

 Return 167

 nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

 */
public class LC_312_BurstBalloons {

    // for dp[i][j], suppose x is the last balloon to burst, then we have dp[i][j] = max{dp[i][x-1] + nums[i-1]*nums[x]*nums[j+1] + dp[x+1][j]}
    public int maxCoins(int[] iNums) {
        int n = iNums.length;
        int[] nums = new int[n + 2];
        for (int i = 0; i < n; i++) nums[i + 1] = iNums[i];
        nums[0] = nums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n - k + 1; i++) {
                int j = i + k - 1;
                for (int x = i; x <= j; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][x - 1] + nums[i - 1] * nums[x] * nums[j + 1] + dp[x + 1][j]);
                }
            }
        }
        return dp[1][n];
    }


    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        LC_312_BurstBalloons inst = new LC_312_BurstBalloons();
        System.out.println("score:" + inst.maxCoins(nums));
    }
}
