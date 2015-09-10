package tree;

import common.TreeNode;
import java.math.BigInteger;

/**
 *
 * Given a binary tree, find the maximum path sum.

 The path may start and end at any node in the tree.

 For example:
 Given the below binary tree,

 1
 / \
 2   3
 Return 6.

 * Created by xingyun on 15/7/10.
 */
class MaxPathSum{
    int val;

    public MaxPathSum(int val) {
        this.val = val;
    }
}

public class LC_124_FindMaxPathSum {
    /*
    public int maxStartPathSum(TreeNode root) {
        if(root == null) return 0;
        int res = root.val, leftMax, rightMax;
        leftMax = Math.max(0, maxStartPathSum(root.left));
        rightMax = Math.max(0, maxStartPathSum(root.right));
        return res + Math.max(leftMax, rightMax);
    }

    public int maxMiddlePathSum(TreeNode root) {
        if(root == null) return 0;
        int res = root.val, leftMax, rightMax;
        leftMax = Math.max(0, maxStartPathSum(root.left));
        rightMax = Math.max(0, maxStartPathSum(root.right));
        return res + leftMax + rightMax;
    }

    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int leftMax, rightMax, middleMax;
        leftMax = maxPathSum(root.left);
        rightMax = maxPathSum(root.right);
        middleMax = maxMiddlePathSum(root);
        return Math.max(leftMax, Math.max(rightMax, middleMax));
    }
    */

    /**
     * 在求StartPathSum的过程中，求经过每个node的MiddlePathSum，并更新maxPathSum
     * @param root
     * @param maxPathSum
     * @return
     */
    public int maxStartPathSum(TreeNode root, MaxPathSum maxPathSum) {
        if(root == null) return 0;
        int res = root.val, leftMax, rightMax;
        leftMax = Math.max(0, maxStartPathSum(root.left, maxPathSum));
        rightMax = Math.max(0, maxStartPathSum(root.right, maxPathSum));
        maxPathSum.val = Math.max(maxPathSum.val, res+leftMax+rightMax);
        return res + Math.max(leftMax, rightMax);
    }

    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        MaxPathSum res = new MaxPathSum(root.val);
        maxStartPathSum(root, res);
        return res.val;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-100);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        LC_124_FindMaxPathSum inst = new LC_124_FindMaxPathSum();
        System.out.println(inst.maxPathSum(node1));

    }
}
