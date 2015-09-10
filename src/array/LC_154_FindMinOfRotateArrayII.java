package array;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by xingyun on 15/6/11.
 */
public class LC_154_FindMinOfRotateArrayII {

    public int doFind(int[] nums, int low, int high) {
        if(low == high || nums[low] < nums[high]) return nums[low];
        if(low+1 == high) return nums[high];
        int mid = (low+high)/2;
        while(nums[mid] == nums[low] && low<mid) {
            low++;
        }
        while(nums[mid] == nums[high] && high>mid) {
            high--;
        }
        if(low == mid) return doFind(nums, mid, high);
        if(high == mid) return doFind(nums, low, mid);
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
        int res  = Integer.MAX_VALUE;
        int l = 0, h = nums.length-1;
        int m = -1;
        while(l<=h) {
            m = (l+h)>>>1;
            if(nums[m] <= nums[h]) {
                res = Math.min(res, nums[m]);
                h = m-1;
            } else {
                l = m+1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LC_154_FindMinOfRotateArrayII inst = new LC_154_FindMinOfRotateArrayII();

        int N = 8;
        for(int idx=0;idx<10;++idx) {
            Random r = new Random();
            int j = r.nextInt(N);
            int k = j;
            //System.out.println("S="+j+",N="+k);
            List<Integer> arr = new ArrayList<Integer>();
            int c = 0;
            boolean flag = false;
            while(true) {
                arr.add(j%N);
                if(r.nextBoolean()||c>3) {
                    j=(j+1)%N;
                    flag = true;
                    c = 0;
                } else {
                    c++;
                }
                if(flag && j == k) break;
            }
            int[] nums = new int[arr.size()];
            for(int i=0;i<nums.length;++i) {
                nums[i] = arr.get(i);
                System.out.print(nums[i]);
            }
            System.out.println();
            System.out.println(inst.findMin(nums));
        }

        //int[] nums = new int[]{4,4,5,6,7,7,0,1,2,2,2,2,3};
        //System.out.println(inst.findMin(nums));
    }

}
