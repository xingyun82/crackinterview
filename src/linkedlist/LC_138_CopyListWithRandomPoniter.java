package linkedlist;

import common.RandomListNode;

import java.util.*;

/**
 * Created by xingyun on 15/6/27.
 */
public class LC_138_CopyListWithRandomPoniter {

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        Map<RandomListNode, RandomListNode> randomMap = new HashMap<RandomListNode, RandomListNode>();
        // copy list node one by one, and map original node to new node
        RandomListNode nhead = new RandomListNode(head.label);
        nhead.random = head.random;
        randomMap.put(head, nhead);

        RandomListNode np = nhead;
        RandomListNode p = head.next;
        while(p != null) {
            RandomListNode tmp = new RandomListNode(p.label);
            tmp.random = p.random;
            //p.random = tmp;
            randomMap.put(p, tmp);
            np.next = tmp;
            p = p.next;
            np = tmp;
        }
        // go through the new list node, and change the random pointer of new list node to the right node
        np = nhead;

        while(np != null) {
            if(np.random != null) {
                np.random = randomMap.get(np.random);
            }
            np = np.next;
        }

        return nhead;
    }

    private void printList(RandomListNode np) {
        while(np!= null) {
            System.out.println(np.label);
            if(np.next != null) {
                System.out.println(" ->" + np.next.label);
            }
            if(np.random != null) {
                System.out.println("-->" + np.random.label);
            }
            System.out.println("--------");
            np = np.next;
        }
    }

    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);

        n1.next = n2;
        n1.random = n5;

        n2.next = n3;
        n2.random = n4;

        n3.next = n4;
        n3.random = n1;

        n4.next = n5;

        n5.random = n2;


        LC_138_CopyListWithRandomPoniter inst = new LC_138_CopyListWithRandomPoniter();

        System.out.println("before deep copy");
        inst.printList(n1);

        System.out.println("deep copy");
        inst.printList(inst.copyRandomList(n1));

        System.out.println("original list");
        inst.printList(n1);
    }

}
