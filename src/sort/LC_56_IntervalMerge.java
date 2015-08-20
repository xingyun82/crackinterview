package sort;

import common.*;
import java.util.*;
/**
 * Created by xingyun on 15/7/25.
 */
public class LC_56_IntervalMerge {


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

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 8));
        intervals.add(new Interval(10, 14));

        LC_56_IntervalMerge inst = new LC_56_IntervalMerge();
        List<Interval> res = inst.merge(intervals);
        for(Interval interval:res) {
            System.out.println(interval.start + "," + interval.end);
        }
    }
}
