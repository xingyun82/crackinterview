package tree;


import java.util.HashSet;
import java.util.Set;

/**
 * trie树统计公共前缀的单词集合、个数
 */
public class TrieApplication {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int samePrefixCount;
        boolean isWord;
    }

    TrieNode root = new TrieNode();

    public void addWord(String word) {
        if (isWord(word)) return;
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node.children[c - 'a'].samePrefixCount++;
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    public boolean isWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }

    public Set<String> searchPrefix(String prefix) {
        Set<String> words = new HashSet<>();
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) return words;
            node = node.children[c - 'a'];
        }
        getAllWordsWithSamePrefix(words, prefix, node);
        return words;
    }

    public void getAllWordsWithSamePrefix(Set<String> words, String prefix, TrieNode node) {
        if (node == null) return;
        if (node.isWord) {
            words.add(prefix);
        }
        for (int i=0; i<26; ++i) {
            char c = (char)('a' + i);
            getAllWordsWithSamePrefix(words, prefix + c, node.children[i]);
        }
    }

    public int samePrefixCount(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return 0;
            }
            node = node.children[c - 'a'];
        }
        return node.samePrefixCount;
    }

    public static void main(String[] args) {
        TrieApplication inst = new TrieApplication();
        inst.addWord("abcd");
        inst.addWord("abcd"); // duplicate case
        inst.addWord("abcde");
        inst.addWord("abcdef");
        inst.addWord("abcdefg");
        inst.addWord("abcx");
        inst.addWord("abcxy");
        inst.addWord("abcz");
        System.out.println(inst.samePrefixCount("abc"));
        System.out.println(inst.samePrefixCount("abcd"));
        System.out.println(inst.samePrefixCount("abcx"));
        System.out.println(inst.samePrefixCount("abcz"));
        System.out.println(inst.samePrefixCount("abcdef"));
        System.out.println(inst.samePrefixCount("abcdefg"));
        System.out.println(inst.searchPrefix("abcd"));
    }
}
