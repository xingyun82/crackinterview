package array;

/**
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.

 *
 * Created by xingyun on 15/6/10.
 */
public class LC_153_FindMinOfRoatedArray {

    /*
    public int doFind(int[] nums, int low, int high) {
        if(low == high) return nums[low];
        if(high == low+1) return Math.min(nums[low], nums[high]);
        int mid = (low+high)/2;
        if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) return nums[mid];
        // low direction
        if((nums[mid-1] < nums[low] && nums[mid-1] < nums[mid])|| (nums[mid-1] > nums[low] && nums[mid-1] > nums[mid])) {
            return doFind(nums, low, mid);
        }
        if((nums[mid+1] < nums[high] && nums[mid+1] < nums[mid]) || (nums[mid+1] > nums[high] && nums[mid+1] > nums[mid])) {
            return doFind(nums, mid, high);
        }
        return Math.min(nums[low], nums[high]);

    }
    */

    public int doFind(int[] nums, int low, int high) {

        if(low == high || nums[low] < nums[high]) return nums[low];
        if(low+1 == high) return nums[high];
        int mid = (low+high)/2;
        if(nums[mid] > nums[low]) {
            return doFind(nums, mid, high);
        } else {
            return doFind(nums, low, mid);
        }
    }

    /*
    public int findMin(int[] nums) {
        return doFind(nums, 0, nums.length-1);
    }
    */

    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int mid;
        while(low < high) {
            if(nums[low] < nums[high]) return nums[low];
            mid = (low+high)>>>1;
            if(nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]){
                low = mid + 1;
            } else {
                high--;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        LC_153_FindMinOfRoatedArray inst = new LC_153_FindMinOfRoatedArray();

        int N = 7;
        for(int i=0;i<N;++i) {
            //int[] nums = new int[]{3, 4, 5, 6, 7, 0, 1, 2};
            int[] nums = new int[N];
            for(int j=0;j<N;++j) {
                if(j<i) {
                    nums[j] = N - i + j;
                } else {
                    nums[j] = j-i;
                }
                System.out.print(nums[j]);
            }
            System.out.println();
            System.out.println(inst.findMin(nums));
        }

        //int[] nums = new int[]{7,0,1,2,3,4,5,6};
        //System.out.println(inst.findMin(nums));
    }

}
