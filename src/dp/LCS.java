package dp;

/**
 * Created by xingyun on 15/9/9.
 */
public class LCS {

    //最长公共子序列
    // s[0, j] = 0
    // s[i, 0] = 0
    // s[i, j] = s[i-1, j-1] + 1 (if a[i] == b[j])
    //         = max { s[i-1, j], s[i, j-1] }  if a[i]!=b[j]

    public int LongestCommonSubseq(int[] A, int[] B) {
        if(A== null || B == null || A.length == 0 || B.length == 0) return 0;
        int m = A.length;
        int n = B.length;
        int[][] S = new int[m+1][n+1];
        for(int i=0; i<=m; ++i) {
            S[i][0] = 0;
        }
        for(int j=0; j<=n; ++j) {
            S[0][j] = 0;
        }
        for(int i=1; i<=m; ++i) {
            for(int j=1; j<=n; ++j) {
                if(A[i-1] == B[j-1]) {
                    S[i][j] = S[i-1][j-1] + 1;
                } else {
                    S[i][j] = Math.max(S[i-1][j], S[i][j-1]);
                }
            }
        }
        return S[m][n];
    }

    //最长连续公共子序列
    // s[0, j] = 0
    // s[i, 0] = 0
    // s[i, j] = s[i-1, j-1] + 1 (if a[i] == b[j])
    //         = 0 if a[i] != b[j]

    public int LongestContinousCommonSubSeq(int[] A, int[] B) {
        int res = 0;
        if(A== null || B == null || A.length == 0 || B.length == 0) return 0;
        int m = A.length;
        int n = B.length;
        int[][] S = new int[m+1][n+1];
        for(int i=0; i<=m; ++i) {
            S[i][0] = 0;
        }
        for(int j=0; j<=n; ++j) {
            S[0][j] = 0;
        }
        for(int i=1; i<=m; ++i) {
            for(int j=1; j<=n; ++j) {
                if(A[i-1] == B[j-1]) {
                    S[i][j] = S[i-1][j-1] + 1;
                    res = Math.max(res, S[i][j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,9};
        int[] B = {2,3,4,11,7,9,10,6};
        LCS inst =new LCS();
        //System.out.println(inst.LongestCommonSubseq(A, B));
        System.out.println(inst.LongestContinousCommonSubSeq(A, B));
    }

}
