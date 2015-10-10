package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xingyun on 10/6/15.
 */
public class LRUCache2<K, V> {

    class DLinkedNode {
        K key;
        V value;
        long timestamp;
        long ttl = Long.MAX_VALUE;
        DLinkedNode pre;
        DLinkedNode post;
        DLinkedNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.timestamp = System.currentTimeMillis();
        }

        DLinkedNode(K key, V value, long ttl) {
            this.key = key;
            this.value = value;
            this.timestamp = System.currentTimeMillis();
            this.ttl = ttl;
        }

        public boolean isExpired() {
            if(ttl < System.currentTimeMillis() - timestamp) {
                return true;
            }
            return false;
        }
    }

    Map<K, DLinkedNode> cacheHash = new HashMap<K, DLinkedNode>();
    DLinkedNode head = new DLinkedNode(null, null);
    DLinkedNode tail = new DLinkedNode(null, null);

    int capacity = 0;
    int size = 0;

    public LRUCache2(int capacity) {
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

    public V get(K key) {
        DLinkedNode node = cacheHash.get(key);
        if(node != null) {
            // check if node is expired
            // if expired, then remove this node
            if(node.isExpired()) {
                cacheHash.remove(key);
                removeNode(node);
                size--;
                return null;
            }
            // else, move to the head
            moveToHead(node);
            return node.value;
        }
        return null;
    }

    public void set(K key, V value, long ttl) {
        DLinkedNode node = cacheHash.get(key);
        if(node == null) {
            node = new DLinkedNode(key, value, ttl);
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
            node.ttl = ttl;
            moveToHead(node);
        }
    }

    public void set(K key, V value) {
        set(key, value, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        //2,[get(2),set(2,6),get(1),set(1,5),set(1,2),get(1),get(2)
        LRUCache2<Integer, Integer> inst = new LRUCache2<Integer, Integer>(2);
        System.out.println(inst.get(2));
        inst.set(2, 6);
        System.out.println(inst.get(1));
        inst.set(1, 5);
        inst.set(1, 2);

        System.out.println(inst.get(1));
        System.out.println(inst.get(2));

        inst.set(1, 4, 1000);
        System.out.println(inst.get(1));
        try {
            Thread.sleep(1001);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(inst.get(1));


    }

}
