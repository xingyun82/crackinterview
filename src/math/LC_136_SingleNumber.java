package math;

/**
 * Created by xingyun on 15/6/28.
 */
public class LC_136_SingleNumber {

    public int singleNumber(int[] nums) {
        if(nums.length == 0) return 0;
        int res = nums[0];
        for(int i=1; i<nums.length; ++i) {
            res = res ^ nums[i];
        }
        return res;
    }

}
