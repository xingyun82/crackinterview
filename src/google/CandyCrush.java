package google;

import java.util.*;
/**
 *
 * Design a algorithm to initialize the board of Candy Crush Saga. With M x N
 board, Q types of candies. (Rules: no 3 for run after initialization, must
 contain at least one valid move at the beginning)

 * Created by xingyun on 10/4/15.
 */
public class CandyCrush {

    public final static int[][] dirs = {
            {-1, 0, 0, 1},
            {0, -1, 1, 0}
    };

    class Point {
        int x;
        int y;

        Point(int i, int j) {this.x = i; this.y = j;}
    }

    // idea: first choose 4 position, suppose is: 1, 1, 2
    //                                                  1
    // then, spread to other sugars(it will cause conflict)
    // try backtrack


    public boolean backtrack(int[][] board, Point p, Point fix, int q, int count) {
        int M = board.length;
        int N = board[0].length;
        if(count == M*N-4) return true;

        // check if cur point can be go through
        int x = p.x;
        int y = p.y;

        if((x == fix.x && y >= fix.y && y<= fix.y+2 )||
                (x == fix.x +1 && y == fix.y+2)) {
            // go next step
            if(y + 1 == N) {
                return backtrack(board, new Point(x+1, 0), fix, q, count);

            } else {
                return backtrack(board, new Point(x, y+1), fix, q, count);
            }
        }

        if(x >=0 && x < M && y >=0 && y < N && board[x][y] == 0) {
            int[] cand = new int[q];
            for(int i=0; i<q; ++i) cand[i] = i+1;

            if(x-2>=0 && board[x-1][y] == board[x-2][y] && board[x-1][y] != 0) {
                cand[board[x-1][y]-1] = 0;
            }
            if(x+2 < M && board[x+1][y] == board[x+2][y] && board[x+1][y] != 0) {
                cand[board[x+1][y]-1] = 0;
            }
            if(y-2>=0 && board[x][y-1] == board[x][y-2] && board[x][y-1] != 0) {
                cand[board[x][y-1]-1] = 0;
            }
            if(y+2 <N && board[x][y+1] == board[x][y+2] && board[x][y+1] != 0) {
                cand[board[x][y+1]-1] = 0;
            }
            if(x-1 >=0 && x+1 < M && board[x-1][y] == board[x+1][y] && board[x-1][y] != 0) {
                cand[board[x+1][y]-1] = 0;
            }
            if(y-1>=0 && y+1 < N && board[x][y-1] == board[x][y+1] && board[x][y-1] != 0) {
                cand[board[x][y+1]-1] = 0;
            }
//            Random rnd = new Random();
//            int v = rnd.nextInt(last+1);
//            board[nx][ny] = cand[v];
            for(int i=0; i<q; ++i) {
                if(cand[i] == 0) continue;
                board[x][y] = cand[i];
                // go next step
                if(y+1 == N) {
                    if(backtrack(board, new Point(x+1, 0), fix, q, count+1)) return true;
                } else {
                    if(backtrack(board, new Point(x, y+1), fix, q, count+1)) return true;
                }
            }
        }

        return false;

    }

    public Point initialize(int[][] board, int q) {
        int M = board.length;
        int N = board[0].length;

        // generate initial valid move
        Random r = new Random();
        int x = r.nextInt(M-1);
        int y = r.nextInt(N-2);
        board[x][y] = 1;
        board[x][y+1] = 1;
        board[x][y+2] = 2;
        board[x+1][y+2] = 1;

        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(x, y));
        queue.offer(new Point(x, y+1));
        queue.offer(new Point(x, y+2));
        queue.offer(new Point(x+1, y+2));

        // fill out rest point
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int k=0; k<4; k++) {
                int nx = p.x + dirs[0][k];
                int ny = p.y + dirs[1][k];
                if(nx >=0 && nx < M && ny >=0 && ny < N && board[nx][ny] == 0) {
                    int[] cand = new int[q];
                    int last = q - 1;
                    for(int i=0; i<q; ++i) cand[i] = i+1;
                    if(nx-2>=0 && board[nx-1][ny] == board[nx-2][ny] && board[nx-1][ny] != 0) {
                        cand[board[nx-1][ny]-1] = cand[last];
                        cand[last--] = 0;
                    }
                    if(nx+2 < M && board[nx+1][ny] == board[nx+2][ny] && board[nx+1][ny] != 0) {
                        cand[board[nx+1][ny]-1] = cand[last];
                        cand[last--] = 0;
                    }
                    if(ny-2>=0 && board[nx][ny-1] == board[nx][ny-2] && board[nx][ny-1] != 0) {
                        cand[board[nx][ny-1]-1] = cand[last];
                        cand[last--] = 0;
                    }
                    if(ny+2 <N && board[nx][ny+1] == board[nx][ny+2] && board[nx][ny+1] != 0) {
                        cand[board[nx][ny+1]-1] = cand[last];
                        cand[last--] = 0;
                    }
                    if(nx-1 >=0 && nx+1 < M && board[nx-1][ny] == board[nx+1][ny] && board[nx-1][ny] != 0) {
                        cand[board[nx+1][ny]-1] = cand[last];
                        cand[last--] = 0;
                    }
                    if(ny-1>=0 && ny+1 < N && board[nx][ny-1] == board[nx][ny+1] && board[nx][ny-1] != 0) {
                        cand[board[nx][ny+1]-1] = cand[last];
                        cand[last--] = 0;
                    }
                    Random rnd = new Random();
                    int v = rnd.nextInt(last+1);
                    board[nx][ny] = cand[v];
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        return new Point(x, y);

    }


        /*
        // backtracking
        boolean res = false;
        if(x == 0 && y == 0) {
            res = backtrack(board, new Point(0, 3), new Point(x, y), q, 0);
        } else {
            res = backtrack(board, new Point(0, 0), new Point(x, y), q, 0);
        }
        if(!res) {
            System.out.println("can't find a way!");
        }
        */


    public static void main(String[] args) {
        int M = 10;
        int N = 10;
        int[][] board = new int[M][N];
        CandyCrush inst = new CandyCrush();
        try {
            Point p = inst.initialize(board, 3);
            System.out.println(p.x + "," + p.y);
        } catch(Exception e) {
            e.printStackTrace();
        }
        for(int i=0; i<M; ++i) {
            for(int j=0; j<N; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

}
