package tree;

import common.TreeNode;
import java.util.*;
/**
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]

 * Created by xingyun on 15/7/22.
 */
public class LC_113_PathSumII {


    public void backtracking(List<List<Integer>> res, List<Integer> tmpPath, TreeNode node, int sum) {

        if(node.left == null && node.right == null && node.val == sum) {
            List<Integer> tmpRes = new ArrayList<Integer>();
            tmpRes.addAll(tmpPath);
            res.add(tmpRes);
            return;
        }

        if(node.left != null) {
            tmpPath.add(node.left.val);
            backtracking(res, tmpPath, node.left, sum - node.val);
            tmpPath.remove(tmpPath.size() - 1);
        }
        if(node.right != null) {
            tmpPath.add(node.right.val);
            backtracking(res, tmpPath, node.right, sum - node.val);
            tmpPath.remove(tmpPath.size() - 1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        List<Integer> tmpPath = new ArrayList<Integer>();
        tmpPath.add(root.val);
        backtracking(res, tmpPath, root, sum);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;

        LC_113_PathSumII inst = new LC_113_PathSumII();
        List<List<Integer>> res = inst.pathSum(node1, 22);
        for(int i=0; i<res.size(); ++i) {
            for(int j:res.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }



    }
}
