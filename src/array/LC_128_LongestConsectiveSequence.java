package array;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.

 * Created by xingyun on 15/7/5.
 */
public class LC_128_LongestConsectiveSequence {


    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int maxLen = Integer.MIN_VALUE;

        Set<Integer> numSet = new HashSet<Integer>();
        for(int i:nums) {
            numSet.add(i);
        }

        for(int i:nums) {
            if(numSet.contains(i-1)) {
               continue;
            } else {
                int key = i;
                int len = 0;
                while(numSet.contains(key)) {
                    len++;
                    key = key+1;
                }
                if(len>maxLen) maxLen = len;
            }
        }

        return maxLen;
    }

    /*
    private int maxLen(int[] idx) {
        int len = 0;
        int maxLen = Integer.MIN_VALUE;
        for(int i=0; i<idx.length; ++i) {
            if(idx[i] > 0) {
                len++;
            }
            else if(idx[i] == 0) {
                maxLen = Math.max(len, maxLen);
                len = 0;
            }
        }
        maxLen = Math.max(len, maxLen);
        return maxLen;
    }

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int zeros = 0;

        for(int i:nums) {
            if(i>max) max = i;
            if(i<min) min = i;

        }

        if(min>0||max<0) {
            int[] idx = new int[max-min+1];
            for(int i:nums) {
                idx[i-min]++;
            }
            return maxLen(idx);
        } else {
            int[] idx1 = new int[-1-min+1];
            int[] idx2 = new int[max-1+1];
            for(int i:nums) {
                if(i<0) {
                    idx1[i-min]++;
                }
                if(i>0) {
                    idx2[i-1]++;
                }
                if(i == 0) zeros++;
            }
            int maxLen1 = maxLen(idx1);
            int maxLen2 = maxLen(idx2);
            if(zeros == 0) return Math.max(maxLen1, maxLen2);
            int  maxLen3 = 1;
            for(int i=-1; i>=min; i--) {
                if(idx1[i-min]>0) maxLen3++;
                else break;
            }
            for(int i=1; i<=max; i++) {
                if(idx2[i-1]>0) maxLen3++;
                else break;
            }
            return Math.max(Math.max(maxLen1, maxLen2), maxLen3);
        }

    }
    */

    public static void main(String[] args) {
        int[] nums = new int[] { 100, 200, 1,3, 2, 4, 0, -1, 600};
        LC_128_LongestConsectiveSequence inst = new LC_128_LongestConsectiveSequence();
        System.out.println(inst.longestConsecutive(nums));
    }
}
