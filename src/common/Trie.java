package common;

/**
 * Created by xingyun on 15/6/24.
 */
public class Trie {

    private TrieNode root = new TrieNode((char)0);

    public void addWord(String s) {
        TrieNode node = root;
        int i = 0;
        while(i<s.length()) {
            char c = s.charAt(i);
            if(node.children[c-'a'] == null) {
                node.children[c-'a'] = new TrieNode(c);
            }
            node = node.children[c-'a'];
            i++;
        }
        node.canBeLeaf = true;
    }

    public boolean matchPrefix(String s) {
        TrieNode node = root;
        int i = 0;
        while(i<s.length()) {
            char c = s.charAt(i);
            if(node.children[c-'a'] == null) return false;
            node = node.children[c-'a'];
            i++;
        }
        return true;
    }


    public String coverWord(String s) {
        StringBuilder sb = new StringBuilder();
        TrieNode node = root;
        int i = 0;
        while (i < s.length() && node != null) {
            char c = s.charAt(i);
            if (node.children[c - 'a'] == null || node.canBeLeaf) {
                break;
            }
            sb.append(c);
            node = node.children[c - 'a'];
            i++;
        }
        if(i <= s.length() && node != null && node.canBeLeaf) {
            return sb.toString();
        }
        return null;
    }

    public boolean isWord(String s) {
        TrieNode node = root;
        int i = 0;
        while(i<s.length()) {
            char c = s.charAt(i);
            if(node.children[c-'a'] == null) return false;
            node = node.children[c-'a'];
            i++;
        }
        return node.canBeLeaf;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("abc");
        trie.addWord("abcde");
        trie.addWord("cde");
//        System.out.println(trie.matchPrefix("ab"));
//        System.out.println(trie.isWord("ab"));
//        System.out.println(trie.isWord("abc"));
        System.out.println(trie.coverWord("cded"));


    }
}
