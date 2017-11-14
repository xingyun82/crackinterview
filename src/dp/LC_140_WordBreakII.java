package dp;

import java.util.*;

/**
 *
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].
 * Created by xingyun on 15/6/24.
 */
public class LC_140_WordBreakII {


    /**
     * 下面的算法性能不好，因为每次还是要用trie来匹配word，DP的子步骤有很多这种重复的工作，可以预先匹配好，DP时可以直接用上
    public void doMatch(Trie trie, String s, List<String> sentence, List<List<String>> sentences) {
        List<Integer> candWordIndices = trie.matchWords(s);
        for(int i: candWordIndices) {
            sentence.add(s.substring(0, i));
            if(i == s.length()) {
                List<String> newSent = new ArrayList<String>(sentence);
                sentences.add(newSent);
            }
            doMatch(trie, s.substring(i), sentence, sentences);
            sentence.clear();
        }
    }
    */

//    public List<List<Integer>> getStopsMap(String s, Set<String> wordDict) {
//        List<List<Integer>> stopsMap = new ArrayList<List<Integer>>();
//        for(int i=0;i<s.length();++i) {
//            stopsMap.add(new ArrayList<Integer>());
//        }
//        for(int stop=s.length(); stop>0; stop--) {
//            if(stop != s.length() && stopsMap.get(stop).size() == 0) continue; //这行代码很精妙！
//            for(int start = stop-1; start>=0; start--) {
//                String str = s.substring(start, stop);
//                if(wordDict.contains(str)) {
//                    stopsMap.get(start).add(stop);
//                }
//            }
//        }
//        return stopsMap;
//    }
//
//    public void doMatch(List<List<Integer>> stopsMap, String s, int start, List<String> sentence, List<List<String>> sentences) {
//        List<Integer> stops = stopsMap.get(start);
//        for(int i: stops) {
//            sentence.add(s.substring(start, i));
//            if(i == s.length()) {
//                List<String> newSent = new ArrayList<String>(sentence);
//                sentences.add(newSent);
//                //return;
//            } else {
//                doMatch(stopsMap, s, i, sentence, sentences);
//            }
//            sentence.remove(sentence.size()-1);
//        }
//    }
//
//    public List<String> wordBreak(String s, Set<String> wordDict) {
//
//        List<String> res = new ArrayList<String>();
//
//        // build trie for word dict
//        /**
//        Trie trie = new Trie();
//        for(String word: wordDict) {
//            trie.addWord(word);
//        }
//         */
//        List<List<Integer>> stopsMap = getStopsMap(s, wordDict);
//
//        //
//        List<List<String>> sentences = new ArrayList<List<String>>();
//        List<String> sentence = new ArrayList<String>();
//        //doMatch(trie, s, sentence, sentences);
//        doMatch(stopsMap, s, 0, sentence, sentences);
//
//
//        for(List<String> sen:sentences) {
//            StringBuffer sb = new StringBuffer();
//            for(String str:sen) {
//                sb.append(str).append(" ");
//            }
//            sb.deleteCharAt(sb.length()-1);
//            res.add(sb.toString());
//        }
//
//        return res;
//    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        LC_140_WordBreakII inst = new LC_140_WordBreakII();
        //"", ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
        String s = "aaaaaaa";
        Set<String> wordDict = new HashSet<String>();
        String[] words = new String[]{"aaaa","aa","a"};
        wordDict.addAll(Arrays.asList(words));
        List<String> res = inst.wordBreak(s, wordDict);
        for(String sentence:res) {
            System.out.println(sentence);
        }

    }
}
