package linkedlist; /**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */

import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class common.ListNode {
 *     int val;
 *     common.ListNode next;
 *     common.ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class LC_2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0); // 链表注意这个技巧
        ListNode l3 = tmp; int bit = 0;

        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val+bit;
            int carry = sum%10;

            tmp.next = new ListNode(carry);
            tmp = tmp.next;

            bit = sum/10;

            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + bit;
            int carry = sum%10;
            tmp.next = new ListNode(carry);
            tmp = tmp.next;

            bit = sum/10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + bit;
            int carry = sum%10;
            tmp.next = new ListNode(carry);
            tmp = tmp.next;

            bit = sum/10;
            l2 = l2.next;
        }

        if(bit != 0) {
            tmp.next = new ListNode(bit);
        }

        return l3.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);
        LC_2_AddTwoNumbers c = new LC_2_AddTwoNumbers();
        ListNode l3 = c.addTwoNumbers(l1, l2);
        while(l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }

    }
}