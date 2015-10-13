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

        TreeNode nRoot = inst.UpsideDownBinaryTree(root);
        nRoot.printTree();
    }
}
