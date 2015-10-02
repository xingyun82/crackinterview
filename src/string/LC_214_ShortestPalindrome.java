package string;

/**
 * Created by xingyun on 9/27/15.
 */
public class LC_214_ShortestPalindrome {

    // 1. get the maximum prefix palindrome
    // 2. get the reverse of rest characters
    public String shortestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() == 0) return s;
        int mpl = getMaxPrefixPalindromeIdx(s);
        StringBuilder sb = new StringBuilder(s.substring(mpl));
        sb.reverse();
        return sb + s;
    }

    public int[] getPrefix(String s) {
        int[] P = new int[s.length()];
        int j = 0;
        for(int i=1; i<s.length(); ++i) {
            while(j>0 && s.charAt(i) != s.charAt(j)) j=P[j-1];
            if(s.charAt(i) == s.charAt(j)) j++;
            P[i] = j;
        }
        return P;
    }

    public int getMaxPrefixPalindromeIdx(String s) {

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String nsb = s + "#" + sb; // 这个很妙，避免了s的后缀和reverse(s)的前缀链接导致P 计算不准确的情况！
        int[] P = getPrefix(nsb);
        return P[nsb.length()-1];
    }

    public static void main(String[] args) {
        String s = "aba";
        LC_214_ShortestPalindrome inst = new LC_214_ShortestPalindrome();
        System.out.println(inst.shortestPalindrome(s));
    }
}
