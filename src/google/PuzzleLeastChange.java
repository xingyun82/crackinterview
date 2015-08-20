package google;

import common.Point;

import java.util.ArrayList;
import java.util.*;

class LeastChangeNum {
    int val;
}
/**
 * 1. 二维matrix，含0，1。  1是障碍。
 00011
 11100
 从左上角出发到右下角， 可以往上，往下，往右移动。
 把1变成0，使得你可以从左上角到右下角。
 求最小的变化数字。
 *
 * Created by xingyun on 15/7/12.
 */
public class PuzzleLeastChange {

    public void doPuzzle(int[][] matrix, Point point, Set<Point> pSet,
                         List<Point> path,
                         int curChange, LeastChangeNum minChange) {
        if(point.x == matrix.length -1 && point.y == matrix[0].length -1) {
            for(Point p:path) {
                System.out.print(p.x + "," + p.y + " ");
            }
            System.out.println("minChange:" + curChange);

            if(curChange < minChange.val) {
                minChange.val = curChange;
            }
            return;
        }

        List<Point> nextCands = new ArrayList<Point>();

        Point right = new Point();
        right.x = point.x;
        right.y = point.y + 1;

        Point up = new Point();
        up.x = point.x - 1;
        up.y = point.y;

        Point down = new Point();
        down.x = point.x + 1;
        down.y = point.y;

        nextCands.add(right);
        nextCands.add(up);
        nextCands.add(down);

        for(Point p: nextCands) {
            if(p.x <0 || p.x >= matrix.length || p.y <0 || p.y >= matrix[0].length) continue;
            if(pSet.contains(p)) continue;
            if(matrix[p.x][p.y] == 1) curChange++;
            path.add(p);
            pSet.add(p);
            doPuzzle(matrix, p, pSet, path, curChange, minChange);
            // back tracking
            path.remove(path.size()-1);
            pSet.remove(p);
            if(matrix[p.x][p.y] == 1) curChange--;
        }

    }


    public int leastChange(int[][] matrix) {
        LeastChangeNum minChange = new LeastChangeNum();
        minChange.val = Integer.MAX_VALUE;
        Point start = new Point();
        start.x = 0;
        start.y = 0;
        Set<Point> pSet = new HashSet<Point>();
        pSet.add(start);
        List<Point> path = new ArrayList<Point>();
        path.add(start);
        doPuzzle(matrix, start, pSet, path, 0, minChange);
        return minChange.val;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][];
        matrix[0] = new int[]{0,0,1,0,1,1};
        matrix[1] = new int[]{0,1,0,1,0,0};
        matrix[2] = new int[]{1,0,1,1,0,1};
        matrix[3] = new int[]{1,0,0,0,1,0};
        PuzzleLeastChange inst = new PuzzleLeastChange();
        System.out.println(inst.leastChange(matrix));
    }
}
