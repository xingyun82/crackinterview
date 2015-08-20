package tree;

import common.TreeNode;

import javax.naming.directory.SearchResult;

class FindResult {

    boolean node1Find;
    boolean node2Find;
    TreeNode ancestor;
}
/**
 * Created by xingyun on 15/7/22.
 */
public class FindLatestAncestor {

    /*
    public FindResult findAncestor(TreeNode node, TreeNode node1, TreeNode node2) {
        FindResult res = new FindResult();
        if(node == null) return res;
        if(node == node1) res.node1Find = true;
        if(node == node2) res.node2Find = true;

        FindResult leftRes = findAncestor(node.left, node1, node2);
        // if found ancestor in the left, just return the ancestor
        if(leftRes.ancestor != null) return leftRes;

        FindResult rightRes = findAncestor(node.right, node1, node2);
        // if found ancestor in the right, just return the ancestor
        if(rightRes.ancestor != null) return rightRes;

        // else combine the left find and right find results and node itself
        res.node1Find = leftRes.node1Find || rightRes.node1Find || res.node1Find;
        res.node2Find = leftRes.node2Find || rightRes.node2Find || res.node2Find;
        if(res.node1Find && res.node2Find) res.ancestor = node;
        return res;
    }

    public TreeNode latestAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        return findAncestor(root, node1, node2).ancestor;
    }
    */

    public FindResult findAncestor(TreeNode node, TreeNode node1, TreeNode node2) {
        FindResult rs = new FindResult();
        if(node == null) return rs;

        FindResult rs1 = findAncestor(node.left, node1, node2);
        if(rs1.ancestor != null) return rs1;

        FindResult rs2 = findAncestor(node.right, node1, node2);
        if(rs2.ancestor != null) return rs2;

        rs.node1Find = rs1.node1Find || rs2.node1Find || node == node1;
        rs.node2Find = rs1.node2Find || rs2.node2Find || node == node2;
        if(rs.node1Find && rs.node2Find) { rs.ancestor = node;}

        return rs;
    }

    public TreeNode latestAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        FindResult rs = findAncestor(root, node1, node2);
        return rs.ancestor;

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

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;

        FindLatestAncestor inst = new FindLatestAncestor();
        TreeNode node = inst.latestAncestor(node1, node5, node8);
        System.out.println(node.val);
    }

}
