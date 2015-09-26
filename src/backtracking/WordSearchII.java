package backtracking;

import common.Trie;
import java.util.*;
/**
 *Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 *
 * Created by xingyun on 9/25/15.
 */
public class WordSearchII {

    private Trie constructTrie(String[] words) {
        Trie trie = new Trie();
        if(words == null) return trie;
        for(String word:words) {
            trie.addWord(word);
        }
        return trie;
    }

    public void backtrack(Set<String> res, String tmp, char[][] board, boolean[][] visit, int i, int j, Trie trie) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || visit[i][j]) {
            return;
        }
        if(trie.isWord(tmp+board[i][j])) {
            res.add(tmp+board[i][j]);
        }
        else if(!trie.matchPrefix(tmp+board[i][j])) {
            return;
        }
        visit[i][j] = true;
        backtrack(res, tmp+board[i][j], board, visit, i-1, j, trie);
        backtrack(res, tmp+board[i][j], board, visit, i, j-1, trie);
        backtrack(res, tmp+board[i][j], board, visit, i+1, j, trie);
        backtrack(res, tmp+board[i][j], board, visit, i, j+1, trie);
        visit[i][j] = false;

    }


    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        Set<String> dict = new HashSet<String>();
        if(board == null || words == null) return res;
        Trie trie = constructTrie(words);
        boolean[][] visit = new boolean[board.length][board[0].length];
        for(int i=0; i< board.length; ++i) {
            for(int j=0; j<board[0].length; ++j) {
                backtrack(dict, "", board, visit, i, j, trie);
            }
        }

        for(String word:dict) {
            res.add(word);
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[2][2];
        board[0] = "ab".toCharArray();
        board[1] = "aa".toCharArray();
        WordSearchII inst = new WordSearchII();
        String[] words = new String[1];
        words[0] = "aaab";

        List<String> res = inst.findWords(board, words);
        for(String str:res) {
            System.out.println(str);
        }
    }
}
