package linkedlist;

import common.*;
/**
 * Reverse a linked list in groups of size k.
 * Created by xingyun on 10/8/15.
 */
public class Amazon_ReverseLinkedListByKGroup {

    public ListNode reverseByGroup(ListNode head, int k) {

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        int count = 0;

        ListNode resHead = null;  // return head
        ListNode lastTail = null; // tail of last group
        ListNode newTail = head;  // tail of new group
        ListNode newHead = null;  // head of new group

        while(cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            count++;
            if(count == k) {
                newHead = pre; // set new head
                if(resHead == null) { // set return head if needed
                    resHead = newHead;
                }
                if(lastTail != null) { // connect with last group
                    lastTail.next = newHead;
                }
                lastTail = newTail; // set tail of last group
                newTail = cur;
                count = 0;
                pre = null; // for the start of each k segs, pre should be set to null
            }
        }
        if(count != 0) {
            lastTail.next = pre;
        }
        return resHead;
    }

    public static void main(String[] args) {
        Amazon_ReverseLinkedListByKGroup inst = new Amazon_ReverseLinkedListByKGroup();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;

        ListNode res = inst.reverseByGroup(head, 6);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
