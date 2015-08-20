package sort;

import java.util.*;
import common.*;
/**
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 * Created by xingyun on 15/7/25.
 */
public class LC_57_InsertInterval {

    public int search(List<Integer> nums, int low, int high, int target) {
        if(low == high) {
            if(target < nums.get(low)) return low-1;
            return low;
        }
        if(low+1 == high) {
            if(target < nums.get(low)) return low-1;
            if(target < nums.get(high)) return low;
            return high;
        }
        int mid = (low+high) >>> 1;
        if(target < nums.get(mid)) {
            return search(nums, low, mid, target);
        } else {
            return search(nums, mid, high, target);
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }

        List<Integer> starts = new ArrayList<Integer>();
        for(Interval interval:intervals) {
            starts.add(interval.start);
        }
        int mergeStartIdx = search(starts, 0, starts.size()-1, newInterval.start);
        int mergeEndIdx = search(starts, Math.max(0, mergeStartIdx), starts.size()-1, newInterval.end);

        if(mergeStartIdx == -1 && mergeEndIdx == -1) {
            res.add(newInterval);
            res.addAll(intervals);
            return res;
        }

        if(mergeStartIdx == -1) {
            mergeStartIdx = 0;
        }

        if(mergeStartIdx > 0) {
            res.addAll(intervals.subList(0, mergeStartIdx));
        }

        // decide if start should merge
        Interval mergeStartInterval = intervals.get(mergeStartIdx);
        Interval mergeEndInterval = intervals.get(mergeEndIdx);

        if(newInterval.start <= mergeStartInterval.end) {
            // should merge
            newInterval.start = Math.min(newInterval.start, mergeStartInterval.start);
            newInterval.end = Math.max(newInterval.end, mergeEndInterval.end);
        } else {
            res.add(mergeStartInterval);
            newInterval.end = Math.max(newInterval.end, mergeEndInterval.end);
        }
        res.add(newInterval);

        if(mergeEndIdx < intervals.size()-1) {
            res.addAll(intervals.subList(mergeEndIdx + 1, intervals.size()));
        }

        return res;
    }

    public static void main(String[] args) {
        /*
            int[] nums = new int[]{10, 20, 30, 50, 70, 90};
            List<Integer> numArray = new ArrayList<Integer>();
            for (int i : nums) numArray.add(i);
            LC_57_InsertInterval inst = new LC_57_InsertInterval();
            System.out.println(inst.search(numArray, 0, nums.length - 1, 0));
        */

        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(13,15));

        Interval newInterval = new Interval(0,17);

        LC_57_InsertInterval inst = new LC_57_InsertInterval();
        List<Interval> res = inst.insert(intervals, newInterval);
        for(Interval interval : res) {
            System.out.println(interval.start + "," + interval.end);
        }

    }
}
