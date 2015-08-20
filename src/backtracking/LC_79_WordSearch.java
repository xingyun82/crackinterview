package backtracking;


/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 *
 * Created by xingyun on 15/2/18.
 */

import java.util.List;
import java.util.ArrayList;

public class LC_79_WordSearch {


    class Cell {
        public int i;
        public int j;
        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }

    public boolean isOK(char[][] board, List<Cell> steps, String word) {
        if (steps.size() > word.length()) return false;
        Cell cell = steps.get(steps.size()-1);
        // step不能重复
        for (int i=0; i<steps.size()-2; ++i) {
            if (cell.i == steps.get(i).i && cell.j == steps.get(i).j) return false;
        }
        //
        if (board[cell.i][cell.j] != word.charAt(steps.size()-1)) return false;
        return true;
    }


    public void tryStep(List<List<Cell>> res, char[][] board, List<Cell> steps, String word, int i, int j) {
        if (steps.size() == word.length()) {

            for (int m=0; m<res.size(); ++m) {
                int len = 0;
                for (int n=0; n<res.get(m).size(); ++n) {
                    if (res.get(m).get(n).i == steps.get(n).i && res.get(m).get(n).j == steps.get(n).j) {
                        len++;
                    }
                }
                if(len == steps.size()) return;
            }
            /*
            for (Cell c:steps) {
                System.out.println(c.i + "," + c.j);
            }
            System.out.println();
            */
            List<Cell> ainst = new ArrayList<Cell>(steps.size());
            ainst.addAll(steps);
            res.add(ainst);
            return;
        }
        Cell c = new Cell(i, j);
        steps.add(c);
        if (isOK(board, steps, word)) {
            if (i-1>=0) {
                tryStep(res, board, steps, word, i - 1, j);
            }
            if (i+1<board.length) {
                tryStep(res, board, steps, word, i+1, j);
            }
            if (j-1>=0) {
                tryStep(res, board, steps, word, i, j-1);
            }
            if (j+1<board[i].length) {
                tryStep(res, board, steps, word, i, j+1);
            }
        }
        steps.remove(c);

    }

    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; ++i) {
            for (int j=0; j<board[i].length; ++j) {
                List<List<Cell>> res = new ArrayList<List<Cell>>();
                List<Cell> steps = new ArrayList<Cell>();
                tryStep(res, board, steps, word, i, j);
                if (res.size() > 0) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        char[][] board = new char[3][4];
        board[0] = new String("ABCE").toCharArray();
        board[1] = new String("SFCS").toCharArray();
        board[2] = new String("ADEE").toCharArray();
        LC_79_WordSearch inst = new LC_79_WordSearch();
        System.out.println(inst.exist(board, "AB"));
    }
}
