package string;

import java.util.*;
/**
 * Created by xingyun on 15/9/15.
 */
public class WildCardMatch {

    /*
    public List<Integer> findChar(String s, int i, char c) {
        List<Integer> res = new ArrayList<Integer>();
        while(i<s.length()) {
            if(c == '?') res.add(i);
            else if(s.charAt(i) == c) res.add(i);
            i++;
        }
        return res;
    }

    public boolean doMatch(String s, int i, String p, int j) {
        while(i<s.length() && j <p.length()) {
            char si = s.charAt(i);
            char pj = p.charAt(j);
            if(pj == '*') {
                while(pj == '*') {j++; pj=p.charAt(j);}
                if(j == p.length()) return true;
                List<Integer> cands = findChar(s, i, p.charAt(j));
                for(int k:cands) {
                    if(doMatch(s, k+1, p, j+1)) return true;
                }
            } else if(pj == '?') {
                i++; j++;
            } else {
                if(pj == si) {i++;j++;}
                else return false;
            }
        }

        return (i == s.length() && j == p.length());
    }

    public String cleanPattern(String p) {
        StringBuffer bp = new StringBuffer();
        for(int i=0; i<p.length(); ++i) {

            if(p.charAt(i) == '*') {
                bp.append('*');
                while(p.charAt(i) == '*') i++;
            }
            bp.append(p.charAt(i));

        }
        return bp.toString();
    }

    public boolean isMatch(String s, String p) {
        String cp = cleanPattern(p);
        return doMatch(s, 0, cp, 0);
    }
    */

    // M[i][j] =  M[i-1][j-1] && ( S[i-1] == P[j-1] || P[j-1] == '?' )  // if P[j-1] != '*'
    //         =  M[i][j-1] || M[i-1][j]  // if P[j-1] == '*'

    // M[0][0] = true;
    // M[i][0] = false;
    // M[0][j] = false  // if P[j-1] != '*'
    //         = M[0][j-1]  // if P[j] == '*'

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] M = new boolean[m+1][n+1];
        M[0][0] = true;
        for(int i=1; i<=n; ++i) {
            if(p.charAt(i-1) != '*') M[0][i] = false;
            else M[0][i] = M[0][i-1];
        }
        for(int i=1; i<=m; ++i) {
            M[i][0] = false;
        }
        for(int i=1; i<=m; ++i) {
            for(int j=1; j<=n; ++j) {
                if(p.charAt(j-1) != '*') {
                    M[i][j] = M[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?');
                } else {
                    M[i][j] = M[i][j-1] || M[i-1][j];
                }
            }
        }
        return M[m][n];
    }

    public static void main(String[] args) {
        String s = "";
        String p = "a*";

        WildCardMatch inst = new WildCardMatch();
        System.out.println(inst.isMatch(s, p));
    }


}
