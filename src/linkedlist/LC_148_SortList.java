package linkedlist;

import common.ListNode;

/**
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 * Created by xingyun on 15/6/21.
 */
public class LC_148_SortList {

    public ListNode mergeLinkedList(ListNode p1, ListNode p2) {
        // merge two sub lists
        ListNode pre = new ListNode(0);
        ListNode p = pre;
        while(p1 != null && p2 != null) {
            if(p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if(p1 != null) {
            p.next = p1;
        }

        if(p2 != null) {
            p.next = p2;
        }

        return pre.next;
    }

    public ListNode mergeSort(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode faster = head;
        ListNode slower = head;

        while(faster != null && faster.next != null) {
            faster = faster.next.next;
            if(slower.next != null && slower.next.next != null) {
                slower = slower.next;
            }

        }

        // divide and conquor
        ListNode rightHead = mergeSort(slower.next);
        slower.next = null;
        ListNode leftHead = mergeSort(head);

        if(rightHead == null) return leftHead;
        if(leftHead == null) return rightHead;

        // merge two sub lists
        return mergeLinkedList(leftHead, rightHead);
    }

    public ListNode quickSort(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        //if(head == end) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        int pivot = head.val;
        ListNode p = head;
        while(p.next != null) {
            if(p.next.val < pivot) {
                // remove from right
                ListNode tmp = p.next;
                p.next = p.next.next;
                // insert into left
                tmp.next = pre.next;
                pre.next = tmp;
            } else {
                p = p.next;
            }
        }
        ListNode rightHead = quickSort(head.next);
        head.next = null;
        ListNode leftHead = quickSort(pre.next);
        head.next = rightHead;
        return leftHead;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p = pre;
        while(p.next != null) {
            ListNode cur = pre;
            while(cur != p && cur.next.val <= p.next.val) {
                cur = cur.next;
            }
            if(cur != p) {
                // remove p
                ListNode tmp = p.next;
                p.next = p.next.next;
                // add to cur
                tmp.next = cur.next;
                cur.next = tmp;
            } else {
                p = p.next;
            }
        }
        return pre.next;
    }

    public ListNode sortList(ListNode head) {
        //return quickSort(head);
        //return mergeSort(head);
        return insertionSortList(head);
    }

    public static void main(String[] args) {
        LC_148_SortList inst = new LC_148_SortList();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = inst.sortList(node1);
        ListNode p = head;
        while(p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }
}
