package array;

/**
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 * Created by xingyun on 15/7/31.
 */
public class LC_74_Search2DMatrix {

    public boolean doSearch(int[][] matrix, long low, long high, int target) {
        if(low > high) return false;
        long mid = (low+high) >>> 1;
        int row = (int)(mid)/matrix[0].length;
        int col = (int)mid%matrix[0].length;
        if(matrix[row][col] == target) return true;
        if(matrix[row][col] < target) return doSearch(matrix, mid+1, high, target);
        return doSearch(matrix, low, mid-1, target);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        return doSearch(matrix, 0, matrix.length*matrix[0].length-1, target);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[1][1];
        matrix[0][0] = 1;
        LC_74_Search2DMatrix inst = new LC_74_Search2DMatrix();
        System.out.println(inst.searchMatrix(matrix, 0));
    }
}
