package hackerrank;

/**
 * 连续的递增数组里少了一个数，求这个数
 * Created by xingyun on 15/8/25.
 */
public class MissingNumber {

    public int binarySearch(int[] nums, int l, int h, int q) {
        int n = nums.length;
        /*
        int m = (l+h)>>>1;
        if(l+1 == h) return (nums[l]+nums[h])/2;
        if((nums[m] - nums[l])/q != m-l) {
            return binarySearch(nums, l, m, q);
        } else if((nums[h] - nums[m])/q != h-m) {
            return binarySearch(nums, m, h, q);
        }
        return nums[n-1] + (nums[n-1] - nums[n-2]);
        */

        while(l+1<h) {
            int m = (l+h)>>>1;
            if((nums[m] - nums[l])/q != m-l) {
                h = m;
            } else if((nums[h] - nums[m])/q != h-m) {
                l = m;
            } else {
                return nums[n-1] + (nums[n-1] - nums[n-2]);
            }
        }
        return (nums[l]+nums[h])/2;
    }

    public int missNum(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int n = nums.length;
        int r = (nums[n-1] - nums[0])%(n);
        int q = (nums[n-1] - nums[0])/(n);
        // if missing the first one or the last one
        if(r != 0 || (r== 0 && q == n-1)) {
            return nums[n-1] + (nums[n-1] - nums[n-2]);
        }
        // else, find the missing num by binary search
        return binarySearch(nums, 0, n-1, q);

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,9,11};
        MissingNumber inst = new MissingNumber();
        System.out.println(inst.missNum(nums));
    }
}
