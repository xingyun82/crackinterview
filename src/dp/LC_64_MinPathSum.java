package dp;

/**
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 * Created by xingyun on 15/7/27.
 */
public class LC_64_MinPathSum {

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        for(int i=1; i<m; ++i) {
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }
        for(int i=1; i<n; ++i) {
            sum[0][i] = sum[0][i-1] + grid[0][i];
        }
        for(int i=1; i<n; ++i) {
            for (int j=1; j<m; ++j) {
                sum[j][i] = Math.min(sum[j-1][i], sum[j][i-1]) + grid[j][i];
            }
        }
        return sum[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[2][3];
        grid[0] = new int[]{1,2,5};
        grid[1] = new int[]{3,2,1};
        LC_64_MinPathSum inst = new LC_64_MinPathSum();
        System.out.println(inst.minPathSum(grid));

    }
}
