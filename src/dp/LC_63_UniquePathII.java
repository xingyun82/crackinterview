package dp;

/**
 *
 * Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100.

 * Created by xingyun on 15/7/27.
 */
public class LC_63_UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        int[] s = new int[m];
        s[0] = 1;
        boolean fisrtColHasObstacle = false;
        for(int i=1; i<m; ++i) {
            if(obstacleGrid[i][0] == 0 && !fisrtColHasObstacle) s[i] = 1;
            else if(obstacleGrid[i][0] == 1) { s[i] = 0; fisrtColHasObstacle = true; }
            else if(fisrtColHasObstacle) s[i] = 0;
        }

        boolean firstRowHasObstacle = false;
        for(int j=1; j<n; ++j) {
            if(obstacleGrid[0][j] == 0 && !firstRowHasObstacle) s[0] = 1;
            else if(obstacleGrid[0][j] == 1) { s[0] = 0; firstRowHasObstacle = true; }
            else if(firstRowHasObstacle) s[0] = 0;

            for (int i=1; i<m; ++i) {
                if(obstacleGrid[i][j] == 1) s[i] = 0;
                else if(obstacleGrid[i][j-1] != 1 && obstacleGrid[i-1][j] != 1) s[i] += s[i-1];
                else if(obstacleGrid[i][j-1] == 1) s[i] = s[i-1];
                else if(obstacleGrid[i-1][j] == 1) s[i] = s[i];
            }

        }
        return s[m-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[4][3];
        obstacleGrid[0] = new int[]{0,0,1,0};
        obstacleGrid[1] = new int[]{0,1,0,0};
        obstacleGrid[2] = new int[]{0,0,1,0};
        obstacleGrid[3] = new int[]{0,1,0,0};

        LC_63_UniquePathII inst = new LC_63_UniquePathII();
        System.out.println(inst.uniquePathsWithObstacles(obstacleGrid));
    }
}
