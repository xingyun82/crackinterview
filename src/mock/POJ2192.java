package mock;

/**
 * 题意：就是给定三个字符串A，B，C；判断C能否由AB中的字符组成，同时这个组合后的字符顺序必须是A，B中原来的顺序，不能逆序；
 * 例如：A：mnl，B：xyz；如果C为mnxylz，就符合题意；如果C为mxnzly，就不符合题意，原因是z与y顺序不是B中顺序。
 */
public class POJ2192 {

    // dp[i][j] means if A[0:i] and B[0:j] can form C[0:i+j]
    // dp[i][j] = dp[i-1][j] if C[i+j] == A[i]
    // dp[i][j] = dp[i][j-1] if C[i+j] == B[j]
    // dp[0][0] = true
    // dp[0][j] = dp[0][j-1] if C[j] == B[j]
    // dp[i][0] = dp[i-1][0] if C[i] == A[i]
    public boolean isComposite(String strA, String strB, String strC) {
        char[] A = strA.toCharArray();
        char[] B = strB.toCharArray();
        char[] C = strC.toCharArray();

        boolean[][] dp = new boolean[A.length+1][B.length+1];

        for (int i=1; i<A.length+1; ++i) {
            if (C[i-1] == A[i-1]) {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int j=1; j<B.length+1; ++j) {
            if (C[j-1] == B[j-1]) {
                dp[0][j] = dp[0][j-1];
            }
        }

        for (int i=1; i<A.length+1; ++i) {
            for (int j=1; j<B.length+1; ++j) {
                if (C[i+j-1] == A[i-1] && C[i+j-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else if (C[i+j-1] == A[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else if (C[i+j-1] == B[j-1]) {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[A.length][B.length];
    }
}
