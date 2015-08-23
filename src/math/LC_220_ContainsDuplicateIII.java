package math;

import java.util.*;
/**
 * Created by xingyun on 15/8/21.
 */
public class LC_220_ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || t < 0 || k < 1) return false;
        Map<Long, Long> qmap = new HashMap<Long, Long>();
        for(int i=0; i<nums.length; ++i) {
            // remove q of nums[i-k-1]
            if(i-k-1>=0) {
                long bucket = ((long)nums[i-k-1]-Integer.MIN_VALUE)/((long)t+1);
                qmap.remove(bucket);
            }
            long q = ((long)nums[i] - Integer.MIN_VALUE);
            long bucket = q/((long)t+1);
            if(qmap.containsKey(bucket) || qmap.containsKey(bucket-1) && q - qmap.get(bucket-1) <= (long)t ||
                    qmap.containsKey(bucket+1) && qmap.get(bucket+1) -q <= (long)t) return true;
            qmap.put(bucket, q);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2147483647};
        LC_220_ContainsDuplicateIII inst = new LC_220_ContainsDuplicateIII();
        System.out.println(inst.containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }
}
