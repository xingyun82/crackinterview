package stack_queue_heap;


import java.util.*;
/**
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 * Created by xingyun on 15/8/20.
 */
public class LC_20_ValidParenthese {

    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<Character>();
        int i=0;
        while(i<s.length()) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                charStack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if(charStack.isEmpty()) return false;
                if(c == ')' && charStack.peek() != '(') return false;
                if(c == ']' && charStack.peek() != '[') return false;
                if(c == '}' && charStack.peek() != '{') return false;
                charStack.pop();
            }
            i++;
        }
        return charStack.isEmpty();
    }
}
