package stack_queue_heap;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * Created by xingyun on 15/6/21.
 */
public class LC_150_EvaluateReversePolishExpr {

    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> tokenStack = new Stack<Integer>();
        for (String t: tokens) {
            if(t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                Integer num1 = tokenStack.pop();
                Integer num2 = tokenStack.pop();
                if (t.equals("+")) {
                    tokenStack.push(num2 + num1);
                } else if (t.equals("-")) {
                    tokenStack.push(num2 - num1);
                } else if (t.equals("*")) {
                    tokenStack.push(num2 * num1);
                } else if (t.equals("/")) {
                    tokenStack.push(num2 / num1);
                }

            } else {
                tokenStack.push(Integer.valueOf(t));
            }
        }
        if(!tokenStack.empty())
            return tokenStack.pop();
        return res;
    }

    public static void main(String[] args) {
        LC_150_EvaluateReversePolishExpr inst = new LC_150_EvaluateReversePolishExpr();
        System.out.println(inst.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(inst.evalRPN(new String[]{"4", "13", "5", "/", "+"}));

    }
}
