package string;

import java.util.*;

/**
 * Created by xingyun on 15/7/9.
 */

public class LC_127_WordLadder {

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(beginWord.equals(endWord)) return 0;

        Map<String, Integer> depthMap = new HashMap<String, Integer>();
        Queue<String> ladderQueue = new LinkedList<String>();
        ladderQueue.offer(beginWord);
        depthMap.put(beginWord, 1);

        while(!ladderQueue.isEmpty()) {
            String word = ladderQueue.poll();
            for(int i=0; i<word.length(); ++i) {
                for(char j='a'; j<'z'; ++j) {
                    if(word.charAt(i) == j) continue;
                    char[] chs = word.toCharArray();
                    chs[i] = j;
                    String newWord = new String(chs);

                    if(newWord.equals(endWord)) {
                        return depthMap.get(word)+1;
                    }
                    if(wordDict.contains(newWord) && !depthMap.containsKey(newWord)) {
                        depthMap.put(newWord, depthMap.get(word)+1);
                        ladderQueue.offer(newWord);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        Set<String> wordDict = new HashSet<String>();
        wordDict.addAll(Arrays.asList("hot","dot","dog","lot","log"));
        LC_127_WordLadder inst = new LC_127_WordLadder();
        System.out.println(inst.ladderLength(beginWord, endWord, wordDict));

    }
}
