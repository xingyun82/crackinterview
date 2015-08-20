package tree;


import java.util.*;
import common.*;
/**
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 1
 \
 2
 /
 3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?



 * Created by xingyun on 15/8/20.
 */
public class LC_94_BinaryTreeInorderTraversal {

    // main idea: use stack to store the nodes in order
    // use set to store the visted nodes
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> set = new HashSet<TreeNode>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.left == null && node.right == null) { res.add(node.val); continue; }
            // if non-leaf node is visited the first time, store it in set, and push back in stack and its children
            if(!set.contains(node)) {
                set.add(node);
                if(node.right != null) stack.push(node.right);
                stack.push(node);
                if(node.left != null) stack.push(node.left);
            } else { // if non-leaf node is visited the second time, just pop
                res.add(node.val);
            }
        }
        return res;
    }
}
