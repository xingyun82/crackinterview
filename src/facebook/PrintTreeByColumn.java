package facebook;

import common.*;
import java.util.*;


/**
 * 这种方法的缺点是 同一列得数据，可能不是从上到下的，可以在DoubleLinkedNode里加上level信息，最后每一列数据按level排序即可
 * Created by xingyun on 9/30/15.
 */
public class PrintTreeByColumn {


    class DoubleLinkedNode {
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
        List<Integer> vals = new ArrayList<Integer>();
    }

    public void print(TreeNode root) {
        if(root == null) return;
        DoubleLinkedNode node = new DoubleLinkedNode();
        print(root, node);
        while(node.prev != null) {
            node = node.prev;
        }
        while(node != null) {
            for(int i:node.vals) {
                System.out.print(i + " ");
            }
            node = node.next;
        }
    }

    public void print(TreeNode root, DoubleLinkedNode node) {
        if(root == null) return;
        node.vals.add(root.val);
        if(root.left != null) {
            if(node.prev == null) {
                node.prev = new DoubleLinkedNode();
                node.prev.next = node;
            }
            print(root.left, node.prev);
        }
        if(root.right != null) {
            if(node.next == null) {
                node.next = new DoubleLinkedNode();
                node.next.prev = node;
            }
            print(root.right, node.next);
        }
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node9.right = node10;

        PrintTreeByColumn inst = new PrintTreeByColumn();
        inst.print(node1);

    }

}
