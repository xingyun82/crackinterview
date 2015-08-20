package array;

/**
 *Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.
 *
 * Created by xingyun on 15/8/19.
 */
public class LC_81_SearchInRotatedSortedArrayII {

    private boolean divideAndConq(int[] nums, int low, int high, int target) {
        if(low > high) return false;
        int mid = (low + high) >>> 1;
        if(nums[mid] == target) return true;
        if(nums[low] < nums[mid]) {
            if(target >= nums[low] && target < nums[mid]) {
                return divideAndConq(nums, low, mid-1, target);
            } else {
                return divideAndConq(nums, mid+1, high, target);
            }
        } else if(nums[low] == nums[mid]) {
            return divideAndConq(nums, low, mid-1, target) ||
                    divideAndConq(nums, mid+1, high, target);
        } else {
            if(target> nums[mid] && target <= nums[high]) {
                return divideAndConq(nums, mid+1, high, target);
            } else {
                return divideAndConq(nums, low, mid - 1, target);
            }
        }
    }

    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        return divideAndConq(nums, 0, nums.length-1, target);
    }
}
