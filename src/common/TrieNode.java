package common;

import java.util.List;

import java.util.ArrayList;

/**
 * Created by xingyun on 15/6/24.
 */
public class TrieNode {

    public char val;
    public TrieNode[] children = new TrieNode[26];
    public boolean canBeLeaf;

    public TrieNode(char val) { this.val = val; }
//
//    public TrieNode findChild(char val) {
//        for(TrieNode node:children) {
//            if(node.val == val) return node;
//        }
//        return null;
//    }
//
//    public TrieNode addChild(char val) {
//        TrieNode node = new TrieNode(val);
//        children.add(node);
//        return node;
//    }
}
