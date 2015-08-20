package backtracking;

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Note:
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 * Created by xingyun on 15/2/19.
 */


// 这个算法是深度优先的回溯算法，在找最短路径的时候效率太低
// 需要考虑广度优先算法

import java.util.*;

public class LC_126_WordLadderII {

    int shortest = Integer.MAX_VALUE;

    private boolean isSimilar(String str, String word) {
        if (str.length() != word.length()) return false;
        int delta = 0;
        for (int i=0; i<str.length(); ++i) {
            if (str.charAt(i) != word.charAt(i)) {
                delta++;
                if(delta>1) return false;
            }
        }
        return delta == 1;
    }

    public void doFind(List<List<String>> res, List<String> trans, String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            for (int i=0; i<res.size(); ++i) {
                if (shortest > res.get(i).size()) {
                    shortest = res.get(i).size();
                }
            }
            if (trans.size() <= shortest) {
                if (trans.size() < shortest) {
                    res.clear();
                }
                List<String> ainst = new ArrayList<String>();
                ainst.addAll(trans);
                res.add(ainst);
            }
            return;
        }
        for (String word:dict) {
            if (isSimilar(start, word) && shortest>trans.size() && trans.indexOf(word) == -1 ) {
                trans.add(word);
                doFind(res, trans, word, end, dict);
                trans.remove(word);
            }
        }
        return;
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> trans = new ArrayList<String>();
        trans.add(start);
        dict.add(end);
        shortest = Integer.MAX_VALUE;
        doFind(res, trans, start, end, dict);
        return res;
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<String>();
        dict.addAll(Arrays.asList("hot","dot","dog","lot","log"));
        LC_126_WordLadderII inst = new LC_126_WordLadderII();
        List<List<String>> res = inst.findLadders(start, end, dict);
        for (int i=0; i<res.size(); i++) {
            for (int j=0; j<res.get(i).size(); ++j) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println();
        }
    }

}
