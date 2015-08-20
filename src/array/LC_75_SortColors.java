package array;

/**
 *
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 click to show follow up.

 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?
 * Created by xingyun on 15/8/19.
 */
public class LC_75_SortColors {

    public void sortColors(int[] nums) {
        // two pointers, time complexity: O(N)
        int i=0, j = nums.length-1, tmp=0;
        // 1. swap 0 to the left
        while(i<j) {
            while(i<nums.length && nums[i] == 0) i++;
            while(j>=0 && nums[j] != 0) j--;
            if(i>=j) break;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        j = nums.length-1;
        // 2. swap 1 to the left
        while(i<j) {
            while(i<nums.length && nums[i] == 1) i++;
            while(j>=0 && nums[j] != 1) j--;
            if(i>=j) break;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
