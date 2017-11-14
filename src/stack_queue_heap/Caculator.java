package stack_queue_heap;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Implement a caculator support following expressions:
 *
 * 5+4*2
 * 1*(2+3)+4
 *
 * Created by yunxing on 7/15/16.
 */
enum NodeType{
    NUM,
    ADD,
    SUB,
    MUL,
    DIV,
    LB,
    RB
}

class ExprNode {
    String val;
    NodeType type; // 0: num, 1: +, 2: -, 3: *, 4: /, 5: (, 6: )
}

public class Caculator {

    private Stack<Character> opStack = new Stack<>();
    private Stack<Double> numStack = new Stack<>();
    private Iterator<ExprNode> iter;


    public double apply(char op, double num1, double num2) {
        double res = 0;
        switch(op) {
            case '+': res = num1 + num2; break;
            case '-': res = num1 - num2; break;
            case '*': res = num1 * num2; break;
            case '/': res = num1 / num2;
        }
        return res;
    }

    public double caculate(String str) {
        List<ExprNode> nodes = parse(str);
        opStack.clear();
        numStack.clear();
        iter = nodes.iterator();
        while(iter.hasNext()) {
            ExprNode node = iter.next();
            switch(node.type) {
                case NUM: numStack.push(Double.parseDouble(node.val)); break;
                case ADD: processAddAndSub(node); break;
                case SUB: processAddAndSub(node); break;
                case MUL: processMulAndDiv(node); break;
                case DIV: processMulAndDiv(node); break;
                case LB: processLeftBrace(); break;
                case RB: processRightBrace(); break;
            }
        }
        while(!opStack.isEmpty()) {
            popAndApply();
        }
        return numStack.pop();
    }

    private void processAddAndSub(ExprNode node) {
        if(!opStack.isEmpty()) {
            char op = opStack.peek();
            if(op == '+'|| op == '-' || op == '*' || op == '/') {
                popAndApply();
            }
        }
        opStack.push(node.val.charAt(0));
    }

    private void processMulAndDiv(ExprNode node) {
        opStack.push(node.val.charAt(0));
        ExprNode nextNode = iter.next();
        if(nextNode.type == NodeType.NUM) {
            numStack.push(Double.parseDouble(nextNode.val));
            popAndApply();
        } else if(nextNode.type == NodeType.LB) {
            processLeftBrace();
        }
    }

    private void processLeftBrace() {
        opStack.push('(');
    }

    private void processRightBrace() {

        while(opStack.peek() != '(') {
            popAndApply();
        }
        opStack.pop(); // pop (

    }

    private void popAndApply() {
        if(!opStack.isEmpty()) {
            char op = opStack.pop();
            double num2 = numStack.pop();
            double num1 = numStack.pop();
            double res = apply(op, num1, num2);
            numStack.push(res);
        }
    }


    

    private List<ExprNode> parse(String str) {
        List<ExprNode> expr = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(j < str.length() && str.charAt(j) >= '0' && str.charAt(j) <= '9') {
                j++;
            }
            ExprNode node = new ExprNode();
            if(j>i) {
                node.type = NodeType.NUM;
                node.val = str.substring(i, j);
            } else {
                node.val = str.substring(i, i+1);
                switch (str.charAt(i)) {
                    case '+': node.type = NodeType.ADD; break;
                    case '-': node.type = NodeType.SUB; break;
                    case '*': node.type = NodeType.MUL; break;
                    case '/': node.type = NodeType.DIV; break;
                    case '(': node.type = NodeType.LB;  break;
                    case ')': node.type = NodeType.RB;  break;
                }
                j++;
            }
            i = j;
            expr.add(node);

        }
        return expr;
    }


    public static void main(String[] args) {
        Caculator cal = new Caculator();
//        {
//            double res = cal.caculate("5+4*2");
//            System.out.println(res);
//        }
//        {
//            double res = cal.caculate("1*(2+3)+4");
//            System.out.println(res);
//        }
        {
            double res = cal.caculate("1+2*(4-1*2)/5");
            System.out.println(res);
        }
    }

}
