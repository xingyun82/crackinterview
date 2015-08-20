package tree;

import java.util.*;
import common.*;
/**
 *
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 * Created by xingyun on 15/8/20.
 */
public class LC_257_BinaryTreePaths {

    private void backtracking(List<String> res, String path, TreeNode node) {
        if(node.left == null && node.right == null) {
            res.add(path);
            return;
        }
        if(node.left != null) {
            backtracking(res, path + "->" + node.left.val, node.left);
        }
        if(node.right != null) {
            backtracking(res, path + "->" + node.right.val, node.right);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        backtracking(res, String.valueOf(root.val), root);
        return res;
    }
}
