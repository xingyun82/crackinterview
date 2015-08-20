package tree;

import common.TreeNode;
import java.util.Stack;


/**
 *
 * Invert a binary tree.

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 to
 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 Trivia:
 This problem was inspired by this original tweet by Max Howell:
 Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.

 * Created by xingyun on 15/6/16.
 */
public class LC_226_ReverseBinaryTree {


    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        treeNodeStack.push(root);
        while(!treeNodeStack.empty()) {
            TreeNode node = treeNodeStack.pop();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if(node.left != null) {
                treeNodeStack.push(node.left);
            }
            if(node.right != null) {
                treeNodeStack.push(node.right);
            }
        }
        return root;
    }


    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return null;
        //if(root.right == null && root.left == null) return root;
        TreeNode rChild = invertTree(root.right);
        TreeNode lChild = invertTree(root.left);
        root.left = rChild;
        root.right = lChild;
        return root;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n7 = new TreeNode(7);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n9 = new TreeNode(9);

        root.left = n2;
        root.right = n7;
        n2.left = n1;
        n2.right = n3;
        n7.left = n6;
        n7.right = n9;


        LC_226_ReverseBinaryTree inst = new LC_226_ReverseBinaryTree();
        root.printTree();

        inst.invertTree2(root);

        root.printTree();


    }
}
