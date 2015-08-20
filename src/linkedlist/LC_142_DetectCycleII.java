package linkedlist;

import common.ListNode;
/**
 * Created by xingyun on 15/6/23.
 */
public class LC_142_DetectCycleII {




    /**
     * 1. get catch point with two points(fast/slow)
     * 2. split the cycle on that point
     * 3. get the intersection/joint node
     *
     * 如果允许修改每个node的val，可以用染色的方法
     * node = head
     * while(node != null) {
     *  node.val = 999999;
     *  if(node.next.val == 999999) return node.next;
     * }
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        LC_141_DetectCycle detector = new LC_141_DetectCycle();
        ListNode p = detector.getCatchPoint(head);
        if(p == null) return null;

        // split the cycle on the catch point, then get the intersection node
        ListNode head2 = p.next;
        p.next = null;
        LC_160_GetIntersectionNode inst = new LC_160_GetIntersectionNode();
        return inst.getIntersectionNode(head, head2);


        // another way is a little magic
        // suppose the distance between head and joint point is K, then it can be
        // proved that the catch point is also K distance far from the joint.
        /*
        ListNode p1 = head;
        while(p1 != p) {
            p1 = p1.next;
            p = p.next;
        }
        return p;
        */
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
        LC_142_DetectCycleII inst = new LC_142_DetectCycleII();
        System.out.println(inst.detectCycle(n1).val);
    }


}
