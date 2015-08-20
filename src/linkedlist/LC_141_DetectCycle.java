package linkedlist;

import common.ListNode;

/**
 * Created by xingyun on 15/6/24.
 */
public class LC_141_DetectCycle {

    public ListNode getCatchPoint(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        if(fast != slow) return null;
        return fast;
    }

    public boolean hasCycle(ListNode head) {
        ListNode catchPoint = getCatchPoint(head);
        if(catchPoint != null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;
        LC_141_DetectCycle inst = new LC_141_DetectCycle();
        System.out.println(inst.hasCycle(n1));
    }

}
