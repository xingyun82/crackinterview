package corejava;

import java.sql.Time;
import java.util.*;
/**
 *
 * You are given a file which contains 3 values - start time, end time,
 * amount of water flowing between the start time and end time for one day

 The start time and end time may overlap and are inclusive. The times are not in a sorted order

 Example:
 0,10,100
 10,15,300
 16,20,400
 5,15,200

 Find the max flow of water at any instant of time.
 In the above example, the answer is 600 ( at instant 10)

 * Created by xingyun on 9/24/15.
 */
class TimeVolumn{
    int time;
    boolean start;
    int volumn;

}

public class WaterVolumn {


    public int maxVolumn(List<String> data) {
        List<TimeVolumn> timeVolumns = new ArrayList<TimeVolumn>();
        for(String line:data) {
            String[] segs = line.split(",");
            TimeVolumn startVolumn = new TimeVolumn();
            startVolumn.time = Integer.valueOf(segs[0]);
            startVolumn.start = true;
            startVolumn.volumn = Integer.valueOf(segs[2]);
            TimeVolumn endVolumn = new TimeVolumn();
            endVolumn.time = Integer.valueOf(segs[1]);
            endVolumn.start = false;
            endVolumn.volumn = Integer.valueOf(segs[2]);
            timeVolumns.add(startVolumn);
            timeVolumns.add(endVolumn);
        }
        timeVolumns.sort(new Comparator<TimeVolumn>() {
            @Override
            public int compare(TimeVolumn o1, TimeVolumn o2) {
                if(o1.time != o2.time) return o1.time - o2.time;
                if(o1.start == o2.start) return 0;
                if(o1.start) return -1;
                return 1;
            }
        });

        int maxSum = 0;
        int tmpSum = 0;
        for(int i=0; i<timeVolumns.size(); ++i) {
            tmpSum += timeVolumns.get(i).volumn * (timeVolumns.get(i).start?1:-1);
            maxSum = Math.max(tmpSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        List<String> data = new ArrayList<String>();
        data.add("0,10,100");
        data.add("10,15,300");
        data.add("16,20,400");
        data.add("5,15,200");
        WaterVolumn inst = new WaterVolumn();
        System.out.println(inst.maxVolumn(data));
    }

}
