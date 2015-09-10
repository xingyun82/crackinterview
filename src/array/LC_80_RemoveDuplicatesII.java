package array;

/**
 *
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

 * Created by xingyun on 15/8/19.
 */
public class LC_80_RemoveDuplicatesII {

    /*
    public int removeDuplicates(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int slow = 0, fast = 0;
        int len = 0;
        while(fast < nums.length) {
            // intialization for the next step
            fast++; len = 1;
            // move fast pointer, stop when meet new number
            while(fast<nums.length && nums[fast] == nums[fast-1]) { fast++; len++;}
            // reconstruct array with slow pointer
            for(int i=0; i<Math.min(len, k); ++i) { nums[slow++] = nums[fast-1];}

        }
        return slow;
    }
    */

    // 更简明的方法
    public int removeDuplicates(int[] nums, int k) {
        int i= 0;
        for(int n: nums) {
            if(i<k || n != nums[i-k]) {
                nums[i++] = n;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        LC_80_RemoveDuplicatesII inst = new LC_80_RemoveDuplicatesII();
        int[] nums = new int[]{1,1,2,2,2,2,3,4,4,4,4};
        System.out.println(inst.removeDuplicates(nums, 1));

    }
}
