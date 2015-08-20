package dp;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 * Created by xingyun on 15/6/24.
 */
public class LC_139_WordBreak {

    public List<List<Integer>> getStopsMap(String s, Set<String> wordDict) {
        List<List<Integer>> stopsMap = new ArrayList<List<Integer>>();
        for(int i=0;i<s.length();++i) {
            stopsMap.add(new ArrayList<Integer>());
        }
        for(int stop=s.length(); stop>0; stop--) {
            if(stop != s.length() && stopsMap.get(stop).size() == 0) continue;
            for(int start = stop-1; start>=0; start--) {
                String str = s.substring(start, stop);
                if(wordDict.contains(str)) {
                    stopsMap.get(start).add(stop);
                }
            }
        }
        return stopsMap;
    }

    public boolean doMatch(List<List<Integer>> stopsMap, String s, int start) {
        List<Integer> stops = stopsMap.get(start);
        for(int i: stops) {
            if(i == s.length()) {
                return true;
            } else {
                if(doMatch(stopsMap, s, i)) return true;
            }
        }
        return false;
    }

    public boolean wordBreak(String s, Set<String> wordDict) {

        List<List<Integer>> stopsMap = getStopsMap(s, wordDict);
        return doMatch(stopsMap, s, 0);

    }


    public static void main(String[] args) {
        LC_139_WordBreak inst = new LC_139_WordBreak();
        //"", ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
        String s = "aaaaaaa";
        Set<String> wordDict = new HashSet<String>();
        String[] words = new String[]{"aaaa","aa","b"};
        wordDict.addAll(Arrays.asList(words));
        System.out.println(inst.wordBreak(s, wordDict));

    }
}
