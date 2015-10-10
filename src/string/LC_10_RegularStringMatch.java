package string;

/**
 * '.' Matches any single character.
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

 TODO: 后续可以考虑+如何处理


 * Created by xingyun on 15/2/8.
 */


public class LC_10_RegularStringMatch {


    public boolean matchStar(char c, String s, String p, int i, int j) {
        // p:a*, s:aaaa
        if (j == p.length()) {
            while(i<s.length()) {
                if(!(s.charAt(i++) == c || c == '.')) return false;
            }
            return true;
        }
        // p:a*b, s:aaab
        do {
            if(matchHere(s, p, i, j)) return true;
        } while(i<s.length() && (s.charAt(i++) == c || c=='.'));

        return false;
    }

    public boolean matchHere(String s, String p, int i, int j) {
        if (j == p.length()) return i== s.length();
        // p:a*b, s:aaab
        if (j<p.length()-1 && p.charAt(j + 1) == '*') {
            return matchStar(p.charAt(j), s, p, i, j+2);
        }
        // p:ab, s:abc
        if (i < s.length() && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))) {
            return matchHere(s, p, i+1, j+1);
        }
        return false;
    }

    public boolean isMatch(String s, String p) {
        if (s == null) return p == null;
        if (p == null) return false;
        return matchHere(s, p, 0, 0);
    }

    public static void main(String[] args) {
        LC_10_RegularStringMatch inst = new LC_10_RegularStringMatch();

        System.out.println(inst.isMatch("aaaa", "a*"));
        System.out.println(inst.isMatch("ab", "a*b"));
        System.out.println(inst.isMatch("b", "a*b"));
        System.out.println(inst.isMatch("", "a*"));
        System.out.println(inst.isMatch("baa", "a*"));
        System.out.println(inst.isMatch("aa", "c*a*"));
        System.out.println(inst.isMatch("abab", "a*b*"));
        System.out.println(inst.isMatch("aabb", "a*b*"));

        System.out.println(inst.isMatch("a", "a*b"));
        System.out.println(inst.isMatch("a", "b"));

    }


}
