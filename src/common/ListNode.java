package common;

/**
 * Created by xingyun on 15/6/23.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public void printList() {
        ListNode p = this;
        while(p != null) {
            System.out.print(p.val + ",");
            p = p.next;
        }
        System.out.println();
    }
}