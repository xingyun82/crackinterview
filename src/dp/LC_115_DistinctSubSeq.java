package dp;

/**
 *
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Here is an example:
 S = "rabbbit", T = "rabbit"

 Return 3.
 * Created by xingyun on 15/7/20.
 */
public class LC_115_DistinctSubSeq {

    /* 递归方法
    public int dp(String s, String t, int i, int j) {
        if(i < j) return 0;
        if(i == 0 && j == 0) {
            if(s.charAt(i) == t.charAt(j)) return 1;
            return 0;
        }
        if(s.charAt(i) == t.charAt(j)) {
            return dp(s, t, i-1, j-1) + dp(s, t, i-1, j);
        } else {
            return dp(s, t, i-1, j);
        }
    }

    public int numDistinct(String s, String t) {
        return dp(s, t, s.length()-1, t.length()-1);
    }

    */

    /* 优化
    public int numDistinct(String s, String t) {

        int[][] dp = new int[t.length()+1][s.length()+1];

        for(int i=0; i<=s.length(); ++i) {
            dp[0][i] = 1;
        }
        for(int i=1; i<=t.length(); ++i) {
            for(int j=1; j<=s.length(); ++j) {
                if(t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];

    }
    */

    /**
     * 还可以再优化
     * @param args
     *
     */
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length()+1];
        dp[0] = 1;
        for(int i=1; i<=s.length(); ++i) {
            for(int j=t.length(); j>=1; --j) { // 注意逆序
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[t.length()];
    }


    public static void main(String[] args) {
        String s = "rabbbittt";
        String t = "rabbit";
        LC_115_DistinctSubSeq inst = new LC_115_DistinctSubSeq();
        System.out.println(inst.numDistinct(s, t));
    }
}
