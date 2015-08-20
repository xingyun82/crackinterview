package tree;

import common.TreeNode;


/**
 *
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 * Created by xingyun on 15/7/22.
 */

class Depth {
    public int val;
}
public class LC_110_BalanceBinaryTree {


    /**
     * leetcode上有个方法可以避免定义Depth类，
     * int getDetph(TreeNode node)
     * 如果node的左右子树平衡，则返回node的高度，否则返回 Integer.MAX_VALUE
     *
     * @param node
     * @param depth
     * @return
     */
    public boolean getDepth(TreeNode node, Depth depth) {

        if(node == null) { depth.val = 0; return true; }

        Depth rightDepth = new Depth();
        Depth leftDepth = new Depth();

        boolean isLeftBalance = getDepth(node.left, leftDepth);
        if(!isLeftBalance) return false;
        boolean isRightBalance = getDepth(node.right, rightDepth);
        if(!isRightBalance) return false;

        if(Math.abs(leftDepth.val - rightDepth.val) > 1) return false;
        depth.val = Math.max(leftDepth.val, rightDepth.val)+1;

        return true;

    }

    public boolean isBalanced(TreeNode root) {
        Depth depth = new Depth();
        return getDepth(root, depth);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        //node5.left = node6;

        LC_110_BalanceBinaryTree inst = new LC_110_BalanceBinaryTree();
        System.out.println(inst.isBalanced(node1));
    }
}
