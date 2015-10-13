package corejava;

import java.util.*;
/**
 * 扫雷游戏初始化
 * Created by xingyun on 10/10/15.
 */
public class MimeSweeper {

    public final static int[][] dirs = {
            {-1, -1, -1, 0, 0, 1, 1, 1},
            {-1, 0,  1, -1, 1, -1, 0, 1}
    };


    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    List<Integer> generateRandoms(int N, int K) {
        List<Integer> res = new ArrayList<Integer>();
        int[] nums = new int[N];
        for(int i=0; i<N; ++i) nums[i] = i;
        for(int i=0; i<K; ++i) {
            Random r = new Random();
            int p = r.nextInt(N-i);
            res.add(nums[p]);
            swap(nums, p, N-1-i);
        }
        return res;
    }

    /*
    W: 地图长度
    H: 地图高度
    K: 地雷个数
     */
    int[][] generateGame(int W, int H, int K) {
        int[][] matrix = new int[H][W];
        List<Integer> seeds = generateRandoms(W*H, K);
        for(int seed:seeds) {
            matrix[seed/W][seed%W] = -1;
        }
        for(int seed:seeds) {
            for(int i=0; i<8; ++i) {
                int ni = seed/W + dirs[0][i];
                int nj = seed%W + dirs[1][i];
                if(ni < 0 || ni>= H || nj <0 || nj >= W) continue;
                if(matrix[ni][nj] == -1) continue;
                else {
                    matrix[ni][nj]++;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        MimeSweeper inst = new MimeSweeper();
        int W = 10, H = 5;
        int[][] matrix = inst.generateGame(W, H, 10);
        for(int i=0; i<H; ++i) {
            for(int j=0; j<W; ++j) {
                if(matrix[i][j] == -1) System.out.print("* ");
                else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
