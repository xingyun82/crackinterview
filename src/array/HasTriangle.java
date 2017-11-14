package array;

import java.util.Arrays;
/**
 * 判断一个数组是否可以找出三个数组成一个三角形
 *
 * Hint: math problem
 * Created by xingyun on 15/8/17.
 */
public class HasTriangle {

    public boolean hasTriangle(int[] nums) {
        if(nums.length < 3) return false;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; ++i) {
            if(nums[i]+nums[i+1] > nums[i+2]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        HasTriangle inst = new HasTriangle();
        int[] nums = new int[]{1, 1, 2, 3, 5, 8, 12, 21};
        System.out.println(inst.hasTriangle(nums));
    }
}
