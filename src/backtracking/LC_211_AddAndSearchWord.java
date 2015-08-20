package backtracking;

import common.*;
/**
 *
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 Note:
 You may assume that all words are consist of lowercase letters a-z.

 * Created by xingyun on 15/8/19.
 */
public class LC_211_AddAndSearchWord {

    private TrieNode root = new TrieNode((char)0);

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word == null) return;
        TrieNode p = root;
        for(int i=0; i<word.length(); ++i) {
            char c = word.charAt(i);
            if(p.children[c-'a'] != null) {
                p = p.children[c-'a'];
            } else {
                p.children[c-'a'] = new TrieNode(c);
                //p.children[c-'a'].val = c;
                p = p.children[c-'a'];
            }
        }
        p.canBeLeaf = true;
    }


    public boolean backtrack(String word, int i, TrieNode p) {
        if(i==word.length() && p!=null && p.canBeLeaf) return true;
        if(i>=word.length() || p == null) return false;
        char c = word.charAt(i);
        if(c == '.') {
            for(TrieNode child:p.children) {
                if(backtrack(word, i+1, child)) return true;
            }
            return false;
        } else {
            if(p.children[c-'a'] == null) return false;
            return backtrack(word, i+1, p.children[c-'a']);
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        return backtrack(word, 0, root);
    }
}
