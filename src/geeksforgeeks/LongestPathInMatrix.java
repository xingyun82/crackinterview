package geeksforgeeks;

/**
 *
 * Find length of the longest consecutive path from a given starting character
 Given a matrix of characters. Find length of the longest path from a given character,
 such that all characters in the path are consecutive to each other,
 i.e., every character in path is next to previous in alphabetical order.
 It is allowed to move in all 8 directions from a cell.

 Example

 Input: mat[][] = { {a, c, d},
 {h, b, e},
 {i, g, f}}
 Starting Point = 'e'

 Output: 5
 If starting point is 'e', then longest path with consecutive
 characters is "e f g h i".

 Input: mat[R][C] = { {b, e, f},
 {h, d, a},
 {i, c, a}};
 Starting Point = 'b'

 Output: 1
 'c' is not present in all adjacent cells of 'b'


 * Created by xingyun on 15/8/22.
 */
public class LongestPathInMatrix {

    int maxLen = 0;

    int[] deltax = new int[]{-1, -1, -1,  0, 0,  1, 1, 1};
    int[] deltay = new int[]{-1,  0,  1, -1, 1, -1, 0, 1};

    // main idea: backtracking
    private void backtracking(boolean[][] visited, int preLen, char[][] matrix, int i, int j, char pre) {
        // end case
        if(i<0 || i>= matrix.length || j < 0 || j >= matrix[0].length
                || visited[i][j] || (pre != 0 && pre != matrix[i][j]+1)) {
            maxLen = Math.max(maxLen, preLen);
            return;
        }
        // visit
        visited[i][j] = true;
        // next step
        for(int k=0; k<8; ++k) {
            backtracking(visited, preLen+1, matrix, i+deltax[k], j+deltay[k], matrix[i][j]);
        }
        // backtrack
        visited[i][j] = false;
    }

    public int longestPath(char[][] matrix, char s) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                if(matrix[i][j] == s) {
                    // clear visited
                    backtracking(visited, 0, matrix, i, j, (char)0);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[3][3];
        char s = 'e';
        matrix[0] = new String("acd").toCharArray();
        matrix[1] = new String("hbe").toCharArray();
        matrix[2] = new String("igf").toCharArray();

        LongestPathInMatrix inst = new LongestPathInMatrix();
        System.out.println(inst.longestPath(matrix, s));
    }
}
