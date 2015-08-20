package tree;


import java.util.*;
import common.*;
/**
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]


 * Created by xingyun on 15/7/24.
 */
public class LC_103_LevelOrderZigzagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;

        Stack<TreeNode> queue1 = new Stack<TreeNode>();
        Stack<TreeNode> queue2 = new Stack<TreeNode>();
        queue1.push(root);

        int zigzag = 0;

        while(!queue1.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            while(!queue1.isEmpty()) {
                TreeNode node = queue1.pop();
                list.add(node.val);
                if(zigzag == 0) {
                    if (node.left != null) {
                        queue2.push(node.left);
                    }
                    if (node.right != null) {
                        queue2.push(node.right);
                    }
                } else if(zigzag == 1) {
                    if (node.right != null) {
                        queue2.push(node.right);
                    }
                    if (node.left != null) {
                        queue2.push(node.left);
                    }
                }
            }
            if(zigzag == 0) zigzag = 1;
            else if(zigzag == 1) zigzag = 0;
            res.add(list);
            Stack<TreeNode> tmp = queue1;
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

        LC_103_LevelOrderZigzagTraversal inst = new LC_103_LevelOrderZigzagTraversal();
        List<List<Integer>> res = inst.zigzagLevelOrder(node1);
        Utility<Integer> utility = new Utility<Integer>();
        utility.printListCollection(res);

    }
}
