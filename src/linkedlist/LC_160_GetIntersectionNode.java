package linkedlist;

import common.ListNode;

/**
 * Created by xingyun on 15/6/9.
 */

public class LC_160_GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0;
        int lenB = 0;
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while(tmpA != null) {
            lenA++;
            tmpA = tmpA.next;
        }
        while(tmpB != null) {
            lenB++;
            tmpB = tmpB.next;
        }
        tmpA = headA;
        tmpB = headB;
        if(lenA >= lenB) {
            for(int i=0;i<lenA-lenB;++i) {
                tmpA = tmpA.next;
            }
        }
        else if(lenB > lenA) {
            for(int i=0;i<lenB-lenA;++i) {
                tmpB = tmpB.next;
            }
        }
        while(tmpA != tmpB && tmpA != null && tmpB != null) {
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        if (tmpA == null || tmpB == null) return null;
        return tmpA;

    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a1.next = a2;

        LC_160_GetIntersectionNode inst = new LC_160_GetIntersectionNode();
        ListNode res = inst.getIntersectionNode(a1, a2);
        if(res != null) System.out.println(res.val);

    }
}
