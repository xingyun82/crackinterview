package tree;

import common.TreeNode;

import java.util.LinkedList;

public class LC_662_MaxWidthOfBinaryTree {

    /**
     * 1. let root is 0, left is negative, right is positive
     * 2. for left node, node.left.val = node.val * 2, node.right.val = node.val * 2 + 1
     * 3. for right node, node.left.val = node.val * 2 - 1, node.right.val = node.val * 2
     * 4. traversal tree by level.
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int maxWidth = Integer.MIN_VALUE;
        LinkedList queue = new LinkedList();
        if (root.left != null) {
            root.left.val = -1;
            queue.offer(root.left);
        }
        if (root.right != null) {
            root.right.val = 1;
            queue.offer(root.right);
        }
        TreeNode levelLast = (TreeNode)queue.getLast();
        TreeNode levelFirst = (TreeNode)queue.getFirst();
        while (!queue.isEmpty()) {
            TreeNode node = (TreeNode)queue.poll();
            // offer children into queue
            if (node.val < 0){
                if (node.left != null) {
                    node.left.val = node.val * 2;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 1;
                    queue.offer(node.right);
                }
            } else if (node.val > 0) {
                if (node.left != null) {
                    node.left.val = node.val * 2 - 1;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2;
                    queue.offer(node.right);
                }
            }
            if (node == levelLast) {
                // reach to level end, compute the width
                // if last.val == first.val, which means the same node
                if (levelLast.val == levelFirst.val) {
                    maxWidth = Math.max(maxWidth, 1);
                } else if ((levelLast.val > 0 && levelFirst.val > 0) || (levelLast.val < 0 && levelFirst.val < 0)) {
                    maxWidth = Math.max(maxWidth, levelLast.val - levelFirst.val + 1);
                } else if (levelLast.val > 0 && levelFirst.val < 0){
                    maxWidth = Math.max(maxWidth, levelLast.val - levelFirst.val);
                }
                if (!queue.isEmpty()) {
                    // reset first and last
                    levelLast = (TreeNode) queue.getLast();
                    levelFirst = (TreeNode) queue.getFirst();
                }
            }
        }
        return maxWidth;
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
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        LC_662_MaxWidthOfBinaryTree inst = new LC_662_MaxWidthOfBinaryTree();
        System.out.println(inst.widthOfBinaryTree(node1));
    }
}
