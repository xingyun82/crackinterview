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
}
