package tree;

import common.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 Example:
 Given a binary tree
 1
 / \
 2   3
 / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class LC_543_DiameterOfBinaryTree {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxPath(root);
        return diameter;
    }

    // maxPath为经过node的单边path的最大节点数
    private int maxPath(TreeNode node) {
        if(node == null) return 0;
        int leftPath = maxPath(node.left);
        int rightPath = maxPath(node.right);
        if (leftPath + rightPath > diameter) {
            diameter = leftPath + rightPath;
        }
        return Math.max(leftPath, rightPath) + 1;
    }


}
