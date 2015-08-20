package array;

import java.util.*;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

 * Created by xingyun on 15/8/19.
 */
public class LC_228_SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        int i=0, j = 0;
        while(j<nums.length) {
            j++;
            while(j<nums.length && nums[j]-nums[j-1] == 1) j++;
            // add range inf res
            if(i == j-1) {
                res.add(String.valueOf(nums[i]));
            } else {
                res.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[j-1]));
            }
            //
            i = j;
        }
        return res;
    }
}
