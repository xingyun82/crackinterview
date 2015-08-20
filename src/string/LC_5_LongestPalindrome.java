package string;


/**
 *
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * Created by xingyun on 15/2/7.
 */
public class LC_5_LongestPalindrome {

    // 回文包括奇数回文"aba" 和 偶数回文"aa"
    public String longestPalindrome(String s) {
        String res = null;
        int maxLen = 0;
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); ++i) {
            // i是奇数回文的中间字符
            {
                int k = Math.min(i, s.length() - 1 - i);
                int tmpLen = 0;
                for (int j = 1; j <= k; ++j) {
                    if (s.charAt(i - j) == s.charAt(i + j)) {
                        tmpLen++;
                    } else {
                        break;
                    }
                }
                if (2*tmpLen+1 > maxLen) {
                    maxLen = 2*tmpLen+1;
                    start = i - tmpLen;
                    end = i + tmpLen;

                }
            }
            // i是偶数回文的n/2字符
            {
                int k = Math.min(i, s.length()-2-i);
                int tmpLen = 0;
                for(int j=0; j<=k; ++j) {
                    if(s.charAt(i-j) == s.charAt(i+1+j)) {
                        tmpLen++;
                    } else {
                        break;
                    }
                }
                if (2*tmpLen > maxLen) {
                    maxLen = 2*tmpLen;
                    start = i-tmpLen+1;
                    end = i+tmpLen;

                }
            }
        }
        res = s.substring(start, end+1);
        return res;
    }

    public static void main(String[] args) {
        LC_5_LongestPalindrome obj = new LC_5_LongestPalindrome();
        System.out.println(obj.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
