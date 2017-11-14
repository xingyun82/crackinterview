package stack_queue_heap;

import common.ListNode;

import java.util.PriorityQueue;

public class LC_23_MergeKSortedList {

    // Solution1: Heap
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tmp.next = node;
            tmp = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }

    // Solution2: Divide-and-Conquer
    public ListNode mergeKLists2(ListNode[] lists) {
        return mergeKLists2(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists2(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start+1 == end) {
            return mergeLists(lists[start], lists[end]);
        }
        int mid = start + (end - start)/2;
        return mergeLists(mergeKLists2(lists, start, mid), mergeKLists2(lists, mid+1, end));
    }

    private ListNode mergeLists(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        while (node1 != null && node2 != null) {
            ListNode node = (node1.val < node2.val) ? node1 : node2;
            tmp.next = node;
            tmp = tmp.next;
            if (node == node1) {
                node1 = node1.next;
            } else {
                node2 = node2.next;
            }
        }
        if (node1 != null) {
          tmp.next = node1;
        }
        if (node2 != null) {
          tmp.next = node2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(11);
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(22);
        ListNode head3 = new ListNode(3);
        head3.next = new ListNode(33);
        ListNode[] lists = {head1, head2, head3};
        LC_23_MergeKSortedList inst = new LC_23_MergeKSortedList();
        ListNode result = inst.mergeKLists2(lists);
        result.printList();
    }
}
