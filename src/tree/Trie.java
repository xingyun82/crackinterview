package tree;

import common.TrieNode;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xingyun on 15/6/24.
 */
public class Trie {

    /*
    public Map<Character, TrieNode> headMap = new HashMap<Character, TrieNode>();

    public void addWord(String s) {
        if(s == null || s.isEmpty()) return;
        Character head = s.charAt(0);
        TrieNode trie = headMap.get(head);
        if(trie == null) {
            trie = new TrieNode(head);
            headMap.put(head, trie);
        }
        for(int i=1; i<s.length(); ++i) {
            char c = s.charAt(i);
            TrieNode child = trie.findChild(c);
            if(child == null) {
                child = trie.addChild(c);
            }
            trie = child;
        }
        trie.canBeLeaf = true;
    }

    public boolean isWord(String s) {
        if(s == null || s.isEmpty()) return false;
        Character head = s.charAt(0);
        TrieNode trie = headMap.get(head);
        if(trie == null) return false;
        for(int i=1; i<s.length(); ++i) {
            char c = s.charAt(i);
            TrieNode child =trie.findChild(c);
            if(child == null) return false;
            trie = child;
        }
        return trie.canBeLeaf;
    }

    public List<Integer> matchWords(String s) {
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || s.isEmpty()) return res;
        Character head = s.charAt(0);
        TrieNode trie = headMap.get(head);
        if(trie == null) return res;
        if(trie.canBeLeaf) res.add(1);
        for(int i=1; i<s.length(); ++i) {
            char c = s.charAt(i);
            TrieNode child = trie.findChild(c);
            if(child == null) break;
            if(child.canBeLeaf) res.add(i+1);
            trie = child;
        }
        return res;
    }
    */
}
