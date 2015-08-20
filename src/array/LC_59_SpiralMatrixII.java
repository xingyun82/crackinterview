package array;

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

 * Created by xingyun on 15/7/26.
 */
public class LC_59_SpiralMatrixII {

    /* 纯数学定位方法，先计算四个定点的位置，然后顺时针构造四边

    public int[][] generateMatrix(int n) {
        if(n<1) {
            return new int[0][];
        }
        int[][] matrix = new int[n][n];
        int s = 1;
        int k = 0; // to locate start point of each edge (k, k), (k, k+i), (k+i, k+i), (k+i, k)
        for(int i=n-1; i>=0; i=i-2) { // i is edge lenth
            matrix[k][k] = s++;
            for(int j=1; j<i; ++j) {
                matrix[k][k + j] = s++;
            }
            for(int j=0; j<i; ++j) {
                matrix[k + j][k + i] = s++;
            }
            for(int j=0; j<i; ++j) {
                matrix[k + i][k + i - j] = s++;
            }
            for(int j=0; j<i; ++j) {
                matrix[k + i - j][k] = s++;
            }
            k++;
        }
        return matrix;
    }
    */

    // 下面这种方法更容易理解
    public int[][] generateMatrix(int n) {
        if(n<1) return new int[0][0];
        int[][] matrix = new int[n][n];
        int colmin = 0, colmax = n-1, rowmin = 0, rowmax = n-1;
        int s = 1;
        while(colmin <= colmax && rowmin <= rowmax) {
            for(int i=colmin; i<=colmax; ++i) {
                matrix[rowmin][i] = s++;
            }
            rowmin++;

            for(int i=rowmin; i<=rowmax; ++i) {
                matrix[i][colmax] = s++;
            }
            colmax--;

            for(int i=colmax; i>=colmin; --i) {
                matrix[rowmax][i] = s++;
            }
            rowmax--;

            for(int i=rowmax; i>=rowmin; --i) {
                matrix[i][colmin] = s++;
            }
            colmin++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        LC_59_SpiralMatrixII inst = new LC_59_SpiralMatrixII();
        int[][] matrix = inst.generateMatrix(3);
        for(int i=0; i<matrix.length; ++i) {
            for(int j=0; j<matrix[0].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
