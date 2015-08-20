package math;

import common.Point;

import java.util.*;

/**
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Created by xingyun on 15/6/21.
 */
public class LC_149_MaxPointsInSameLine {

    public int maxPoints(Point[] points) {
        if(points.length == 0) return 0;
        int max = 0;
        // remove duplicated points
        HashMap<String, Integer> dupCount = new HashMap<String, Integer>();
        List<Point> pointList = new ArrayList<Point>();
        for(Point p:points) {
            String key = p.x + ":" + p.y;
            if(dupCount.containsKey(key)) {
                dupCount.put(key, dupCount.get(key) + 1);
            } else {
                dupCount.put(key, 1);
                pointList.add(p);
            }
        }

        List<HashMap<Double, Integer>> xlMapList = new ArrayList<HashMap<Double, Integer>>();
        for (int i=0; i<pointList.size(); ++i) {
            xlMapList.add(new HashMap<Double, Integer>());
        }
        if (pointList.size() == 1) {
            Point pi = pointList.get(0);
            return dupCount.get(pi.x + ":" + pi.y);
        }
        // common.Point => hash(xielv, count)
        for(int i=0; i<pointList.size(); ++i) {
            Point pi = pointList.get(i);
            int dupi = dupCount.get(pi.x + ":" + pi.y);
            for(int j=i+1; j<pointList.size(); ++j) {
                Point pj = pointList.get(j);
                int dupj = dupCount.get(pj.x + ":" + pj.y);

                double xl = 0;
                if (pi.x == pj.x) {
                    xl = Integer.MAX_VALUE;
                } else {
                    xl = (pi.y - pj.y)*1.0 / (pi.x - pj.x);
                }

                if (xlMapList.get(i).containsKey(xl)) {
                    int count = xlMapList.get(i).get(xl) + dupj;
                    xlMapList.get(i).put(xl, count);
                } else {
                    xlMapList.get(i).put(xl, dupj);
                }

                if (xlMapList.get(j).containsKey(xl)) {
                    int count = xlMapList.get(j).get(xl) + dupi;
                    xlMapList.get(j).put(xl, count);
                } else {
                    xlMapList.get(j).put(xl, dupi);
                }


                int counti = xlMapList.get(i).get(xl) + dupi;
                int countj = xlMapList.get(j).get(xl) + dupj;
                if (counti > max) max = counti;
                if (countj > max) max = countj;

            }
        }
        return max;
    }

    public static void main(String[] args) {
        Point[] points = new Point[9];
        points[0] = new Point(84,250);
        points[1] = new Point(0,0);
        points[2] = new Point(1,0);
        points[3] = new Point(0,-70);
        points[4] = new Point(0,-70);
        points[5] = new Point(1,-1);
        points[6] = new Point(21,10);
        points[7] = new Point(42,90);
        points[8] = new Point(-42,-230);


        LC_149_MaxPointsInSameLine inst = new LC_149_MaxPointsInSameLine();
        System.out.println(inst.maxPoints(points));

    }
}
