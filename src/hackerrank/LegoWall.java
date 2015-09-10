package hackerrank;

/**
 * 大数取模操作需要注意的几个地方
 * 1. 乘法用long先求积，再取模
 * 2. 减法要加上MOD再求减
 *
 * Created by xingyun on 15/8/27.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LegoWall {

        public static int solve(int n, int m) {
            int[] lineAll = new int[m+1]; // all cases for one line
            int[] wallAll = new int[m+1]; // all cases for the wall
            int[] solutions = new int[m+1]; // the final solutions

            // intialization
            lineAll[0] = 1;
            int MOD = 1000000007;
            // compute lineAll
            for(int i=1; i<=m; ++i) {
                long tmp = lineAll[i];
                for(int j=1; j<=Math.min(4, i); ++j) {
                    tmp = (tmp + lineAll[i-j])%MOD;
                }
                lineAll[i] = (int)tmp;
            }
            // compute wallAll
            for(int i=0; i<=m; ++i) {
                long tmp = lineAll[i];
                for(int j=0; j<n-1; ++j) {
                    tmp = (tmp*lineAll[i])%MOD;
                }
                wallAll[i] = (int)tmp;
            }
            // compute solutions
            for(int i=0; i<=m; ++i) {
                long tmp = 0;
                for(int j=1; j<=i-1; ++j) {
                    long tmp2 = ((long)solutions[j]*wallAll[i-j])%MOD;
                    tmp = (tmp + tmp2)%MOD;
                }
                solutions[i] = (int)((MOD+wallAll[i] - tmp)%MOD);
            }
            return solutions[m];

        }

        public static void main(String[] args) {
            int T = 0, M = 0, N = 0;
            Scanner sc = new Scanner(System.in);
            T = sc.nextInt();
            for(int i=0; i<T; ++i) {
                N = sc.nextInt();
                M = sc.nextInt();
                int res = solve(N, M);
                System.out.println(res);
            }

        }
    }

