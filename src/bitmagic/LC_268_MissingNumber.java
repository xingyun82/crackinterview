package bitmagic;

/**
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

 * Created by xingyun on 9/26/15.
 */
public class LC_268_MissingNumber {

    /*
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        // actual sum
        long sum = 0;
        for(int i:nums) {
            sum += i;
        }
        // original sum
        long sum2 = 0;
        for(int i=0;i<nums.length+1;++i) {
            sum2 += i;
        }
        return (int)(sum2 - sum);
    }
    */

    public int missingNumber(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}
