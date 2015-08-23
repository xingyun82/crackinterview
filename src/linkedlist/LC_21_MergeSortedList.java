package linkedlist;

import common.*;
/**
 * Created by xingyun on 15/8/23.
 */
public class LC_21_MergeSortedList {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val > l2.val) { ListNode tmp = l1; l1 = l2; l2 = tmp; }
        ListNode res = l1;

        while(l1 != null && l2 != null) {
            // forward l1
            ListNode pre = l1;
            while(l1 != null && l1.val < l2.val) {
                pre = l1;
                l1 = l1.next;
            }
            pre.next = l2;
            // swap l1 and l2
            { ListNode tmp = l1; l1 = l2; l2 = tmp; }
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        LC_21_MergeSortedList inst = new LC_21_MergeSortedList();
        ListNode res = inst.mergeTwoLists(l1, l2);
        res.printList();
    }
}
