package graph;

import java.util.*;
/**
 *
 * You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

 For example, given the 2D grid:

 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 After running your function, the 2D grid should be:

 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
 * Created by xingyun on 10/4/15.
 */
public class LC_286_WallsAndGates {

    private final static int EMPTY_ROOM = Integer.MAX_VALUE;
    private final static int WALL = -1;

    private final static int[][] dirs = {
            {-1, 0, 0, 1},
            { 0, -1, 1, 0}
    };

    class Point {
        int x;
        int y;
        public Point(int x, int y) { this.x = x; this.y = y;}
    }

    public void wallsAndGates(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        //boolean[][] visist = new boolean[M][N];
        Queue<Point> queue = new LinkedList<Point>();
        for(int i=0; i<M; ++i) {
            for(int j=0; j<N; ++j) {
                if(matrix[i][j] == 0) {
                    queue.offer(new Point(i, j));
                }
            }
        }
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i=0; i<4; ++i) {
                int nx = p.x + dirs[0][i];
                int ny = p.y + dirs[1][i];
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(matrix[nx][ny] == WALL) continue;
                if(matrix[nx][ny] == EMPTY_ROOM) {
                    matrix[nx][ny] = matrix[p.x][p.y]+1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        LC_286_WallsAndGates inst = new LC_286_WallsAndGates();
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE};
        matrix[1] = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1};
        matrix[2] = new int[]{Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1};
        matrix[3] = new int[]{0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE};
        inst.wallsAndGates(matrix);
        for(int i=0; i<matrix.length; ++i) {
            for(int j=0; j<matrix[0].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }
}
