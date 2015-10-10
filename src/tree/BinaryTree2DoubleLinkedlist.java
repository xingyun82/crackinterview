package tree;

import common.*;
/**
 * Created by xingyun on 10/8/15.
 */
public class BinaryTree2DoubleLinkedlist {

    class DLinkNode {
        DLinkNode prev;
        DLinkNode next;
        int val;
        public DLinkNode(int val) {this.val = val;}
    }

    class HeadTail {
        DLinkNode head;
        DLinkNode tail;
    }

    HeadTail doBT2DLL(TreeNode tnode) {
        if(tnode == null) return null;
        HeadTail ht = new HeadTail();
        DLinkNode dnode = new DLinkNode(tnode.val);
        if(tnode.left != null) {
            HeadTail htl = doBT2DLL(tnode.left);
            htl.tail.next = dnode;
            dnode.prev = htl.tail;
            ht.head = htl.head;
        } else {
            ht.head = dnode;
        }
        if(tnode.right != null) {
            HeadTail htr = doBT2DLL(tnode.right);
            htr.head.prev = dnode;
            dnode.next = htr.head;
            ht.tail = htr.tail;
        } else {
            ht.tail = dnode;
        }
        return ht;
    }

    DLinkNode bt2dll(TreeNode tnode) {
        return doBT2DLL(tnode).head;
    }

    public static void main(String[] args) {
        BinaryTree2DoubleLinkedlist inst = new BinaryTree2DoubleLinkedlist();
        TreeNode tnode1 = new TreeNode(1);
        TreeNode tnode2 = new TreeNode(2);
        TreeNode tnode3 = new TreeNode(3);
        TreeNode tnode4 = new TreeNode(4);
        TreeNode tnode5 = new TreeNode(5);
        TreeNode tnode6 = new TreeNode(6);
        TreeNode tnode7 = new TreeNode(7);
        TreeNode tnode8 = new TreeNode(8);
        TreeNode tnode9 = new TreeNode(9);
        tnode1.left = tnode2;
        tnode1.right = tnode3;
        tnode2.left = tnode4;
        tnode2.right = tnode5;
        tnode3.left = tnode6;
        tnode3.right = tnode7;
        tnode4.left = tnode8;
        tnode5.right = tnode9;
        DLinkNode head = inst.bt2dll(tnode1);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
