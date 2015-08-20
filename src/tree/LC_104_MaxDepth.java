package tree;

import common.*;
/**
 *
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 * Created by xingyun on 15/7/24.
 */
public class LC_104_MaxDepth {



    public int maxDepth(TreeNode root) {
        int max = 0;
        TreeNode node = root;
        if(node == null) return max;
        max = Math.max(max, maxDepth(root.left)+1);
        max = Math.max(max, maxDepth(root.right)+1);
        return max;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

//        node1.left = node2;
//        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;
//        node5.right = node6;

        LC_104_MaxDepth inst = new LC_104_MaxDepth();
        System.out.println(inst.maxDepth(node1));


    }
}
