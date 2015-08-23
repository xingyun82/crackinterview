package dp;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.

 * Created by xingyun on 15/8/21.
 */
public class LC_221_MaximalSquare {

    // main idea:
    // l[i][j] represent the edge length of largest square area
    // l[i][j] = min(l[i-1][j-1], l[i-1][j], l[i][j-1])+1 || 0
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] l = new int[m][n];
        int maxL = 0;
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                if(matrix[i][j] == '1') {
                    if(i==0 || j==0) l[i][j] = 1;
                    else {
                        l[i][j] = Math.min(Math.min(l[i-1][j-1], l[i-1][j]), l[i][j-1]) + 1;
                    }
                }
                maxL = Math.max(maxL, l[i][j]);
            }
        }
        return maxL*maxL;
    }
}
