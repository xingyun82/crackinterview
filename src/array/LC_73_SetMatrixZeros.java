package array;

import java.util.*;
/**
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 click to show follow up.

 Follow up:
 Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?
 * Created by xingyun on 15/8/19.
 */
public class LC_73_SetMatrixZeros {

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        Set<Integer> zeroRows = new HashSet<Integer>();
        Set<Integer> zeroCols = new HashSet<Integer>();

        for(int i=0; i<matrix.length; ++i) {
            for (int j=0; j<matrix[0].length; ++j) {
                if(matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }
        for(int i:zeroRows) {
            for(int j=0; j<matrix[0].length; ++j) {
                matrix[i][j] = 0;
            }
        }
        for(int j:zeroCols) {
            for(int i=0; i<matrix.length; ++i) {
                matrix[i][j] = 0;
            }
        }
    }
}
