package linkedlist;

import common.*;

/**
 * Created by xingyun on 15/8/14.
 */
public class LC_234_Palindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        // reverse right link list
        ListNode p1 = null;
        ListNode p2 = head2;
        while (p2 != null) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        // compare two sub linklist
        p2 = head;
        while (p2 != null && p1 != null) {
            if (p2.val != p1.val) return false;
            p2 = p2.next;
            p1 = p1.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        //ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        //node3.next = node4;
        LC_234_Palindrome inst = new LC_234_Palindrome();
        System.out.println(inst.isPalindrome(node1));
    }
}
