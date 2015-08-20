package tree;

import common.*;
import java.util.*;
/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Created by xingyun on 15/7/24.
 */
public class LC_105_ConstructBinaryTreeByTraversal2 {

    private TreeNode build(Map<Integer, Integer> inorderMap,
                           int[] preorder, int preorderLow, int preorderHigh,
                           int[] inorder, int inorderLow, int inorderHigh) {

        if(preorderLow > preorderHigh || inorderLow > inorderHigh) return null;

        int rootInorderIdx = inorderMap.get(preorder[preorderLow]);
        TreeNode rootNode = new TreeNode(preorder[preorderLow]);
        // left
        TreeNode leftNode = build(inorderMap,
                preorder, preorderLow+1, preorderLow+(rootInorderIdx-inorderLow),
                inorder, inorderLow, rootInorderIdx-1);
        // right
        TreeNode rightNode = build(inorderMap,
                preorder, preorderHigh-(inorderHigh-rootInorderIdx)+1, preorderHigh,
                inorder, rootInorderIdx+1, inorderHigh);
        rootNode.left = leftNode;
        rootNode.right = rightNode;
        return rootNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; ++i) {
            inorderMap.put(inorder[i], i);
        }
        return build(inorderMap, preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{4,2,5,1,3,6};
        int[] preorder = new int[]{1,2,4,5,3,6};
        LC_105_ConstructBinaryTreeByTraversal2 inst = new LC_105_ConstructBinaryTreeByTraversal2();
        TreeNode rootNode = inst.buildTree(preorder, inorder);
        rootNode.printTree();
    }
}
