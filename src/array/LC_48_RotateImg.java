package array;

/**
 *
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 * Created by xingyun on 15/3/10.
 */
public class LC_48_RotateImg {


    public void rotate(int[][] matrix) {
        int n = matrix.length-1;
        for (int k=0;k<=n;k++) {
            for (int i=k;i<=n-1-k;i++) {
                int tmp = matrix[k][i];
                matrix[k][i] = matrix[n-i][k];
                matrix[n-i][k] = matrix[n-k][n-i];
                matrix[n-k][n-i] = matrix[i][n-k];
                matrix[i][n-k] = tmp;
            }
        }
    }

    /*
    public void rotate(int[][] matrix) {
        //Collections.sort(matrix, Collections.reverseOrder());
    }
    */


    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1,2,3};
        matrix[1] = new int[]{4,5,6};
        matrix[2] = new int[]{7,8,9};
        LC_48_RotateImg inst = new LC_48_RotateImg();
        inst.rotate(matrix);
        for (int i=0;i<matrix.length;++i) {
            for (int j=0; j<matrix[i].length;++j) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
