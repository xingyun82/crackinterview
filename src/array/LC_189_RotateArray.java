package array;

/**
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.


 * Created by xingyun on 15/6/2.
 */
public class LC_189_RotateArray {

    public void reverse(int[] nums, int beg, int end) {
        if(beg < 0 || end >= nums.length || beg >= end) return;
        int temp = 0;
        while(beg < end) {
            temp = nums[beg];
            nums[beg] = nums[end];
            nums[end] = temp;
            beg++;
            end--;
        }
    }


    public void rotate(int[] nums, int k) {
        // split array to two arrays by kth num
        // reverse array1
        // reverse array2
        // reverse whole array
        k %= nums.length;
        if (k==0) return;
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1};
        LC_189_RotateArray inst = new LC_189_RotateArray();
        inst.rotate(nums, 3);
        for(int i:nums) {
            System.out.println(i);
        }
    }
}
