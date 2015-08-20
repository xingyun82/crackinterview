package array;

/**
 * A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 * Created by xingyun on 15/6/9.
 */
public class LC_162_FindPeakElement {

    public int doFind(int[] nums, int low, int high) {
        if(low == high) return high;
        if(high-low==1) {
            if(nums[high] > nums[low])return high;
            return low;
        }
        int mid = (low+high)/2;
        if(nums[mid-1] > nums[mid]) return doFind(nums, low, mid);
        if(nums[mid+1] > nums[mid]) return doFind(nums, mid, high);
        return mid;
    }


    public int findPeakElement(int[] nums) {
        return doFind(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 3, 5, 6, 5, 7, 9, 4};
        LC_162_FindPeakElement inst = new LC_162_FindPeakElement();
        System.out.println(inst.findPeakElement(nums));

    }
}
