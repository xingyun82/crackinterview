package array;



public class LC_643_MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i=0; i<k; ++i) {
            sum += nums[i];
        }
        double max = sum;
        for (int j=k; j<nums.length; ++j) {
            sum += nums[j] - nums[j-k];
            max = Math.max(max, sum);
        }
        return max/k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        LC_643_MaximumAverageSubarrayI inst = new LC_643_MaximumAverageSubarrayI();
        System.out.println(inst.findMaxAverage(nums, 4));
    }
}
