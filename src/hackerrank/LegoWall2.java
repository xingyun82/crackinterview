package hackerrank;

import java.util.*;
import java.io.*;
/**
 * Created by xingyun on 15/8/27.
 */
public class LegoWall2 {

    public static void main(String[] args) throws IOException {
        LegoWall2 s = new LegoWall2();
        s.solve();
    }

    int m, n;
    int[] alpha, sol, alphapn;
    Scanner sc;
    static final int MOD = 1000000007;

    public LegoWall2() throws IOException {
        this.sc = new Scanner(System.in);
    }

    public void solve() throws IOException {
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            if (solveCornerCase()) continue;
            init();
            System.out.println(findSolution());
        }
    }

    private int findSolution() {
        for (int j = 2; j <= m; j++) {
            int sub = 0;
            for (int i = 1; i < j; i++) {
                long k = alphapn[j - i];
                k = (k * sol[i]) % MOD;
                sub += (int) k;
                if (sub >= MOD) sub -= MOD;
            }
            alphapn[j] = findAllCases(j);
            sol[j] = (MOD + alphapn[j] - sub) % MOD;
        }
        return sol[m];
    }

    private int findAllCases(int j) {
        long l = alpha[j];
        for (int i = 1; i < n; i++) {
            l = (l * alpha[j]) % MOD;
            if (l == 0) return 0;
        }
        return (int) l;
    }

    private boolean solveCornerCase() {
        if (n == 1) {
            if (m <= 4) System.out.println(1);
            else System.out.println(0);
            return true;
        }
        return false;
    }

    // Obviously this may be used across test cases.
    private void init() {
        alphapn = new int[m + 1];
        alpha = new int[m + 1];
        sol = new int[m + 1];
        alpha[0] = sol[0] = alphapn[0] = 0;
        alpha[1] = sol[1] = alphapn[1] = 1;
        if(m>=2) alpha[2] = 2;
        if(m>=3) alpha[3] = 4;
        if(m>=4) alpha[4] = 8;
        for (int i = 5; i <= m; i++) {
            long l = alpha[i - 1];
            l += alpha[i - 2];
            l += alpha[i - 3];
            l += alpha[i - 4];
            alpha[i] = (int) (l % MOD);
        }
    }
}
