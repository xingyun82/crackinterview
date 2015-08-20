package tree;

import java.util.*;
import common.*;
/**
 *
 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

 * Created by xingyun on 15/7/24.
 */
public class LC_100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null) return q == null;
        else if(q == null) return false;

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        stack1.push(p);
        stack2.push(q);

        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if(node1.val != node2.val) return false;
            if(node1.left != null) {
                if(node2.left == null) return false;
                stack1.push(node1.left);
                stack2.push(node2.left);
            } else {
                if(node2.left != null) return false;
            }
            if(node1.right != null) {
                if(node2.right == null) return false;
                stack1.push(node1.right);
                stack2.push(node2.right);
            } else {
                if(node2.right != null) return false;
            }
        }
        if(!stack1.isEmpty() || !stack2.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {

        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);

        node11.left = node12;
        node11.right = node13;

        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(3);

        node21.left = node22;
        //node21.right = node23;

        LC_100_SameTree inst = new LC_100_SameTree();
        System.out.println(inst.isSameTree(node11, node21));
    }
}
