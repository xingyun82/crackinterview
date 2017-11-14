package dp;


/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

 Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

 Also, since the answer may be very large, you should return the output mod 109 + 7.

 Example 1:
 Input: "*"
 Output: 9
 Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 Example 2:
 Input: "1*"
 Output: 9 + 9 = 18

 */
public class LC_639_DecodeWaysII {

    /**
     * idea: dp[i] = dp[i-1]*ways(i) + dp[i-2]*ways(i-1, i)
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) return ways(s.charAt(0));
        if (s.length() == 2) return ways(s.charAt(0)) * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
        int MOD = 1000000007;
        long dp0 = ways(s.charAt(0));
        long dp1 = dp0 * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
        for (int i=2; i<s.length(); ++i) {
            long dp2 = (dp1 * ways(s.charAt(i)) % MOD + dp0*ways(s.charAt(i-1), s.charAt(i)) % MOD) % MOD;
            dp0 = dp1;
            dp1 = dp2;
        }
        return (int)dp1;
    }


    private int ways(char c) {
        if (c == '*') return 9;
        if (c == '0') return 0;
        return 1;
    }

    private int ways(char a, char b) {
        if (a == '*') {
            if (b == '*') return 15; // if a==1, count=9, if a==2, count=6
            if (b <= '6') return 2;
            return 1;
        }
        if (a == '1') {
            if (b == '*') return 9;
            return 1;
        }
        if (a == '2') {
            if (b == '*') return 6;
            if (b <= '6') return 1;
            return 0;
        }
        if (a == '0') return 0;
        return 0;
    }

    public static void main(String[] args) {
        LC_639_DecodeWaysII inst = new LC_639_DecodeWaysII();
        System.out.println(inst.numDecodings("*1"));

    }

}
