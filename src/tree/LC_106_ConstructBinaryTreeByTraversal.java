package tree;

import common.*;
import java.util.*;
/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Created by xingyun on 15/7/24.
 */
public class LC_106_ConstructBinaryTreeByTraversal {


    /**
     * build tree by divide and conquer
     * @param inorderMap inorderval -> inorderidx
     * @param inorder
     * @param inorderLow
     * @param inorderHigh
     * @param postorder
     * @param postorderLow
     * @param postorderHigh
     * @return
     */
    public TreeNode build(
            Map<Integer, Integer> inorderMap,
            int[] inorder, int inorderLow, int inorderHigh,
            int[] postorder, int postorderLow, int postorderHigh) {

        if(inorderLow>inorderHigh || postorderLow > postorderHigh) return null;

        int root = postorder[postorderHigh];
        TreeNode rootNode = new TreeNode(root);
        int rootInorderIdx = inorderMap.get(root);
        // left
        TreeNode leftNode = build(inorderMap,
                inorder, inorderLow, rootInorderIdx-1,
                postorder, postorderLow, postorderLow+(rootInorderIdx-inorderLow)-1);
        // right
        TreeNode rightNode = build(inorderMap,
                inorder, rootInorderIdx+1, inorderHigh,
                postorder, postorderHigh - (inorderHigh-rootInorderIdx), postorderHigh-1);
        rootNode.left = leftNode;
        rootNode.right = rightNode;
        return rootNode;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; ++i) {
            inOrderMap.put(inorder[i],i);
        }
        TreeNode rootNode = build(inOrderMap, inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        return rootNode;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{1};
        int[] postorder = new int[]{1};
        LC_106_ConstructBinaryTreeByTraversal inst = new LC_106_ConstructBinaryTreeByTraversal();
        TreeNode rootNode = inst.buildTree(inorder, postorder);
        rootNode.printTree();
    }
}
