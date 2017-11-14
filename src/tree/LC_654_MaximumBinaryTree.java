package tree;

import common.TreeNode;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

 The root is the maximum number in the array.
 The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 Construct the maximum tree by the given array and output the root node of this tree.

 Example 1:
 Input: [3,2,1,6,0,5]
 Output: return the tree root node representing the following tree:

 6
 /   \
 3     5
 \    /
 2  0
 \
 1
 Note:
 The size of the given array will be in the range [1,1000].

 */

public class LC_654_MaximumBinaryTree {

    // recursive method
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i=start; i<=end; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = construct(nums, start, maxIdx-1);
        root.right = construct(nums, maxIdx+1, end);
        return root;
    }

//    // non recursive method
//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        Stack<TreeNode> stack = new Stack<>();
//        for (int num: nums){
//            TreeNode cur = new TreeNode(num);
//            while (!stack.isEmpty() && stack.peek().val < cur.val){
//                cur.left = stack.pop();
//            }
//
//            if (!stack.isEmpty()){
//                stack.peek().right = cur;
//            }
//            stack.push(cur);
//        }
//        return stack.get(0);
//    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        LC_654_MaximumBinaryTree inst = new LC_654_MaximumBinaryTree();
        TreeNode root = inst.constructMaximumBinaryTree(nums);
        root.printTree();
    }
}
