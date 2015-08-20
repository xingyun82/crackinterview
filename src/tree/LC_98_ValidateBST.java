package tree;

import common.*;
/**
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 * Created by xingyun on 15/8/20.
 */
public class LC_98_ValidateBST {

    private boolean isValid(TreeNode node, long min, long max) {
        if(node.val <= min || node.val >= max) return false;
        if(node.left != null) {
            if(!isValid(node.left, min, node.val)) return false;
        }
        if(node.right != null) {
            if(!isValid(node.right, node.val, max)) return false;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
