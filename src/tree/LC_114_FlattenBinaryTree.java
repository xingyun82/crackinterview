package tree;

import common.TreeNode;

/**
 *
 * Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6


 * Created by xingyun on 15/7/20.
 */
public class LC_114_FlattenBinaryTree {

    /*
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode parent = new TreeNode(0);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            parent.right = node;
            parent = node;
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }

        }
    }
    */

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode last = cur.left;
                while (last.right != null) last = last.right;
                last.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        LC_114_FlattenBinaryTree inst = new LC_114_FlattenBinaryTree();
        inst.flatten(node1);

        TreeNode node = node1;
        while(node!= null) {
            System.out.println(node.val);
            node = node.right;
        }
    }
}
