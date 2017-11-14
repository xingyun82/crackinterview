package tree;

import common.TreeNode;
import dp.LC_650_2KeysKeyboard;

import java.util.ArrayList;
import java.util.List;

public class LC_653_TwoSumBST {

    private void inOrderTravle(TreeNode root, List<Integer> nodeValues) {
        if (root.left != null) {
            inOrderTravle(root.left, nodeValues);
        }
        nodeValues.add(root.val);
        if (root.right != null){
            inOrderTravle(root.right, nodeValues);
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        List<Integer> nodeValues = new ArrayList<>();
        inOrderTravle(root, nodeValues);
        System.out.println(nodeValues);
        int l = 0, r = nodeValues.size() - 1;
        while (l < r) {
            int sum = nodeValues.get(l) + nodeValues.get(r);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                r--;
            } else if (sum < k) {
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node6.right = node7;

        LC_653_TwoSumBST inst = new LC_653_TwoSumBST();
        System.out.println(inst.findTarget(node7, 14));
    }
}
