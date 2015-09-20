package backtracking;

import java.util.*;
/**
 * Created by xingyun on 9/19/15.
 */


class AtomExpr {
    public long num1;
    public long num2;
    public char op;

    public long compute() {
        return compute(num1, num2, op);
    }

    public long compute(long a, long b, char c) {
        if(c == 0) return a;
        if(c == '+') return a+b;
        if(c == '-') return a-b;
        if(c == '*') return a*b;
        return 0;
    }

    public AtomExpr expand(long num, char c) {
        AtomExpr res = new AtomExpr();
        if(op == 0) {
            res.num1 = num1;
            res.num2 = num;
            res.op = c;
            return res;
        }
        if(c != '*') {
            res.num1 = compute();
            res.op = c;
            res.num2 = num;
        } else {
            res.num1 = num1;
            res.op = op;
            res.num2 = compute(num2, num, c);
        }
        return res;
    }
}

class PathNode {
    public AtomExpr expr;
    public String exprStr;
    public int i;
}

public class LC_283_ExprAndOp {

    public static final char[] OPS = new char[]{'+', '-', '*'};

    public void DFS(List<String> res, PathNode pre, String num, int target) {
        int i = pre.i;
        // termination case
        if (i == num.length()) {
            long tmp = pre.expr.compute();
            if (tmp == target) {
                res.add(pre.exprStr);
            }
            return;
        }
        int maxj = num.length();
        if(num.charAt(i) == '0') maxj = i+1;
        // find next step
        List<PathNode> candidates = new ArrayList<PathNode>();
        for (int j = i + 1; j <= maxj; ++j) {
            String seg = num.substring(i, j);
            if (i == 0) {
                AtomExpr expr = new AtomExpr();
                expr.num1 = Long.valueOf(seg);
                String exprStr = seg;
                PathNode node = new PathNode();
                node.expr = expr;
                node.exprStr = exprStr;
                node.i = j;
                candidates.add(node);
            } else {
                for (char c : OPS) {
                    AtomExpr expr = new AtomExpr();
                    expr = pre.expr.expand(Long.valueOf(seg), c);
                    String exprStr = pre.exprStr + c + seg;
                    PathNode node = new PathNode();
                    node.expr = expr;
                    node.exprStr = exprStr;
                    node.i = j;
                    candidates.add(node);
                }
            }
        }

        for (PathNode node : candidates) {
            DFS(res, node, num, target);
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        PathNode pre = new PathNode();
        pre.i = 0;
        pre.expr = new AtomExpr();
        pre.exprStr = "";
        DFS(res, pre, num, target);
        return res;
    }

    public static void main(String[] args) {
        String num = "3456237490";
        int target = 9191;
        LC_283_ExprAndOp inst = new LC_283_ExprAndOp();
        List<String> res = inst.addOperators(num, target);
        for(String str:res) {
            System.out.println(str);
        }
    }
}
