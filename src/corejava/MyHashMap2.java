package corejava;

import java.util.*;
/**
 * Created by xingyun on 10/10/15.
 */
public class MyHashMap2 {

    class Node {
        int key;
        int val;
        public Node(int key, int val) {this.key = key; this.val = val;}
    }

    List<List<Node>> data;
    int MAX_CAPACITY = 1000;

    public MyHashMap2() {
        data = new ArrayList<List<Node>>();
        for(int i=0; i<MAX_CAPACITY; ++i) {
            data.add(new ArrayList<Node>());
        }
    }

    private int hash(int key) {
        return key%MAX_CAPACITY;
    }

    public Integer get(int key) {
        int hkey = hash(key);
        List<Node> list = data.get(hkey);
        for(Node node:list) {
            if(node.key == key) return node.val;
        }
        return null;
    }

    public void set(int key, int val) {
        int hkey = hash(key);
        List<Node> list = data.get(hkey);
        for(Node node:list) {
            if(node.key == key) {
                node.val = val;
                return;
            }
        }
        list.add(new Node(key, val));
    }

    public static void main(String[] args) {
        MyHashMap2 inst = new MyHashMap2();
        System.out.println(inst.get(1));
        inst.set(1, 3);
        System.out.println(inst.get(1));
        inst.set(1, 4);
        System.out.println(inst.get(1));
    }

}
