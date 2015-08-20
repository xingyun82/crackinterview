package backtracking;

/**
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

 Empty cells are indicated by the character '.'.

 You may assume that there will be only one unique solution.


 A sudoku puzzle...


 ...and its solution numbers marked in red.
 * Created by xingyun on 15/3/7.
 */
public class LC_37_Sudoku {

    void solveSudoku(char[][] board) {
        doSolve(board, 0);
    }

    boolean doSolve(char[][] board, int pos) {
        if (pos >= 81) return true;
        int i = pos / 9, j = pos % 9;
        if (board[i][j] != '.') {
            return doSolve(board, pos + 1);
        } else {
            for (char c = '1'; c <= '9'; c++) {
                if (!isInRow(board, i, c) && !isInCol(board, j, c) && !isInBox(board, i, j, c)) {
                    board[i][j] = c;
                    if (doSolve(board, pos+1)) return true;
                    else board[i][j] = '.';
                }
            }
            return false;
        }
    }

    boolean isInRow(char[][] board, int i, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c) return true;
        }
        return false;
    }

    boolean isInCol(char[][] board, int j, char c) {
        for (int k=0; k<9; k++) {
            if (board[k][j] == c) return true;
        }
        return false;
    }

    boolean isInBox(char[][] board, int i, int j, char c) {
        int row = i/3, col = j/3;
        for (int m=3*row; m<3*(row+1); m++)
            for (int n=3*col; n<3*(col+1); n++)
                if (board[m][n] == c) return true;
        return false;
    }

    public static void main(String[] args) {
        String[] boardStr = new String[]{
                "53..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79"
        };
        char[][] board = new char[9][9];
        for (int i=0;i<9;++i) {
            for (int j=0;j<9;++j) {
                board[i][j] = boardStr[i].charAt(j);
            }
        }
        LC_37_Sudoku inst = new LC_37_Sudoku();

        long start = System.currentTimeMillis();
        inst.solveSudoku(board);
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end-start));

        for (int i=0;i<9;++i) {
            for (int j=0;j<9;++j) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


}
