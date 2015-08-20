package linkedlist;

import common.ListNode;

/**
 * Created by xingyun on 15/6/23.
 */
public class LC_143_ReorderList {

    private ListNode invertLinkedList(ListNode head) {
        if(head == null) return null;
        ListNode p1 = head.next;
        ListNode p2 = head;
        p2.next = null;
        while(p1 != null) {
            ListNode tmp = p1.next;
            p1.next = p2;
            p2 = p1;
            p1 = tmp;
        }
        return p2;
    }

    private ListNode merge(ListNode p1, ListNode p2) {
        ListNode head = p1;
        while(p1 != null && p2 != null) {
            ListNode tmp = p1.next;
            p1.next = p2;
            p1 = p2;
            p2 = tmp;
        }
        return head;
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode faster = head;
        ListNode slower = head;
        while(faster.next != null && faster.next.next != null) {
            faster = faster.next.next;
            slower = slower.next;
        }

        ListNode head2 = invertLinkedList(slower.next);
        slower.next = null;
        head = merge(head, head2);
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
        LC_143_ReorderList inst = new LC_143_ReorderList();
        //common.ListNode p = inst.invertLinkedList(node1);
        ListNode p = node1;
        inst.reorderList(node1);
        while(p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
