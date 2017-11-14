package math;

/**
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

 You may assume that the given expression is always valid.

 Some examples:
 "1 + 1" = 2
 " 2-1 + 2 " = 3
 "(1+(4+5+2)-3)+(6+8)" = 23
 Note: Do not use the eval built-in library function.

 * Created by xingyun on 15/8/16.
 */

import java.util.*;

class CalcNode {
    public int val;
    public char brace;
    public int braceCount;
}

public class LC_224_Calculator {

    Stack<CalcNode> nodeStack = new Stack<CalcNode>();
    Stack<Character> opStack = new Stack<Character>();


    private void doCalc() {
        while(!opStack.isEmpty()) {
            CalcNode node1 = nodeStack.peek();
            if(node1.brace == '(') return;
            node1 = nodeStack.pop();
            CalcNode node2 = nodeStack.pop();
            char op = opStack.pop();
            CalcNode node = new CalcNode();
            if(op == '+') {
                node.val = node2.val + node1.val;
            } else if(op == '-') {
                node.val = node2.val - node1.val;
            }
            if(node2.brace == '(') {
                if(node1.braceCount > node2.braceCount) {
                    node.brace = node1.brace;
                    node.braceCount = node1.braceCount - node2.braceCount;
                } else if(node1.braceCount < node2.braceCount) {
                    node.brace = node2.brace;
                    node.braceCount = node2.braceCount - node1.braceCount;
                }
            }
            nodeStack.push(node);
        }
    }

    public int calculate(String s) {
        char brace = 0;
        int braceCount = 0;
        String numStr = "";
        char op = 0;

        for(int i=0; i<s.length(); ++i) {
            char c = s.charAt(i);
            if(c == ' ') continue;
            else if(c == '(' || c == ')') {
                brace = c;
                braceCount++;
            } else if( c == '+' || c == '-') {
                op = c;
                CalcNode node = new CalcNode();
                node.val = Integer.valueOf(numStr);
                node.brace = brace;
                node.braceCount = braceCount;
                nodeStack.push(node);

                doCalc();

                opStack.push(op);

                numStr = "";
                op = 0;
                brace = 0;
                braceCount = 0;

            } else if( c >= '0' && c <= '9') {
                numStr += c;
            }
        }
        CalcNode node = new CalcNode();
        node.val = Integer.valueOf(numStr);
        node.brace = brace;
        node.braceCount = braceCount;
        nodeStack.push(node);

        doCalc();
        return nodeStack.pop().val;
    }

    public static void main(String[] args) {
        LC_224_Calculator inst = new LC_224_Calculator();
        System.out.println(inst.calculate("(1-(2+3))-4"));
    }
}