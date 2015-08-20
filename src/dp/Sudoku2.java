package dp; /**
 * Created by xingyun on 15/3/7.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class Sudoku2 {
    class CellPoint {
        int row;
        int col;
        public CellPoint(int row, int col) {
            this.row = row;
            this.col = col;
        }
        public boolean equals(Object x) {
            if (this == x) return true;
            if (!(x instanceof CellPoint)) return false;
            return row == ((CellPoint)x).row && col == ((CellPoint)x).col;
        }

        public int hashCode() {
            return row*37+col;
        }
    }


    class BoardMapInfo {
        List<CellPoint>  emptyCells = new ArrayList<CellPoint>();;
        HashMap<Integer, HashSet<Character>> rowCharMap = new HashMap<Integer, HashSet<Character>>();
        HashMap<Integer, HashSet<Character>> colCharMap = new HashMap<Integer, HashSet<Character>>();
        HashMap<Integer, HashSet<Character>> bigCellCharMap = new HashMap<Integer, HashSet<Character>>();
    }

    private int getBigCellIndex(int row, int col) {
        return row/3*3 + col/3;
    }

    private BoardMapInfo genCellInfoMap(char[][] board) {
        BoardMapInfo boardMapInfo = new BoardMapInfo();
        int rows = board.length;
        int cols = board[0].length;
        for (int i=0;i<9;i++) {
            boardMapInfo.bigCellCharMap.put(i, new HashSet<Character>());
        }
        for (int i=0;i<rows;++i) {
            for (int j=0;j<cols;++j) {
                if (board[i][j] != '.') {
                    // fill row char map
                    if(boardMapInfo.rowCharMap.containsKey(i)) {
                        boardMapInfo.rowCharMap.get(i).add(board[i][j]);
                    } else {
                        HashSet<Character> charSet = new HashSet<Character>();
                        charSet.add(board[i][j]);
                        boardMapInfo.rowCharMap.put(i, charSet);
                    }
                    // fill col char map
                    if(boardMapInfo.colCharMap.containsKey(j)) {
                        boardMapInfo.colCharMap.get(j).add(board[i][j]);
                    } else {
                        HashSet<Character> charSet = new HashSet<Character>();
                        charSet.add(board[i][j]);
                        boardMapInfo.colCharMap.put(j, charSet);
                    }
                    // fill 3*3 char map
                    int bigCellIdx = getBigCellIndex(i, j);
                    if (boardMapInfo.bigCellCharMap.containsKey(bigCellIdx)) {
                        boardMapInfo.bigCellCharMap.get(bigCellIdx).add(board[i][j]);;
                    } else {
                        HashSet<Character> charSet = new HashSet<Character>();
                        charSet.add(board[i][j]);
                        boardMapInfo.bigCellCharMap.put(bigCellIdx, charSet);
                    }
                } else {
                    CellPoint cell = new CellPoint(i, j);
                    boardMapInfo.emptyCells.add(cell);
                }
            }
        }
        // generate contraint map
        for (int i=0;i<rows;++i) {
            for (int j=0;j<cols;++j) {
                if (board[i][j] == '.') {
                    int constrainCount = 0;
                    if(boardMapInfo.rowCharMap.containsKey(i)) {
                        constrainCount += boardMapInfo.rowCharMap.get(i).size();
                    }
                    if(boardMapInfo.colCharMap.containsKey(j)) {
                        constrainCount += boardMapInfo.colCharMap.get(j).size();
                    }
                    int bigCellIdx = getBigCellIndex(i, j);
                    if(boardMapInfo.bigCellCharMap.containsKey(bigCellIdx)) {
                        constrainCount += boardMapInfo.bigCellCharMap.get(bigCellIdx).size();
                    }
                }
            }
        }
        return boardMapInfo;
    }

    public void solveSudoku(char[][] board) {
        BoardMapInfo boardMapInfo = genCellInfoMap(board);
        solveSudoku(board, boardMapInfo);
    }

    public void updateBoardInfoMap(char[][] board, BoardMapInfo boardMapInfo, CellPoint cell, char candidate) {
        boardMapInfo.emptyCells.remove(cell);
        char c = board[cell.row][cell.col];
        boardMapInfo.rowCharMap.get(cell.row).remove(c);
        boardMapInfo.colCharMap.get(cell.col).remove(c);
        int bigCellIdx = getBigCellIndex(cell.row, cell.col);
        boardMapInfo.bigCellCharMap.get(bigCellIdx).remove(c);

        board[cell.row][cell.col] = candidate;
        boardMapInfo.rowCharMap.get(cell.row).add(candidate);
        boardMapInfo.bigCellCharMap.get(bigCellIdx).add(candidate);
        boardMapInfo.colCharMap.get(cell.col).add(candidate);
    }

    public void removeBoardInfoMap(char[][] board, BoardMapInfo boardMapInfo, CellPoint cell) {
        boardMapInfo.emptyCells.add(cell);
        char c = board[cell.row][cell.col];
        boardMapInfo.rowCharMap.get(cell.row).remove(c);
        boardMapInfo.colCharMap.get(cell.col).remove(c);
        int bigCellIdx = getBigCellIndex(cell.row, cell.col);
        boardMapInfo.bigCellCharMap.get(bigCellIdx).remove(c);
        board[cell.row][cell.col] = '.';
    }

    public boolean solveSudoku(char[][] board, BoardMapInfo boardMapInfo) {
//	if board is ok, return result
//	order emptry cells by constraints
//	try most constraints cell
//		for num: possible nums
//			fill the number
//			update cell constraints map
//			solveSudoku(char[][] board, res)

        if(boardMapInfo.emptyCells.size() == 0) {
            return true;
        }
        CellPoint cell = boardMapInfo.emptyCells.get(0);

        HashSet<Character> constraintChars = new HashSet<Character>();
        constraintChars.addAll(boardMapInfo.rowCharMap.get(cell.row));
        constraintChars.addAll(boardMapInfo.colCharMap.get(cell.col));
        int bigCellIdx = getBigCellIndex(cell.row, cell.col);
        constraintChars.addAll(boardMapInfo.bigCellCharMap.get(bigCellIdx));
        boolean hasNext = false;
        for (int i=1;i<=9;i++) {
            char candidateChar = (char)('0'+i);
            if (!constraintChars.contains(candidateChar)) {
                hasNext = true;
                updateBoardInfoMap(board, boardMapInfo, cell, candidateChar);
                if(solveSudoku(board, boardMapInfo)) {
                    return true;
                }
            }
        }
        if (hasNext) {
            removeBoardInfoMap(board, boardMapInfo, cell);
        }
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
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                board[i][j] = boardStr[i].charAt(j);
            }
        }
        Sudoku2 inst = new Sudoku2();

        long start = System.currentTimeMillis();
        inst.solveSudoku(board);
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start));

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
