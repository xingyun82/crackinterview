package tree;

/**
 *
 * 116:
 * Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL

 117:

 Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL


 * Created by xingyun on 15/7/20.
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class LC_116_117_PopulatingNextRightPointer {


    public void connect(TreeLinkNode root) {

        if(root == null) return;

        while(root != null) {
            TreeLinkNode tmp = new TreeLinkNode(0);
            TreeLinkNode cur = tmp;

            while(root != null) {
                if(root.left != null) {
                    cur.next = root.left;
                    cur = cur.next;
                }
                if(root.right != null) {
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }

            root = tmp.next;
        }
    }
    /*
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode head = root;
        TreeLinkNode pre = null;
        TreeLinkNode cur = null;

        while(head != null) {
            cur = head;
            head = null;
            pre = null;

            while(cur != null) {
                if(cur.left != null) {
                    if(head == null) head = cur.left;
                    if(pre == null) {
                        pre = cur.left;
                    } else {
                        pre = pre.next = cur.left;
                    }
                }
                if(cur.right != null) {
                    if(head == null) head = cur.right;
                    if(pre == null) {
                        pre = cur.right;
                    } else {
                        pre = pre.next = cur.right;
                    }
                }
                cur = cur.next;
            }
        }
    }
    */
    /*
   public void connect(TreeLinkNode root) {
       if(root == null) return;
       Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
       TreeLinkNode newEnd = null;
       TreeLinkNode end = root;
       queue.offer(root);
       TreeLinkNode pre = null;

       while(!queue.isEmpty()) {
           TreeLinkNode node = queue.poll();

           // if node != end
           while(node != end) {
               if(node.left != null) {
                   queue.offer(node.left);
                   newEnd = node.left;
               }
               if(node.right != null) {
                   queue.offer(node.right);
                   newEnd = node.right;
               }
               if(pre != null) pre.next = node;
               pre = node;
               node = queue.poll();
           }
           // if node == end
           if(node.left != null) {
               queue.offer(node.left);
               newEnd = node.left;
           }
           if(node.right != null) {
               queue.offer(node.right);
               newEnd = node.right;
           }
           if(pre != null) pre.next = node;
           pre = null;
           end = newEnd;
       }
   }
   */

    private void printTree(TreeLinkNode node) {
        if(node == null) return;
        System.out.println(node.val
                + ", left:" + (node.left == null? "": node.left.val)
                + ", right:" + (node.right == null?"":node.right.val)
                + ", next:" + (node.next == null?"":node.next.val)
        );
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;

        LC_116_117_PopulatingNextRightPointer inst = new LC_116_117_PopulatingNextRightPointer();
        inst.connect(root);
        inst.printTree(root);


    }
}

