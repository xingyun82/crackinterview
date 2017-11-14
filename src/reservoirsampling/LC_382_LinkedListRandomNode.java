package reservoirsampling;

import common.ListNode;

import java.util.Random;

public class LC_382_LinkedListRandomNode {

    Random rnd;
    ListNode head;


    public LC_382_LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.rnd = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int count = 0;
        int result = 0;
        ListNode node = head;
        while (node != null) {
            if (rnd.nextInt(++count) == 0) {
                result = node.val;
            }
            node = node.next;
        }
        return result;
    }
}
