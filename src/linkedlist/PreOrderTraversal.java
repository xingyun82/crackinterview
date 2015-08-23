package linkedlist;

import java.util.*;
import common.*;
/**
 * Created by xingyun on 15/8/20.
 */
public class PreOrderTraversal {

    public void preOrder(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // traversal the left to get the depth
        int depth = 0;
        while(p != null) {
            depth++;
            stack.push(p);
            p = p.left;
        }
        if(!stack.isEmpty()) {
            p = stack.pop();
        }
    }
}
