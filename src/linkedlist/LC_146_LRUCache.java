package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xingyun on 15/6/22.
 */

class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
    DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


public class LC_146_LRUCache {

    Map<Integer, DLinkedNode> cacheHash = new HashMap<Integer, DLinkedNode>();
    DLinkedNode head = new DLinkedNode(0, 0);
    DLinkedNode tail = new DLinkedNode(0, 0);

    int capacity = 0;
    int size = 0;

    public LC_146_LRUCache(int capacity) {
        this.capacity = capacity;
        head.post = tail;
        tail.pre = head;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    private void addNode(DLinkedNode node) {
        node.post = head.post;
        head.post.pre = node;

        head.post = node;
        node.pre = head;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    public int get(int key) {
        DLinkedNode node = cacheHash.get(key);
        if(node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        DLinkedNode node = cacheHash.get(key);
        if(node == null) {
            node = new DLinkedNode(key, value);
            cacheHash.put(key, node);
            addNode(node);
            size++;

            if(size > capacity) {
                //remove from tail
                cacheHash.remove(tail.pre.key);
                removeNode(tail.pre);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }


    public static void main(String[] args) {
        //2,[get(2),set(2,6),get(1),set(1,5),set(1,2),get(1),get(2)
        LC_146_LRUCache inst = new LC_146_LRUCache(2);
        System.out.println(inst.get(2));
        inst.set(2, 6);
        System.out.println(inst.get(1));
        inst.set(1, 5);
        inst.set(1, 2);

        System.out.println(inst.get(1));
        System.out.println(inst.get(2));

    }

}
