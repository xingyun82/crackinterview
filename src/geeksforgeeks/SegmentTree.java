package geeksforgeeks;

import common.*;

import java.util.Stack;

/**
 * Created by xingyun on 15/8/3.
 */
public class SegmentTree {

    public int constructSTUtil(int[] arr, int ss, int se, int[] st, int si) {
        if(ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
        int mid = ss + (se-ss)/2;
        st[si] = constructSTUtil(arr, ss, mid, st, si*2+1) +
                constructSTUtil(arr, mid+1, se, st, si*2+2);
        return st[si];
    }

    public int[] constructST(int[] arr, int n) {
        int x = (int)Math.ceil(Math.log(n)/Math.log(2));
        int max_size = 2*(int)Math.pow(2, x);
        int[] st = new int[max_size];

        constructSTUtil(arr, 0, n-1, st, 0);
        return st;
    }


    public TreeNode doConstructST(int[] arr, int low, int high) {

        if(low == high) {
            TreeNode node = new TreeNode(arr[low]);
            return node;
        }
        int mid = (low+high)>>>1;
        TreeNode leftNode = doConstructST(arr, low, mid);
        TreeNode rightNode = doConstructST(arr, mid + 1, high);
        TreeNode midNode = new TreeNode(leftNode.val + rightNode.val);
        midNode.left = leftNode;
        midNode.right = rightNode;
        return midNode;
    }

    public TreeNode constructST(int[] arr) {
        return doConstructST(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9,11};
        SegmentTree inst = new SegmentTree();
//        int[] res = inst.constructST(arr, arr.length);
//        for(int i:res) {
//            System.out.print(i + ",");
//        }
        TreeNode node = inst.constructST(arr);
        node.printTree();

    }
}
