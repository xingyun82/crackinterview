package tree;

/**
 * get a node rank in BST
 * Created by xingyun on 10/6/15.
 */
public class Zenefits_BSTRank {

    class Node {
        int val;
        Node left;
        Node right;
        int leftCount;
        int rightCount;
        public Node(int val) {this.val = val;}
    }

    Node root;


    private void addNode(Node node, int x) {

        if(node.val > x) {
            node.leftCount++;
            if(node.left == null) {
                node.left = new Node(x);
            } else {
                addNode(node.left, x);
            }
        } else {
            node.rightCount++;
            if(node.right == null) {
                node.right = new Node(x);
            } else {
                addNode(node.right, x);
            }

        }
    }

    public void insert(int x) {
        if(root == null) {
            root = new Node(x);
            return;
        }
        addNode(root, x);
    }

    private int getRank(Node node, int y) {
        if(node == null) return 0;
        if(node.val > y) {
            return getRank(node.left, y);
        } else {
            return getRank(node.right, y) + node.leftCount+1;
        }
    }

    public int rank(int y) {
        return getRank(root, y);
    }

    public static void main(String[] args) {
        Zenefits_BSTRank inst = new Zenefits_BSTRank();
        inst.insert(2);
        inst.insert(4);
        inst.insert(1);
        inst.insert(5);
        System.out.println(inst.rank(3));
        inst.insert(7);
        inst.insert(9);
        System.out.println(inst.rank(8));
    }
}
