package tree;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty, flip it upside down and turn
 * it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

 For example:
 Given a binary tree {1,2,3,4,5},
 1
 / \
 2 3
 / \
 4 5

 return the root of the binary tree [4,5,2,#,#,3,1].
 4
 / \
 5 2
 / \
 3 1


 * Created by xingyun on 10/13/15.
 */

import common.*;

import java.util.Stack;

public class LC_156_BinaryTreeUpsideDown {


    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        TreeNode nLeft = null, nRight = null;
        TreeNode node = root;
        while(node != null) {
            TreeNode tmpRight = node.right;
            TreeNode tmpLeft  = node.left;
            node.left  = nLeft;
            node.right = nRight;

            nLeft = tmpRight;
            nRight = node;

            node = tmpLeft;
        }
        return nRight;
    }

    /**
     * Solution with stack:
     * pros: don't break the original tree.
     * cons: need more space
     */
    public TreeNode UpsideDownBinaryTree2(TreeNode root) {
        if (root == null) return null;
        Stack<Integer> stack = new Stack();
        // push all nodes in stack, if the right is empty, then put null
        TreeNode node = root;
        while (node != null) {
            stack.push(node.val);
            if (node.right == null) {
                stack.push(null);
            } else {
                stack.push(node.right.val);
            }
            node = node.left;
        }
        TreeNode dummyNode = new TreeNode(-1);
        TreeNode tmpNode = dummyNode;
        while(!stack.isEmpty()) {
            Integer val = stack.pop();
            if (val == null) {
                tmpNode.left = null;
            } else {
                tmpNode.left = new TreeNode(val);
            }
            tmpNode.right = new TreeNode(stack.pop());
            tmpNode = tmpNode.right;
        }
        return dummyNode.right;
    }

    public static void main(String[] args) {
        LC_156_BinaryTreeUpsideDown inst = new LC_156_BinaryTreeUpsideDown();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;

//        TreeNode nRoot = inst.UpsideDownBinaryTree(root);
        TreeNode nRoot = inst.UpsideDownBinaryTree2(root);
        nRoot.printTree();
    }
}
