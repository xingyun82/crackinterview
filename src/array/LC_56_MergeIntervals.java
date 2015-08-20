package array;

import java.util.*;
import common.*;

/**
 *
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 * Created by xingyun on 15/8/19.
 */
public class LC_56_MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) return res;
        // sort
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start) return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });

        // merge
        Interval interval = intervals.get(0);
        for(int i=1; i<intervals.size(); ++i) {
            Interval tmpInterval = intervals.get(i);
            if(tmpInterval.start <= interval.end) {
                interval.end = Math.max(tmpInterval.end, interval.end);
            } else {
                res.add(interval);
                interval = tmpInterval;
            }
        }
        // add last interval
        res.add(interval);
        return res;
    }
}
