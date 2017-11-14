package dp;

/**
 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.
 '?' Matches zero or one of the preceding element.
 '+' Matches one or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 isMatch("aaaab", "a+b")) -> true
 isMatch("aab", "a?b")) -> false
 isMatch("ab", "a?b")) -> true
 isMatch("b", "a?b")) -> true


 NOTE:

 if  p[j] == '.' || p[j] == s[i]
    dp[i][j] = dp[i-1][j-1]

 if  p[j] == '*'
     a) dp[i][j] = dp[i][j-1] || dp[i-1][j]    (if p[j-1] == '.' || p[j-1] == s[i])
     b) dp[i][j] = dp[i][j-2]

 if p[j] == '?'
    dp[i][j] = dp[i][j-2] || dp[i][j-1]

 if p[j] == '+'
    dp[i][j] = dp[i-1][j]   (if p[j-1] == '.' || p[j-1] == s[i])
    dp[i][j] = dp[i][j-1]   



 */
public class LC_10_RegulareExpressionMatching {

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for (int i=1; i<m+1; ++i) {
            if ((p.charAt(i-1) == '*' || p.charAt(i-1) == '?') && dp[0][i-2]) {
                dp[0][i] = true;
            }
        }
        for (int i=1; i<n+1; ++i) {
            for (int j=1; j<m+1; ++j) {
                // p[j-1] == '.'
                if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                // p[j-1] == '*'
                else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2] || ((dp[i][j-1] || dp[i-1][j]) && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'));
                }
                // p[j-1] == '?'
                else if (p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i][j-2] || dp[i][j-1];
                }
                // p[j-1] == '+'
                else if (p.charAt(j-1) == '+') {
                    dp[i][j] = dp[i][j-1] || (dp[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        LC_10_RegulareExpressionMatching inst = new LC_10_RegulareExpressionMatching();
        System.out.println(inst.isMatch("aa", "a"));
        System.out.println(inst.isMatch("aa", "aa"));
        System.out.println(inst.isMatch("aaa", "aa"));
        System.out.println(inst.isMatch("aa", "a*"));
        System.out.println(inst.isMatch("aa", ".*"));
        System.out.println(inst.isMatch("ab", ".*"));
        System.out.println(inst.isMatch("aab", "c*a*b"));
        System.out.println(inst.isMatch("aaaab", "a+b"));
        System.out.println(inst.isMatch("aab", "a?b"));
        System.out.println(inst.isMatch("ab", "a?b"));
        System.out.println(inst.isMatch("b", "a?b"));
    }
}
