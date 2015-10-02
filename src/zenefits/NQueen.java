package zenefits;

import java.util.*;

/**
 * Created by xingyun on 9/26/15.
 */
public class NQueen {

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {this.x = x; this.y = y;}
        public boolean equals(Object o) {
            if(!(o instanceof Point)) return false;
            Point p = (Point)o;
            return p.x == x && p.y == y;
        }
        public int hashCode() {
            return x*37+y;
        }
    }

    // since A[i] = A[j] <==> i = j, we just consider the diagonal threats
    // there are two kinds of diagonal threats: same sum (p.x + p.y)  or same abstraction (p.x - p.y)
    // time complexity: O(n)
    static int maxThreats(int[] a) {
        List<Point> points = new ArrayList<Point>();
        int n = a.length;
        for(int i=0; i<a.length; ++i) {
            Point p = new Point(i+1, a[i]);
            points.add(p);
        }
        Map<Point, Integer> threatCountMap = new HashMap<Point, Integer>();
        Map<Integer, List<Point>> sumThreatMap = new HashMap<Integer, List<Point>>();
        Map<Integer, List<Point>> abstThreatMap = new HashMap<Integer, List<Point>>();

        // get sum threat map, and abstract threat map
        for(Point p:points) {
            int sum = p.x + p.y;
            int abst = p.x - p.y;
            if(!sumThreatMap.containsKey(sum)) {
                List<Point> l = new ArrayList<Point>();
                l.add(p);
                sumThreatMap.put(sum, l);
            } else {
                List<Point> l = sumThreatMap.get(sum);
                l.add(p);
            }

            if(!abstThreatMap.containsKey(abst)) {
                List<Point> l = new ArrayList<Point>();
                l.add(p);
                abstThreatMap.put(abst, l);
            } else {
                List<Point> l = abstThreatMap.get(abst);
                l.add(p);
            }
        }

        // construct threatCountMap for each point
        for(int sum:sumThreatMap.keySet()) {
            List<Point> l =  sumThreatMap.get(sum);
            if(l.size() < 2) continue;
            for(Point p:l) {
                if(!threatCountMap.containsKey(p)) {
                    threatCountMap.put(p, l.size()-1);
                } else {
                    int count = threatCountMap.get(p);
                    threatCountMap.put(p, count+l.size()-1);
                }
            }
        }
        for(int abst:abstThreatMap.keySet()) {
            List<Point> l = abstThreatMap.get(abst);
            if(l.size() < 2) continue;
            for(Point p:l) {
                if(!threatCountMap.containsKey(p)) {
                    threatCountMap.put(p, l.size()-1);
                } else {
                    int count = threatCountMap.get(p);
                    threatCountMap.put(p, count+l.size()-1);
                }
            }
        }
        // get the max threat count
        int maxThreatCount = 0;
        for(Point p:threatCountMap.keySet()) {
            int tmp = threatCountMap.get(p);
            maxThreatCount = Math.max(maxThreatCount, tmp);
        }
        return maxThreatCount;

    }

    public static void main(String[] args) {
//        int[] a = {1,5,8,6,3,7,2,4};
//        System.out.println(maxThreats(a));

        Map<Point, Integer> pointMap = new HashMap<Point, Integer>();
        pointMap.put(new Point(1,2), 1);
        pointMap.put(new Point(1,2), 2);
        pointMap.put(new Point(2,1), 1);
        pointMap.put(new Point(1,3), 1);
    }

}
