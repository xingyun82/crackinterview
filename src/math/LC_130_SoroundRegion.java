package math;

import common.Point;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

/**
 *
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X

 * Created by xingyun on 15/7/5.
 */
public class LC_130_SoroundRegion {

    // Union Find method
    int[] unionSet; // union find set
    boolean[] hasEdgeO; // whether an union has an 'O' which is on the edge of the matrix

    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;

        // init, every char itself is an union
        int height = board.length, width = board[0].length;
        unionSet = new int[height * width];
        hasEdgeO = new boolean[unionSet.length];
        for(int i = 0;i<unionSet.length; i++) unionSet[i] = i;
        for(int i = 0;i<hasEdgeO.length; i++){
            int x = i / width, y = i % width;
            hasEdgeO[i] = (board[x][y] == 'O' && (x==0 || x==height-1 || y==0 || y==width-1));
        }

        // iterate the matrix, for each char, union it + its upper char + its right char if they equals to each other
        for(int i = 0;i<unionSet.length; i++){
            int x = i / width, y = i % width, up = x - 1, right = y + 1;
            if(up >= 0 && board[x][y] == board[up][y]) union(i,i-width);
            if(right < width && board[x][y] == board[x][right]) union(i,i+1);
        }

        // for each char in the matrix, if it is an 'O' and its union doesn't has an 'edge O', the whole union should be setted as 'X'
        for(int i = 0;i<unionSet.length; i++){
            int x = i / width, y = i % width;
            if(board[x][y] == 'O' && !hasEdgeO[findSet(i)])
                board[x][y] = 'X';
        }
    }

    private void union(int x,int y){
        int rootX = findSet(x);
        int rootY = findSet(y);
        // if there is an union has an 'edge O',the union after merge should be marked too
        boolean hasEdgeO = this.hasEdgeO[rootX] || this.hasEdgeO[rootY];
        unionSet[rootX] = rootY;
        this.hasEdgeO[rootY] = hasEdgeO;
    }

    private int findSet(int x){
        if(unionSet[x] == x) return x;
        unionSet[x] = findSet(unionSet[x]);
        return unionSet[x];
    }

    /*
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
    */


    private void print(char[][] board) {
        for(int i=0;i<board.length;++i) {
            for(int j=0;j<board[0].length;++j) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[][] board = new char[4][];
        board[0] = new String("XXXX").toCharArray();
        board[1] = new String("XOOX").toCharArray();
        board[2] = new String("XXOX").toCharArray();
        board[3] = new String("XOXX").toCharArray();

        LC_130_SoroundRegion inst = new LC_130_SoroundRegion();
        inst.print(board);
        inst.solve(board);

        inst.print(board);


    }


}
