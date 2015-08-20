package linkedlist;

import common.*;
/**
 * Created by xingyun on 15/8/1.
 */
public class LC_82_83_RemoveDupNode {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode p1 = pre;
        ListNode p2 = p1.next;
        while(p2 != null && p2.next != null) {
            if(p2.next.val == p1.next.val) {
                p2 = p2.next;
            } else {
                if(p1.next == p2) {
                    p1 = p2;
                    p2 = p2.next;
                } else {
                    p1.next = p2.next;
                    p2 = p2.next;
                }
            }
        }
        // in normal, p1.next will be p2
        if(p1.next != p2) {
            p1.next = p2.next;
        }
        return pre.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        LC_82_83_RemoveDupNode inst = new LC_82_83_RemoveDupNode();
        ListNode newHead = inst.deleteDuplicates(node1);
        newHead.printList();

    }


}
