package dp;

/**
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?


 Above is a 3 x 7 grid. How many possible unique paths are there?

 Note: m and n will be at most 100.

 * Created by xingyun on 15/7/27.
 */
public class LC_62_UniquePaths {

    /*
    int paths = 0;

    public void doBacktracking(Point cur, Point end) {
        if(cur.x == end.x && cur.y == end.y) {
            paths++;
            return;
        }
        List<Point> nextChoices = new ArrayList<Point>();
        if(cur.y+1 >= 0 && cur.y+1 <= end.y) {
            nextChoices.add(new Point(cur.x, cur.y + 1));
        }
        if(cur.x+1 >= 0 && cur.x+1 <= end.x) {
            nextChoices.add(new Point(cur.x + 1, cur.y));
        }
        for(Point choice:nextChoices) {
            doBacktracking(choice, end);
        }
    }

    public int uniquePaths(int m, int n) {
        Point cur = new Point(0,0);
        Point end = new Point(m-1,n-1);
        doBacktracking(cur, end);
        return paths;
    }
    */

    public int uniquePaths(int m, int n) {
        int[] s = new int[m+1];
        s[0] = 0;
        for(int i=1; i<=m; ++i) s[i] = 1;
        for(int j=1; j<n; ++j) {
            for(int i=1; i<=m; ++i) {
                s[i] += s[i-1];
            }
        }
        return s[m];
    }

    public static void main(String[] args) {
        LC_62_UniquePaths inst = new LC_62_UniquePaths();
        System.out.println(inst.uniquePaths(1,1));
    }
}
