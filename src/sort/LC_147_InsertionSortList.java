package sort;


import java.util.*;
import common.*;
/**
 *
 * Sort a linked list using insertion sort.
 *
 * Created by xingyun on 15/8/20.
 *
 */
public class LC_147_InsertionSortList {

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

}
