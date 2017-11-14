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
}
