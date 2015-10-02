package facebook;

import java.util.*;

/**
 *
 * A 2D array filled with integer, define a flow from one point to its neighbor only if the
 * value of current point is not less than its neighbor's value. Consider up edge and left edge
 * as east coast, bottom edge and right edge as west coast, find all position that it can flow
 * to east coast and west cost both
 *
 * Created by xingyun on 9/29/15.
 */

public class FlowMap {

    class Point {
        int x;
        int y;
        public Point(int x, int y) {this.x = x; this.y = y;}
    }

    public final static int[][] dirs = new int[][] {
        {-1, 0, 0, 1},
        {0, -1, 1, 0}
    };

    public boolean[][] flowBothCoasts(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        boolean[][] b = new boolean[m][n];
        boolean[][] be = flowCoasts(a, m, n, n - 1, m - 1);
        boolean[][] bw = flowCoasts(a, m, n, 0, 0);
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                b[i][j] = be[i][j] && bw[i][j];
            }
        }
        return b;
    }

    public boolean[][] flowCoasts(int[][] a, int m, int n, int i0, int j0) {
        boolean[][] b = new boolean[m][n];
        Queue<Point> queue = new LinkedList<Point>();
        for(int i=0; i<m; ++i) {
            queue.offer(new Point(i, j0));
            b[i][j0] = true;
        }
        for(int j=0; j<n; ++j) {
            queue.offer(new Point(i0, j));
            b[i0][j] = true;
        }
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int d=0; d<4; d++) {
                int nx = p.x + dirs[0][d];
                int ny = p.y + dirs[1][d];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !b[nx][ny]) {
                    if(a[nx][ny] >= a[p.x][p.y]) {
                        queue.offer(new Point(nx, ny));
                        b[nx][ny] = true;
                    }
                }
            }
        }
        return b;
    }

    public static void main(String[] args) {
        FlowMap inst = new FlowMap();
        int[][] a = new int[][] {
                {1,2,3,4},
                {2,1,4,3},
                {3,4,1,2},
                {4,3,2,1}
        };

        boolean[][] b = inst.flowBothCoasts(a);
        for(int i=0; i<b.length; ++i) {
            for(int j=0; j<b[0].length; ++j) {
                System.out.print(b[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
