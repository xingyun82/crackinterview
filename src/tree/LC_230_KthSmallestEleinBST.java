package tree;


import common.*;
import java.util.*;
/**
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 How would you optimize the kthSmallest routine?
 * Created by xingyun on 15/8/20.
 */
public class LC_230_KthSmallestEleinBST {

    // main idea: use stack to output the bst in order
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        Set<TreeNode> treeSet = new HashSet<TreeNode>();

        int i = 0;
        treeStack.push(root);
        while(!treeStack.isEmpty()) {
            TreeNode node = treeStack.pop();
            if(treeSet.contains(node)) {
                i++;
                if(i==k) return node.val;
                continue;
            }
            treeSet.add(node);
            if(node.right != null) treeStack.push(node.right);
            treeStack.push(node);
            if(node.left != null) treeStack.push(node.left);
        }
        return -1;
    }
}
