package tree;

import common.*;
import java.util.*;
/**
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]

 * Created by xingyun on 15/7/24.
 */
public class LC_107_LevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(root);

        while(!queue1.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            while(!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue2.offer(node.left);
                }
                if(node.right != null) {
                    queue2.offer(node.right);
                }
            }
            res.add(0, list);
            Queue<TreeNode> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
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
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        LC_107_LevelOrderTraversalII inst = new LC_107_LevelOrderTraversalII();
        List<List<Integer>> res = inst.levelOrderBottom(node1);
        Utility<Integer> utility = new Utility<Integer>();
        utility.printListCollection(res);

    }
}
