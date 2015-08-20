package math;

/**
 * Created by xingyun on 15/7/31.
 */
public class LC_240_Search2DMatrixII {

    private boolean doSearch(int[][] matrix, int startx, int starty, int endx, int endy, int target) {
        if(startx > endx || starty > endy) return false;
        if(startx == endx && starty == endy) return matrix[startx][starty] == target;
        if(matrix[startx][starty] > target || matrix[endx][endy] < target) return false;
        int midx = (startx+endx)>>>1;
        int midy = (starty+endy)>>>1;
        if(matrix[midx][midy] == target) return true;
        if(matrix[midx][midy] > target) {
            return doSearch(matrix, startx, starty, midx-1, midy-1, target) ||
                    doSearch(matrix, startx, midy, midx-1, endy, target) ||
                    doSearch(matrix, midx, starty, endx, midy-1, target);
        } else {
            return doSearch(matrix, midx+1, midy+1, endx, endy, target) ||
                    doSearch(matrix, startx, midy+1, midx, endy, target) ||
                    doSearch(matrix, midx+1, starty, endx, midy, target);
        }
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        return doSearch(matrix, 0, 0, matrix.length-1, matrix[0].length-1, target);
    }

    public static void main(String[] args) {
        LC_240_Search2DMatrixII inst = new LC_240_Search2DMatrixII();
        int[][] matrix = new int[1][2];
        matrix[0] = new int[]{-1, 3};

    }
}
