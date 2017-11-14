package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_652_FindDuplicateSubtrees {

    private String doFind(TreeNode node, Map<String, Boolean> traversalPathMap, List<TreeNode> result) {
        if (node == null) return null;
        String leftPath = doFind(node.left, traversalPathMap, result);
        String rightPath = doFind(node.right, traversalPathMap, result);
        String traversalPath =  leftPath + "," + rightPath + "," + node.val;
        System.out.println(traversalPath);
        if (traversalPathMap.containsKey(traversalPath)) {
            if (!traversalPathMap.get(traversalPath)) { // duplicate
                result.add(node);
                traversalPathMap.put(traversalPath, true);
            }
        } else {
            traversalPathMap.put(traversalPath, false);
        }
        return traversalPath;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        doFind(root, new HashMap<String, Boolean>(), result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(0);
//        TreeNode node7 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node5.right = node6;
        LC_652_FindDuplicateSubtrees inst = new LC_652_FindDuplicateSubtrees();
        List<TreeNode> treeNodes = inst.findDuplicateSubtrees(node1);
        for (TreeNode treeNode : treeNodes) {
            treeNode.printTree();
        }
    }
}
