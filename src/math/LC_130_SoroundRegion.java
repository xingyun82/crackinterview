package math;

import common.Point;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

/**
 * Created by xingyun on 15/7/5.
 */
public class LC_130_SoroundRegion {



    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int N = board.length;
        int M = board[0].length;
        boolean[][] visit = new boolean[N][M];
        Stack<Point> stack = new Stack<Point>();
        for (int i=0; i<N; ++i) {
            for (int j=0; j<M; ++j) {
                if(board[i][j] == 'O' && visit[i][j] == false) {
                    List<Point> cluster = new ArrayList<Point>();
                    boolean captured = true; // if any point is on the edge, then the whole cluster is not captured
                    stack.push(new Point(i, j));
                    while(!stack.empty()) { // get the cluster
                        Point p = stack.pop();
                        cluster.add(p);
                        visit[p.x][p.y] = true;
                        if(p.x-1<0) captured = false;
                        else if (board[p.x-1][p.y] == 'O' && !visit[p.x-1][p.y]) {
                            stack.push(new Point(p.x-1, p.y));
                        }
                        if(p.x+1>=N) captured = false;
                        else if(board[p.x+1][p.y] == 'O' && !visit[p.x+1][p.y]) {
                            stack.push(new Point(p.x+1, p.y));
                        }
                        if(p.y-1<0) captured = false;
                        else if(board[p.x][p.y-1] == 'O' && !visit[p.x][p.y-1]) {
                            stack.push(new Point(p.x, p.y-1));
                        }
                        if(p.y+1>=M) captured = false;
                        else if(board[p.x][p.y+1] == 'O' && !visit[p.x][p.y+1]) {
                            stack.push(new Point(p.x, p.y+1));
                        }
                    }
                    if(captured) {
                        for(Point p:cluster) {
                            board[p.x][p.y] = 'X';
                        }
                    }
                }
                visit[i][j] = true;
            }
        }
    }

    private void print(char[][] board) {
        for(int i=0;i<board.length;++i) {
            for(int j=0;j<board[0].length;++j) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[3][];
        board[0] = new String("XXX").toCharArray();
        board[1] = new String("XOX").toCharArray();
        board[2] = new String("XXX").toCharArray();

        LC_130_SoroundRegion inst = new LC_130_SoroundRegion();
        inst.print(board);
        inst.solve(board);
        inst.print(board);


    }


}
