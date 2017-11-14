package tree;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import common.TreeNode;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 For example, you may serialize the following tree

 1
 / \
 2   3
 / \
 4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.


 */
public class LC_297_SerDesBinaryTree {

//    // Encodes a tree to a single string.
//    // pre-order: 1 2 4 # # 5 # # 3 # #
//    public String serialize(TreeNode root) {
//        if (root == null) return "# ";
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.valueOf(root.val) + " ");
//        sb.append(serialize(root.left));
//        sb.append(serialize(root.right));
//        return sb.toString();
//    }
//
//    // Decodes your encoded data to tree.
//    // utilize queue to store vals, and poll val to deserialize each time.
//    public TreeNode deserialize(String data) {
//        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(" ")));
//        return deserialize(queue);
//    }
//
//    private TreeNode deserialize(Queue<String> queue) {
//        String val = queue.poll();
//        if (val.equals("#")) return null;
//        TreeNode node = new TreeNode(Integer.valueOf(val));
//        node.left = deserialize(queue);
//        node.right = deserialize(queue);
//        return node;
//    }

    public String serialize(TreeNode root) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            serialize(root, bos);
            String str = new String(bos.toByteArray(), "ISO-8859-1");
            bos.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void serialize(TreeNode root, ByteArrayOutputStream bos) {
        try {
            if (root == null) {
                byte b = 0;
                bos.write(b);
                return;
            }
            byte b = 1;
            bos.write(b);
            bos.write(ByteBuffer.allocate(4).putInt(root.val).array());
            serialize(root.left, bos);
            serialize(root.right, bos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TreeNode deserialize(String data) {
        try {
            return deserialize(new ByteArrayInputStream(data.getBytes("ISO-8859-1")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private TreeNode deserialize(ByteArrayInputStream bis) {
        int b = bis.read();
        if (b == 0) return null;
        try {
            if (b == 1) {
                byte[] intVal = new byte[4];
                bis.read(intVal);
                TreeNode node = new TreeNode(ByteBuffer.wrap(intVal).getInt());
                node.left = deserialize(bis);
                node.right = deserialize(bis);
                return node;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        TreeNode node1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;

        LC_297_SerDesBinaryTree inst = new LC_297_SerDesBinaryTree();
        String data = inst.serialize(node1);
        System.out.println(data);
        TreeNode node = inst.deserialize(data);
        node.printTree();
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        bos.write((byte)1);
//        bos.write(ByteBuffer.allocate(4).putInt(-1).array());
//        String str = new String(bos.toByteArray(), "ISO-8859-1");
//        ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
//        bis.read();
//        byte[] bytes = new byte[4];
//        bis.read(bytes);
//        System.out.println(ByteBuffer.wrap(bytes).getInt());

    }

}
