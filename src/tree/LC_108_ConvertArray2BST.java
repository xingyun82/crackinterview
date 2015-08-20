package tree;

import common.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * Created by xingyun on 15/7/24.
 */
public class LC_108_ConvertArray2BST {

    public TreeNode convert(int[] nums, int low, int high) {
        if(low > high) return null;
        int mid = (low+high)>>>1;

        TreeNode parent = new TreeNode(nums[mid]);
        TreeNode left = convert(nums, low, mid-1);
        TreeNode right = convert(nums, mid+1, high);
        parent.right = right;
        parent.left = left;

        return parent;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return convert(nums, 0, nums.length-1);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1};
        LC_108_ConvertArray2BST inst = new LC_108_ConvertArray2BST();
        TreeNode node = inst.sortedArrayToBST(nums);
        node.printTree();
    }
}
