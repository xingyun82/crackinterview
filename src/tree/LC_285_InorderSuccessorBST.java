package tree;

import common.*;
/**
 * Created by xingyun on 10/4/15.
 */
public class LC_285_InorderSuccessorBST {

    // time complexity: O(h)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            p = p.right;
            while (p.left != null)
                p = p.left;
            return p;
        }
        TreeNode candidate = null;
        while (root != p)
            root = (p.val > root.val) ? root.right : (candidate = root).left;
        return candidate;
    }
}
