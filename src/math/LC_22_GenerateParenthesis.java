package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"
 * Created by xingyun on 15/2/17.
 */
public class LC_22_GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
       List<String> res = new ArrayList<String>();
       if (n == 0) {
           List<String> res0 = Arrays.asList("");
           return res0;
       }
       if (n == 1) {
           List<String> res0 = Arrays.asList("()");
           return res0;
       }
       for (int i=0; i<n; ++i) {
           for (String inner : generateParenthesis(i)) {
               for (String outter : generateParenthesis(n-i-1)) {
                   res.add("(" + inner + ")" + outter);
               }
           }
       }
       return res;
    }

    public static void main(String[] args) {
        LC_22_GenerateParenthesis inst = new LC_22_GenerateParenthesis();
        List<String> res = inst.generateParenthesis(3);
        for (String str : res) {
            System.out.println(str);
        }
    }

}
