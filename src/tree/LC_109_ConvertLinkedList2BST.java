package tree;

import common.ListNode;
import common.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * Created by xingyun on 15/7/24.
 */
public class LC_109_ConvertLinkedList2BST {


    // Time complexity: O(nlogn)
    /*
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;

        while(fast !=null && fast.next!= null && fast.next.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode parent = new TreeNode(slow.next.val);
        if(slow != pre) {
            TreeNode right = sortedListToBST(slow.next.next);
            slow.next = null;
            TreeNode left = sortedListToBST(pre.next);
            parent.right = right;
            parent.left = left;
        }

        return parent;
    }
    */

    // following algorithm is O(n)
    private int nodeCount(ListNode head) {
        ListNode node = head;
        int count = 0;
        while(node != null) {
            count++;
            node = node.next;
        }
        return count;

    }

    ListNode cur;

    private TreeNode doBuildBST(int n) {
        if(n == 0) return null;
        TreeNode node = new TreeNode(0);
        node.left = doBuildBST(n/2);
        node.val = cur.val;
        cur = cur.next;
        node.right = doBuildBST(n-n/2-1);
        return node;
    }


    public TreeNode sortedListToBST(ListNode head) {
        int nodeCount = nodeCount(head);
        cur = head;
        return doBuildBST(nodeCount);
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        LC_109_ConvertLinkedList2BST inst = new LC_109_ConvertLinkedList2BST();
        TreeNode root = inst.sortedListToBST(node1);
        root.printTree();


    }
}
