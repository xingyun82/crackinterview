package geeksforgeeks;

import common.*;

/**
 *
 * Convert array into Zig-Zag fashion
 Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time. The converted array should be in form a < b > c < d > e < f.

 Example:
 Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
 Output: arr[] = {3, 7, 4, 8, 2, 6, 1}

 Input:  arr[] =  {1, 4, 3, 2}
 Output: arr[] =  {1, 4, 2, 3}

 * Created by xingyun on 15/8/22.
 */
public class ZigzagArrary {

    private void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    public void zigZag(int[] nums) {
        boolean flag = true;

        for(int i=0; i<=nums.length-2; i++) {
            if(flag) {
                if(nums[i] > nums[i+1]) {
                    swap(nums[i], nums[i+1]);
                }
            }
            else
            {
                if(nums[i] < nums[i+1]) {
                    swap(nums[i], nums[i+1]);
                }
            }
            flag = !flag;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        ZigzagArrary inst = new ZigzagArrary();
        inst.zigZag(nums);
        for(int i:nums) {
            System.out.print(i+",");
        }
    }
}
