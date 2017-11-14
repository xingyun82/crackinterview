package tree;

import common.TreeNode;
import common.Utility;

import java.util.ArrayList;
import java.util.List;

public class LC_655_PrintBinaryTree {

    private int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;

    }

    private List<List<String>> initialize(int m, int n) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                row.add("");
            }
            result.add(row);
        }
        return result;
    }

    void printTree(TreeNode node, int x1, int y1, int x2, int y2, List<List<String>> result) {
        if (node == null) return;
        if (x1 > x2 || y1 > y2) return;
        result.get(x1).set((y2+y1)/2, String.valueOf(node.val));
        printTree(node.left, x1+1, y1, x2, (y1+y2)/2-1, result);
        printTree(node.right, x1+1, (y1+y2)/2+1, x2, y2, result);
    }

    public List<List<String>> printTree(TreeNode root) {
        int treeHeight = getTreeHeight(root);
        int rowSize = (int)Math.pow(2, treeHeight) - 1;
        List<List<String>> result = initialize(treeHeight, rowSize);
        printTree(root, 0, 0, treeHeight-1, rowSize-1, result);
        return result;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node6.right = node7;

        LC_655_PrintBinaryTree inst = new LC_655_PrintBinaryTree();
        List<List<String>> result = inst.printTree(node5);
        for (int i=0; i<result.size(); ++i) {
            for (int j=0; j<result.get(i).size(); ++j) {
                if (result.get(i).get(j) != null && !result.get(i).get(j).isEmpty()) {
                    System.out.print(result.get(i).get(j));
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }

    }
}
