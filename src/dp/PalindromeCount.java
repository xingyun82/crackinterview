package dp;

/**
 * Created by xingyun on 15/6/11.
 */
public class PalindromeCount {

    /*
        count palindrome substrs through dp
     */
    public int dp(String str, int i, int j) {
        if(i == j) return 1;
        if(i > j) return 0;
        if(str.charAt(i) == str.charAt(j)) {
            return dp(str, i, j-1) + dp(str, i+1, j) - dp(str, i+1, j-1) + 1;
        } else {
            return dp(str, i, j-1) + dp(str, i+1, j) - dp(str, i+1, j-1);
        }
    }

    public int palindromeCount(String str) {
        return dp(str, 0, str.length()-1);
    }

    public static void main(String[] args) {
        String str = "aab";
        PalindromeCount inst = new PalindromeCount();
        System.out.println(inst.palindromeCount(str));
    }
}
