package array;

import java.util.*;
/**
 * Created by xingyun on 9/28/15.
 */


public class SkyLine {

    class Range {
        int L;
        int R;
        public Range(){}
        public Range(int l, int r) { L = l; R = r;}
    }
    class Building {
        Range range = new Range();
        int H;
    }
    class Point {
        int x;
        int y;
        public Point(int x, int y) {this.x = x; this.y = y;}
    }

    // find the most left overlap range
    public int mostLeftOverlap(List<Range> ranges, Range nr) {

        int l = 0, h = ranges.size() - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (ranges.get(mid).R < nr.L) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        if(ranges.get(l).R < nr.L) return l+1;
        return l;
    }
    // find the most right overlap range
    public int mostRightOverlap(List<Range> ranges, Range nr) {

        int l = 0, h = ranges.size() - 1;
        while(l < h) {
            int mid = l + (h-l)/2+1;
            if(ranges.get(mid).L > nr.R) {
                h = mid - 1;
            } else {
                l = mid;
            }
        }
        if(ranges.get(h).L > nr.R) return h-1;
        return h;
    }


    // merge new range nr into ranges
    public List<Point> merge(List<Range> ranges, Range nr, Map<Integer, Integer> highest, int nh) {
        List<Point> res = new ArrayList<Point>();
        if(ranges == null || ranges.size() == 0) {
            res.add(new Point(nr.L, nh));
            ranges.add(nr);
        } else {
            int mostLeft = mostLeftOverlap(ranges, nr);
            int mostRight = mostRightOverlap(ranges, nr);

            if(mostLeft == ranges.size()) {
                res.add(new Point(nr.L, nh));
                ranges.add(nr);

            } else if(mostRight == -1) {
                res.add(new Point(nr.L, nh));
                ranges.add(0, nr);
            } else {

                Range mr = new Range();
                mr.L = Math.min(ranges.get(mostLeft).L, nr.L);
                if (nr.L < ranges.get(mostLeft).L) {
                    res.add(new Point(nr.L, nh));
                }
                mr.R = Math.max(ranges.get(mostRight).R, nr.R);
                // check if ranges right should be checked as keypoint
                for(int i=mostLeft; i<=mostRight; ++i) {
                    if(ranges.get(i).R < nr.R && highest.get(ranges.get(i).R) > nh) {
                        res.add(new Point(ranges.get(i).R, nh));
                    }
                }

                List<Range> nranges = new ArrayList<Range>();
                nranges.addAll(ranges.subList(0, mostLeft));
                nranges.add(mr);
                nranges.addAll(ranges.subList(mostRight + 1, ranges.size()));
                ranges.clear();
                ranges.addAll(nranges);
            }

        }

        return res;
    }

    /**
     *
     * @param buildings n*3
     * @return k*2
     */
    public List<int[]> getSkyline(int[][] buildings) {

        List<int[]> res = new ArrayList<int[]>();
        // to get building by height descendant order
        PriorityQueue<Building> buildingQueue = new PriorityQueue<Building>(new Comparator<Building>() {
            @Override
            public int compare(Building o1, Building o2) {
                if(o1.H != o2.H) return o2.H - o1.H;
                if(o1.range.L != o2.range.L) return o1.range.L - o2.range.L;
                if(o1.range.R != o2.range.R) return o1.range.R - o2.range.R;
                return 0;
            }
        });
        // map x to highest y
        Map<Integer, Integer> highest = new HashMap<Integer, Integer>();

        for(int i=0; i<buildings.length; ++i) {
            Building b = new Building();
            b.range.L = buildings[i][0];
            b.range.R = buildings[i][1];
            b.H = buildings[i][2];
            buildingQueue.offer(b);

//            if(!highest.containsKey(b.range.L) || highest.get(b.range.L) < b.H) {
//                highest.put(b.range.L, b.H);
//            }
            if(!highest.containsKey(b.range.R) || highest.get(b.range.R) < b.H) {
                highest.put(b.range.R, b.H);
            }
        }

        List<Point> points = new ArrayList<Point>();
        List<Range> ranges = new ArrayList<Range>();
        while(!buildingQueue.isEmpty()) {
            Building b = buildingQueue.poll();
            List<Point> keyPoints = merge(ranges, b.range, highest, b.H);
            points.addAll(keyPoints);
        }
        // add end of each range as key point
        for(Range r:ranges) {
            points.add(new Point(r.R, 0));
        }
        // sort key points
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });
        // transform to result
        for(Point p:points) {
            res.add(new int[]{p.x, p.y});
        }
        return res;
    }


    public void testMostLeftOverlap() {
        List<Range> ranges = new ArrayList<Range>();
        ranges.add(new Range(1,3));
        ranges.add(new Range(5,7));
        ranges.add(new Range(9,11));
        ranges.add(new Range(13,15));
        Range nr = new Range(-1, 0);
        int leftOverlap = mostLeftOverlap(ranges, nr);
        int rightOverlap = mostRightOverlap(ranges, nr);
        System.out.println("l:" + leftOverlap);
        System.out.println("r:" + rightOverlap);

    }



    public static void main(String[] args) {
        int[][] buildings = new int[7][3];
        buildings[0] = new int[]{0,5,7};
        buildings[1] = new int[]{5,10,7};
        buildings[2] = new int[]{5,10,12};
        buildings[3] = new int[]{10,15,7};
        buildings[4] = new int[]{15,20,7};
        buildings[5] = new int[]{15,20,12};
        buildings[6] = new int[]{20,25,7};


        SkyLine inst = new SkyLine();
        List<int[]> res = inst.getSkyline(buildings);
        for(int[] keyPoint:res) {
            System.out.println(keyPoint[0] + "," + keyPoint[1]);
        }


//        SkyLine inst = new SkyLine();
//        inst.testMostLeftOverlap();
    }
}
