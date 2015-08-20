package tree;

import java.util.*;
import common.*;
/**
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

 _______3______
 /              \
 ___5__          ___1__
 /      \        /      \
 6      _2       0       8
 /  \
 7   4
 For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

 * Created by xingyun on 15/8/20.
 */

class SearchResult {
    public boolean pOK;
    public boolean qOK;
    public TreeNode node;
}

public class LC_236_LowestCommonAncestorOfABinaryTree {

    // main idea: find the p and q recursively
    private SearchResult findCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        SearchResult rs = new SearchResult();
        if(node == null) return rs;

        SearchResult rs1 = findCommonAncestor(node.left, p, q);
        if(rs1.node != null) return rs1;

        SearchResult rs2 = findCommonAncestor(node.right, p, q);
        if(rs2.node != null) return rs2;

        rs.pOK = rs1.pOK || rs2.pOK || node == p;
        rs.qOK = rs1.qOK || rs2.qOK || node == q;

        if(rs.pOK && rs.qOK) { rs.node = node; }
        return rs;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        SearchResult rs = findCommonAncestor(root, p, q);
        return rs.node;
    }

}
