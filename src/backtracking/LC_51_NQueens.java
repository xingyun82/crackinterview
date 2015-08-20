package backtracking;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by xingyun on 15/2/17.
 */
public class LC_51_NQueens {

    private int nSolutions = 0;

    // check board[k][m] is right step
    public boolean isRightStep(char[][] board, int n, int k, int m) {
        for (int i=0; i<k; ++i) {
            for (int j=0; j<n; ++j) {
                if (board[i][j] == 'Q')
                if (j == m || Math.abs(k-i) == Math.abs(j-m)) {
                    return false;
                }
            }
        }
        return true;
    }

    // try the kth step
    public void tryQueen(List<String[]> solves, char[][] board, int n, int k) {
        // Find a solution
        if (k == n) {
            String[] solve = new String[n];
            for (int i=0; i<n; ++i) {
                solve[i] = new String(board[i]);
            }
            solves.add(solve);
            nSolutions++;
            return;
        }
        for (int i=0; i<n; ++i) {
            board[k][i] = 'Q';
            // if this step is right step
            if (isRightStep(board, n, k, i)) {
                tryQueen(solves, board, n, k + 1);
            }
            // Clear previous step
            board[k][i] = '.';
        }
    }



    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        char[][] board = new char[n][];
        for (int i=0; i<n; ++i) {
            board[i] = new char[n];
            for (int j=0; j<n; ++j) {
                board[i][j] = '.';
            }
        }
        tryQueen(res, board, n, 0);
        return res;
    }

    public int solveNQueens2(int n) {
        List<String[]> res = new ArrayList<String[]>();
        char[][] board = new char[n][];
        for (int i=0; i<n; ++i) {
            board[i] = new char[n];
            for (int j=0; j<n; ++j) {
                board[i][j] = '.';
            }
        }
        tryQueen(res, board, n, 0);
        return nSolutions;
    }



    public static void main(String[] args) {
        LC_51_NQueens inst = new LC_51_NQueens();
        /*
        List<String[]> res = inst.solveNQueens(6);
        for(int i=0;i<res.size();++i) {
            for(int j=0;j<res.get(i).length; ++j) {
                System.out.println(res.get(i)[j]);
            }
            System.out.println();
        }
        */
        System.out.println(inst.solveNQueens2(6));
    }
}
