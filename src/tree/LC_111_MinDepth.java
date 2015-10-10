package tree;


import common.TreeNode;

import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root
 node down to the nearest leaf node.

 * Created by xingyun on 15/7/22.
 */
public class LC_111_MinDepth {

    public int minDepth(TreeNode root) {
        int depth = 0;
        if(root == null) return depth;

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        Queue<TreeNode> tmp;

        queue1.offer(root);
        while(!queue1.isEmpty()) {
            depth++;
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                // reach leaf node
                if(node.left == null && node.right == null) return depth;
                if (node.left != null) {
                    queue2.offer(node.left);
                }
                if(node.right != null) {
                    queue2.offer(node.right);
                }
            }
            // swap queue1 and stack2
            tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }

        return depth;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;

        LC_111_MinDepth inst = new LC_111_MinDepth();
        System.out.println(inst.minDepth(node1));

    }
}
