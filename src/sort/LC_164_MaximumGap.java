package sort;

/**
 *
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Return 0 if the array contains less than 2 elements.

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.



 * Created by xingyun on 15/6/9.
 */
import java.util.List;
import java.util.ArrayList;

public class LC_164_MaximumGap {

    int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i:nums) {
            if(i>max) max = i;
            if(i<min) min = i;
        }
        int len = max - min;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>();
        for(int i=0; i<nums.length;++i) {
            buckets.add(null);
        }

        for(int i=0;i<nums.length;++i) {
            int idx = (int)((double)(nums[i]-min)/(double)len*(double)(nums.length-1));
            if(buckets.get(idx) == null) {
                buckets.set(idx, new ArrayList<Integer>());
                buckets.get(idx).add(nums[i]);
                buckets.get(idx).add(nums[i]);
            } else {
                buckets.get(idx).set(0, Math.min(buckets.get(idx).get(0), nums[i]));
                buckets.get(idx).set(1, Math.max(buckets.get(idx).get(1), nums[i]));
            }
        }
        int gap = 0;
        int prev = 0;
        for (int i = 1; i < buckets.size(); i++) {
            if (buckets.get(i)==null) continue;
            gap = Math.max(gap, buckets.get(i).get(0) - buckets.get(prev).get(1));
            prev = i;
        }
        return gap;

    }

    /*
    int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        // find the minimum and the maximum
        int imax = nums[0];
        int imin = nums[0];
        for (int x : nums) {
            if (x > imax) imax = x;
            if (x < imin) imin = x;
        }
        // max gap should be more than (max-min)/N+1, set it to bucket lenth
        int m = (imax - imin) / nums.length + 1;
        int s = (imax - imin) / m + 1; // so we have so many buckets
        // since the maximum gap in same bucket is bucket length,
        // so the max gap shouldn't be in the same bucket
        // and we just need the minimum and the maximum of each bucket
        List<List<Integer>> buckets = new ArrayList<List<Integer>>();
        for(int i=0;i<s;++i) {
            buckets.add(null);
        }
        for (int x : nums) {
            int i = (x - imin) / m;
            if (buckets.get(i) == null) {
                buckets.set(i, new ArrayList<Integer>());
                buckets.get(i).add(x);
                buckets.get(i).add(x);
            } else {
                if (x < buckets.get(i).get(0)) buckets.get(i).set(0,x);
                if (x > buckets.get(i).get(1)) buckets.get(i).set(1,x);
            }
        }
        // calculate the maximal gap
        int gap = 0;
        int prev = 0;
        for (int i = 1; i < buckets.size(); i++) {
            if (buckets.get(i)==null) continue;
            gap = Math.max(gap, buckets.get(i).get(0) - buckets.get(prev).get(1));
            prev = i;
        }
        return gap;
    }
    */

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,14,8,23,145,51,27,69};
        LC_164_MaximumGap inst = new LC_164_MaximumGap();
        System.out.println(inst.maximumGap(nums));
    }
}
