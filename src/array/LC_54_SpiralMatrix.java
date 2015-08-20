package array;

import java.util.*;
/**
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 * Created by xingyun on 15/8/19.
 */
public class LC_54_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int row_st = 0, row_ed = m-1;
        int col_st = 0, col_ed = n-1;
        while(true) {
            for (int i=col_st;i<=col_ed;++i) {
                res.add(matrix[row_st][i]);
            }
            row_st++;
            if(col_st > col_ed || row_st > row_ed) break;
            for (int i=row_st;i<=row_ed;++i) {
                res.add(matrix[i][col_ed]);
            }
            col_ed--;
            if(col_st > col_ed || row_st > row_ed) break;
            for (int i=col_ed;i>=col_st;i--) {
                res.add(matrix[row_ed][i]);
            }
            row_ed--;
            if(col_st > col_ed || row_st > row_ed) break;
            for (int i=row_ed;i>=row_st;i--) {
                res.add(matrix[i][col_st]);
            }
            col_st++;
            if(col_st > col_ed || row_st > row_ed) break;
        }
        return res;
    }
}
