package tree;

/**
 *
 * implementation of AVL tree
 * Created by xingyun on 10/10/15.
 */
public class AVLTree {

    class Node {
        int val;
        Node left;
        Node right;
        int height; // node height
        int lnc; // left subtree node count
        int rnc; // right subtree node count

        public Node(int val) {
            this.val = val;
            this.height = 1;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val+"[");
            if(left != null) {
                sb.append("l:" + left.val + " ");
            }
            if(right != null) {
                sb.append("r:" + right.val + " ");
            }
            sb.append("h:" + height+ " ");
            sb.append("lnc:" + lnc + " ");
            sb.append("rnc:" + rnc);
            sb.append("]");
            return sb.toString();
        }
    }

    Node root;

    private boolean search(Node node, int val) {
        if(node == null) return false;
        if(node.val == val) return true;
        if(node.val > val) {
            return search(node.left, val);
        } else {
            return search(node.right, val);
        }
    }

    public boolean search(int val) {
        return search(root, val);
    }

    private int height(Node node) {
        if(node == null) return 0;
        return node.height;
    }

    private Node insert(Node node, int val) {
        if(node == null) {
            return new Node(val);
        }
        if(node.val > val) {
            node.left = insert(node.left, val);
            node.lnc++;
            if(height(node.left) - height(node.right) == 2) {
                if(node.left.val > val) {
                    // right rotate
                    node = rightRotate(node);
                } else {
                    // left rotate + right rotate
                    node.left = leftRotate(node.left);
                    node = rightRotate(node);
                }
            }

        } else if(node.val < val){
            node.right = insert(node.right, val);
            node.rnc++;
            if(height(node.right) - height(node.left) == 2) {
                if(node.right.val < val) {
                    //  left rotate
                    node = leftRotate(node);
                } else {
                    // right rotate + left rotate
                    node.right = rightRotate(node.right);
                    node = leftRotate(node);
                }
            }

        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;


        x.rnc = y.lnc;
        y.lnc = x.lnc + x.rnc + 1;

        return y;
    }

    private Node rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        x.lnc = y.rnc;
        y.rnc = x.lnc + x.rnc + 1;

        return y;
    }


    private int getRank(Node node, int val) {
        if(node == null) return 0;
        if(node.val > val) {
            return getRank(node.left, val);
        } else {
            return 1+node.lnc + getRank(node.right, val);
        }
    }

    public int getRank(int val) {
        return getRank(root, val);
    }


    private void print(Node node) {
        if(node == null) return;
        System.out.println(node);
        print(node.left);
        print(node.right);
    }

    public void print() {
        print(root);
    }



    public static void main(String[] args) {
        AVLTree inst = new AVLTree();



        inst.insert(10);
        inst.insert(20);
        inst.insert(30);
        inst.insert(40);
        inst.insert(50);
        inst.insert(60);
        inst.insert(70);
        inst.insert(80);
        inst.insert(90);

        inst.print();
        System.out.println(inst.getRank(81));
    }
}
