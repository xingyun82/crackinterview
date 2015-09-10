package hackerrank;

import java.util.*;
/**
 * Created by xingyun on 15/8/25.
 */
public class RotateMatrix {

    private static void reverse(int[] nums, int l, int h) {
        int tmp = 0;
        while(l<h) {
            tmp = nums[l];
            nums[l] = nums[h];
            nums[h] = tmp;
            l++;
            h--;
        }
    }

    private static void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, nums.length-1-k);
        reverse(nums, nums.length-k, nums.length-1);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // read input
        Scanner sin = new Scanner(System.in);
        int m = sin.nextInt();
        int n = sin.nextInt();
        int k = sin.nextInt();
        int[][] matrix = new int[m][n];
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                matrix[i][j] = sin.nextInt();
            }
        }
        //
        int row_min = 0, row_max = m-1;
        int col_min = 0, col_max = n-1;
        while(row_min <= row_max && col_min <= col_max) {
            int c_row_min = row_min;
            int c_row_max = row_max;
            int c_col_min = col_min;
            int c_col_max = col_max;

            int len = 0;
            if(row_max > row_min && col_max > col_min) {
                 len = 2 * (row_max - row_min + 1) + 2 * (col_max - col_min + 1) - 4;
            } else {
                if(row_max == row_min) len = col_max - col_min + 1;
                else if(col_max == col_min) len = row_max - row_min + 1;
            }

            if(len == 0) break;
            int[] nums = new int[len];
            // copy matrix circle to array
            int idx = 0;
            for(int i=col_min; i<=col_max; ++i) {
                nums[idx++] = matrix[row_min][i];
            }

            row_min++;
            for(int i=row_min; i<=row_max; ++i) {
                nums[idx++] = matrix[i][col_max];
            }
            col_max--;

            for(int i=col_max; i>=col_min && row_min <= row_max; --i) {
                nums[idx++] = matrix[row_max][i];
            }
            row_max--;

            for(int i=row_max; i>=row_min && col_min <= col_max; --i) {
                nums[idx++] = matrix[i][col_min];
            }
            col_min++;

            // roate array
            rotate(nums, k);
            // assign roated array to matrix
            idx = 0;
            for(int i=c_col_min; i<=c_col_max; ++i) {
                matrix[c_row_min][i] = nums[idx++];
            }
            c_row_min++;

            for(int i=c_row_min; i<=c_row_max; ++i) {
                matrix[i][c_col_max] = nums[idx++];

            }
            c_col_max--;

            for(int i=c_col_max; i>=c_col_min && c_row_min <= c_row_max; --i){
                matrix[c_row_max][i] = nums[idx++];

            }
            c_row_max--;

            for(int i=c_row_max; i>=c_row_min && c_col_min <= c_col_max; --i) {
                matrix[i][c_col_min] = nums[idx++];
            }
            c_col_min++;

        }
        // output matrix
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n-1; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(matrix[i][n-1]);
        }

    }

}
