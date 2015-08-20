package tree;

import common.*;
import java.util.*;
/**
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.

 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?


 * Created by xingyun on 15/7/25.
 */

public class LC_99_RecoverTree {

    private void checkGroup(List<TreeNode> tmpGroup, List<TreeNode> errorGroup) {
        if(tmpGroup.size() == 2) {
            TreeNode node1 = tmpGroup.get(0);
            TreeNode node2 = tmpGroup.get(1);
            // check each node is normal
            if(node1.val > node2.val) {
                if(errorGroup.size() == 0) {
                    errorGroup.add(node1);
                    errorGroup.add(node2);
                } else if(node1 != errorGroup.get(0)) {
                    errorGroup.set(1, node2);
                }
            }
            tmpGroup.remove(0);
        }
    }

    private void traversal(TreeNode node, List<TreeNode> tmpGroup, List<TreeNode> errorGroup) {
        if(node == null) return;
        if(node.left != null) {
            traversal(node.left,tmpGroup, errorGroup);
        }
        if(errorGroup.size() == 2 && node.val > errorGroup.get(0).val) return;
        tmpGroup.add(node);
        checkGroup(tmpGroup, errorGroup);
        if(node.right != null) {
            traversal(node.right, tmpGroup, errorGroup);
        }

    }

    private void swap(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

    public void recoverTree(TreeNode root) {
        if(root == null) return;
        List<TreeNode> stack = new ArrayList<TreeNode>();
        List<TreeNode> errorGroup = new ArrayList<TreeNode>();
        traversal(root, stack, errorGroup);
        // swap two error nodes, should consider if the two nodes are parent-child relationship
        if(errorGroup.size() == 2) {
            TreeNode node1 = errorGroup.get(0);
            TreeNode node2 = errorGroup.get(1);
            System.out.println(node1.val + "," + node2.val);
            swap(node1, node2);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        //TreeNode node4 = new TreeNode(1);
        //TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
        //node2.left = node4;
        //node2.right = node5;
        node3.left = node6;

        node1.printTree();
        LC_99_RecoverTree inst = new LC_99_RecoverTree();
        inst.recoverTree(node1);
        System.out.println("after swapping");
        node1.printTree();

    }
}
