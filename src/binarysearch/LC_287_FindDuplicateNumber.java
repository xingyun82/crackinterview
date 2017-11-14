package binarysearch;

import java.util.Arrays;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.

 */
public class LC_287_FindDuplicateNumber {

    // idea: get for mid point = (1+n)/2, then find how many nums(count) smaller than mid point value,
    // if count > mid point, then the duplicate number <= mid point, then mid = (mid+n)/2
    // else the duplicate number <= mid point, then mid = (1+mid)/2
    public int findDuplicate(int[] nums) {
        int l = 1, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h-l)/2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            if (count <= mid) l = mid+1;
            else h = mid;
        }
        return l;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        LC_287_FindDuplicateNumber inst = new LC_287_FindDuplicateNumber();
        System.out.println(inst.findDuplicate(nums));
    }
}
