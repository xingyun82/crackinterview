package backtracking;

/**
 *
 * Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

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

 * Created by xingyun on 15/8/19.
 */
public class LC_10_RegularExpressionMatching {

    /*
    public boolean matchStar(char c, String s, String p, int i, int j) {
        if (j == p.length()) {
            while(i<s.length()) {
                if(!(s.charAt(i++) == c || c == '.')) return false;
            }
            return true;
        }
        do {
            if(matchHere(s, p, i, j)) return true;
        } while(i<s.length() && (s.charAt(i++) == c || c=='.'));

        return false;
    }


    public boolean matchHere(String s, String p, int i, int j) {
        if (j == p.length()) return i== s.length();
        if (j<p.length()-1 && p.charAt(j + 1) == '*') {
            return matchStar(p.charAt(j), s, p, i, j+2);
        }
        if (j<p.length() && i < s.length() && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))) {
            return matchHere(s, p, i+1, j+1);
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        return matchHere(s, p, 0, 0);
    }
    */

    // 简单递归算法
    public boolean isMatch(String s, String p) {
        if(s == null || s.length() == 0) return false;
        if(p.length() == 0) return s.length() == 0;
        if(p.length() == 1) {
            if(s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') return false;
            return s.length() == 1;
        }
        if(p.charAt(1) == '*') {
            int i=0;
            while(i<s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if(isMatch(s.substring(i+1), p.substring(2))) return true;
                i++;
            }
            return isMatch(s.substring(i), p.substring(2));
        } else {
            if(s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') return false;
            return isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        String s = "ab";
        String p = "aa*b";
        LC_10_RegularExpressionMatching inst = new LC_10_RegularExpressionMatching();
        System.out.println(inst.isMatch(s, p));
    }




}
