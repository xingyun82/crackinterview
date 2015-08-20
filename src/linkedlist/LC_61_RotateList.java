package linkedlist;

import common.*;

/**
 * Created by xingyun on 15/7/27.
 */
public class LC_61_RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;

        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode slow = fast;
        // compute the length
        int len = 0;
        while(fast.next != null) {
            len++;
            fast = fast.next;
        }

        k = k%len;
        if(k==0) return head;
        // locate the kth node
        for(int i=0; i<len-k; ++i) {
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        LC_61_RotateList inst = new LC_61_RotateList();
        ListNode newHead = inst.rotateRight(node1, 1);
        newHead.printList();
    }
}
