package dp;

/**
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.

 * Created by xingyun on 15/6/16.
 */
public class LC_152_MaxProdSubarry {

    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int prePosMax = 0;
        int preNegMax = 0;
        int maxProd = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; ++i) {
            if(nums[i] == 0) {
                prePosMax = 0;
                preNegMax = 0;
            } else if(nums[i] > 0) {
                if(prePosMax > 0) {
                    prePosMax = prePosMax * nums[i];
                } else {
                    prePosMax = nums[i];
                }

                if(preNegMax < 0) {
                    preNegMax *= nums[i];
                } else {
                    preNegMax = 0;
                }

            } else if(nums[i] < 0) {
                int tmp = prePosMax;
                if(preNegMax < 0) {
                    prePosMax = preNegMax * nums[i];
                } else {
                    prePosMax = 0;
                }

                if(tmp > 0) {
                    preNegMax = tmp * nums[i];
                } else {
                    preNegMax = nums[i];
                }
            }

            if(maxProd < prePosMax) maxProd = prePosMax;
        }

        return maxProd;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,-2,-4};
        LC_152_MaxProdSubarry inst = new LC_152_MaxProdSubarry();
        System.out.println(inst.maxProduct(nums));
    }
}
