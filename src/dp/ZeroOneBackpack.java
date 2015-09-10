package dp;

/**
 * Created by xingyun on 15/9/9.
 */
public class ZeroOneBackpack {

    public int solve(int[] ws, int[] vs, int W) {
        int N = ws.length;
        // F[i][j] is if there are i items, j weight space, the biggest value I can get
        int[][] F = new int[N+1][W+1];

        for(int i=1; i<=N; ++i) {
            for(int j=1; j<=W; ++j) {
                if(j>=ws[i-1]) {
                    F[i][j] = Math.max(
                            F[i - 1][j], // not choose the ith item
                            F[i - 1][j - ws[i-1]] + vs[i-1] // choose the ith item
                    );
                } else {
                    F[i][j] = F[i-1][j]; // not choose the ith item
                }
            }
        }
        // backtrack to get the choosed item
        int j = W;
        for(int i=N; i>0; --i) {
            if(F[i][j] > F[i-1][j]) {
                System.out.println("ws:" + ws[i-1] + ", vs:" + vs[i-1]);
                j -= ws[i-1];
            }
        }
        return F[N][W];
    }

    public static void main(String[] args) {
        int[] ws = {4,5,10,3};
        int[] vs = {30,20,40,10};
        ZeroOneBackpack inst = new ZeroOneBackpack();
        System.out.println(inst.solve(ws, vs, 16));
    }
}
