package dp;

import java.util.*;

/**
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

 * Created by xingyun on 15/8/19.
 */
public class LC_32_LongestValidParenthese {

    public int longestValidParentheses(String s) {
        //Deque<Integer> stack = new ArrayDeque<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        int longest = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(count);
                count = 0;
            } else if (stack.size() > 0) {
                //count += stack.poll() + 1;
                count += stack.pop() + 1;
                longest = Math.max(longest, count);
            } else {
                count = 0;
                stack.clear();
            }
        }
        return longest * 2;
    }
}
