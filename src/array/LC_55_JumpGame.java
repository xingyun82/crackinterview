package array;

/**
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.

 * Created by xingyun on 15/7/25.
 */
public class LC_55_JumpGame {

    /**
     *
     * @param nums
     * @return
     */
    /*
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int i = nums.length-1;
        int preMin = 0;
        while(i>0) {
            while((nums[i] == 0 || nums[i] < preMin) && i>0) {
                i--;
                preMin++;
            }
            if(i==0)break;
            preMin = 1;
            while(i>0 && nums[i]>0) {
                i--;
            }
        }
        if(nums[0] < preMin) return false;
        return true;
    }
    */

    /**
     * leetcode上有更精简的算法
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int last=nums.length-1,i;
        for(i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=last)last=i;
        }
        return last<=0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 0};
        LC_55_JumpGame inst = new LC_55_JumpGame();
        System.out.println(inst.canJump(nums));
    }
}
