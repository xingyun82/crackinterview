package array;

public class LC_644_MaximumAverageSubarrayII {

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double[][] sum = new double[n+1][n+1];
        double maxAvg = -Double.MAX_VALUE;
        for (int i=1; i<=n; ++i) {
            for (int j = 1; j <= i; ++j) {
                sum[i][j] = sum[i - 1][j - 1] + nums[i - 1];
                if (j>=k) {
                    maxAvg = Math.max(maxAvg, sum[i][j]/j);
                }
            }
        }
        return maxAvg;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        int k = 1;
        LC_644_MaximumAverageSubarrayII inst = new LC_644_MaximumAverageSubarrayII();
        System.out.println(inst.findMaxAverage(nums, k));
    }
}
