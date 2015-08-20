package string;

import java.util.*;
/**
 *
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 Note: Do not use the eval built-in library function.
 *
 * Created by xingyun on 15/8/20.
 */
public class LC_227_BasicCalculatorII {

    Stack<Integer> nums = new Stack<Integer>();
    Stack<Character> ops = new Stack<Character>();

    private void calc() {
        int a = nums.pop();
        int b = nums.pop();
        Character c = ops.pop();
        if(c == '+') {
            nums.push(a+b);
        } else if(c == '-') {
            nums.push(b-a);
        } else if(c == '*') {
            nums.push(b*a);
        } else if(c == '/') {
            nums.push(b/a);
        }
    }

    private int getOpOrder(Character c) {
        if(c == '+' || c == '-') return 1;
        if(c == '*' || c == '/') return 2;
        return 0;
    }

    public int calculate(String s) {
        String numStr = "";
        for(int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            if(c == ' ') continue;
            else if(c == '+' || c == '-' || c == '*' || c == '/') {
                if(!numStr.isEmpty()) { nums.push(Integer.valueOf(numStr)); numStr = ""; }
                while( !ops.isEmpty() && getOpOrder(c) <= getOpOrder(ops.peek())) {
                    calc();
                }
                ops.push(c);
            }
            else if(c >= '0' && c <= '9') {
                numStr += c;
            }
        }
        if(!numStr.isEmpty()) {
            nums.push(Integer.valueOf(numStr));
            numStr = "";
        }
        while(!ops.isEmpty()) {
            calc();
        }

        return nums.pop();
    }
}
