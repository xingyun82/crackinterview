package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import common.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,2,3].



 *
 * Created by xingyun on 15/6/23.
 */
public class LC_144_BinaryTreePreOrderTravel {



    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }

        return res;
    }


    public List<Integer> layerorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        int i=0;
        while(i<list.size()) {
            TreeNode node = list.get(i);
            res.add(node.val);
            if(node.left != null) {
                list.add(node.left);
            }
            if(node.right != null) {
                list.add(node.right);
            }
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        LC_144_BinaryTreePreOrderTravel inst = new LC_144_BinaryTreePreOrderTravel();
        List<Integer> res = inst.preorderTraversal(node1);
        for(int i:res) {
            System.out.println(i);
        }
    }
}
