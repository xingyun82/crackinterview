package dp;

import java.util.*;
/**
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 *
 * Created by xingyun on 15/8/19.
 */
public class LC_85_MaxRectangle {

    /**
     * Main idea is compute the largest rectangle histogram for each row of matrix
     * then, get the max rectangle of all rows
     */
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] histo = new int[cols+1];
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<rows; ++i) {
            // initial histo
            for(int j=0; j<cols;++j) {
                histo[j] = (matrix[i][j] == '0'?0:(histo[j]+1));
            }
            // get max rectangle of the histo
            int j = 0;
            int h = 0;
            while(j<=cols) {
                if(stack.empty() || histo[stack.peek()] < histo[j]) {
                    stack.push(j++);
                } else {
                    int bar = stack.pop();
                    int tmpArea = (stack.empty()?j:(j-stack.peek()-1))*histo[bar];
                    maxArea = Math.max(maxArea, tmpArea);
                }
            }
            stack.pop();
        }
        return maxArea;
    }

}
