package tree;

import common.*;
import java.util.*;
/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
 * Created by xingyun on 15/8/20.
 */
public class LC_199_BinaryTreeRightSideView {

    public void depthFirstTravel(List<TreeNode> list, int begin, List<Integer> res) {
        int len = list.size();
        if ( len < begin || begin < 0 ) return;
        res.add(list.get(len-1).val);
        for (int i=begin; i<len; ++i) {
            if(list.get(i).left != null) {
                list.add(list.get(i).left);
            }
            if(list.get(i).right != null) {
                list.add(list.get(i).right);
            }
        }
        begin = len;
        if (list.size() > begin) {
            depthFirstTravel(list, begin, res);
        }

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        depthFirstTravel(list, 0, res);
        return res;
    }
}
