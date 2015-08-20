package linkedlist;

import common.ListNode;

/**
 * Created by xingyun on 15/8/9.
 */
public class LC_206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode p2 = head;
        ListNode p1 = p2.next;
        ListNode tmp = null;
        while(p1 != null) {
            tmp = p1.next;
            p1.next = p2;
            p2 = p1;
            p1 = tmp;
        }
        head.next = null;
        return p2;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        LC_206_ReverseLinkedList inst = new LC_206_ReverseLinkedList();
        ListNode node = inst.reverseList(node1);
        node.printList();

    }

}
