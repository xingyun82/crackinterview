package corejava;

import java.util.*;
/**
 * Created by xingyun on 10/10/15.
 */
public class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;
        public Node(int key, int val) {this.key = key; this.val = val; }

    }
    List<Node> data;
    private int MAX_CAPACITY = 1000;


    public MyHashMap() {
        data = new ArrayList<Node>();
        for(int i=0; i<MAX_CAPACITY; ++i) {
            data.add(null);
        }
    }

    private int hash(int key) {
        return key%MAX_CAPACITY;
    }

    public Integer get(int key) {
        int hkey = hash(key);
        Node node = data.get(hkey);
        while(node != null) {
            if(node.key == key) return node.val;
            node = node.next;
        }
        return null;
    }

    public void set(int key, int val) {
        int hkey = hash(key);
        Node node = data.get(hkey);
        if(node == null) {
            data.set(hkey, new Node(key,val));
        } else {
            Node pre = null;
            while (node != null) {
                if (node.key == key) {
                    node.val = val;
                    return;
                }
                pre = node;
                node = node.next;
            }
            pre.next = new Node(key, val);
        }
    }

    public static void main(String[] args) {
        MyHashMap inst = new MyHashMap();
        System.out.println(inst.get(1));
        inst.set(1, 3);
        System.out.println(inst.get(1));
        inst.set(1, 4);
        System.out.println(inst.get(1));
    }


}
