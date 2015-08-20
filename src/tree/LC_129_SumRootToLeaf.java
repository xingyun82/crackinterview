package tree;

import common.TreeNode;
import java.util.Queue;

import java.util.LinkedList;

/**
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.

 * Created by xingyun on 15/7/5.
 */
public class LC_129_SumRootToLeaf {

    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left == null && node.right == null) {
                res += node.val;
                continue;
            }
            if(node.left != null) {
                TreeNode left = new TreeNode(node.val * 10 + node.left.val);
                left.left = node.left.left;
                left.right = node.left.right;
                queue.offer(left);
            }
            if(node.right != null) {
                TreeNode right = new TreeNode(node.val*10 + node.right.val);
                right.left = node.right.left;
                right.right = node.right.right;
                queue.offer(right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        LC_129_SumRootToLeaf inst = new LC_129_SumRootToLeaf();
        System.out.println(inst.sumNumbers(node1));
    }
}
