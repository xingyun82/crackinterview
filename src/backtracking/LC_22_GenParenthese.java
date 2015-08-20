package backtracking;


import java.util.*;
/**
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"
 * Created by xingyun on 15/8/19.
 */
public class LC_22_GenParenthese {

    public void backtrace(int l, int r, String str, List<String> res) {
        if (l == 0 && r == 0) {
            res.add(str);
            return;
        }
        if (l >0) {
            backtrace(l-1, r, str+"(", res);
        }
        if (r >l) {
            backtrace(l, r-1, str+")", res);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrace(n, n, "", res);
        return res;
    }

}

