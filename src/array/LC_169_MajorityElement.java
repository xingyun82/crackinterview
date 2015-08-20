package array;

/**
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 * Created by xingyun on 15/6/4.
 */
public class LC_169_MajorityElement {

    public int majorityElement(int[] nums) {
        int len = nums.length;
        int maj = nums[0];
        int count = 0;
        for(int i:nums) {
            if(count == 0) {
                maj = i;
                count++;
            }
            if(maj == i) {
                count++;
            } else {
                count--;
            }
            if(count > len/2) break;
        }
        return maj;
    }


    /*
    public int majorityElement(int[] nums) {
        int res = 0;
        int len = nums.length;
        if(len == 1) return nums[0];

        boolean[] diffs = new boolean[len];
        int i = 0, j=1;
        while(i<len && j<len) {
            if(nums[i] != nums[j]) {
                diffs[i] = true;
                diffs[j] = true;
                while(i<len && (diffs[i]==true || i==j)) i++;
                while(j<len && (diffs[j]==true || i==j)) j++;
            } else {
                do {
                    j++;
                } while(j<len && diffs[j] == true);
            }
        }
        if(i<len) {
            res = nums[i];
        }
        return res;
    }
    */

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3};
        LC_169_MajorityElement inst = new LC_169_MajorityElement();
        System.out.println(inst.majorityElement(nums));
    }
}
