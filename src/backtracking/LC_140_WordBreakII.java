package backtracking;

import common.Trie;
import java.util.*;

/**
 * Created by xingyun on 9/19/15.
 */
public class LC_140_WordBreakII {
    /**
     * segment str start with specific position, using backtrack
     * another way is to use AC automation to find all the possible words in the string,
     * then check if there are any full segmentations
     *
     * @param res  the final segmented list
     * @param segs the temp segmented result
     * @param str original string
     * @param dict dictionary
     * @param i start position to segment
     */
    public void segOnPosition(List<List<String>> res, List<String> segs, String str, List<List<Integer>> wordIdx, int i) {

        // termination case
        if (i == str.length() && segs.size() > 0) {
            List<String> tmp = new ArrayList<String>();
            tmp.addAll(segs);
            res.add(tmp);
            return;
        }

        // find all the possible end position j, which make substring(i, j) as a word in dict
        // a better solution maybe use a trie struct to replace hashset
        // then, we can quickly get all the possible j

        /*
        List<Integer> candidates = new ArrayList<Integer>();
        for(int j=i+1; j<=str.length(); ++j) {
            String seg = str.substring(i, j);
            if(dict.contains(seg)) {
                candidates.add(j);
            }
        }
        */
        List<Integer> candidates = wordIdx.get(i);
        // for each possible end position, we move forward to seg rest string
        // then, we back track to try next possible end position
        for(int j:candidates) {
            String seg = str.substring(i, j);
            segs.add(seg);
            segOnPosition(res, segs, str, wordIdx, j);
            segs.remove(segs.size()-1);  // back track
        }
    }

    public List<List<Integer>> getWordIdx(String str, Set<String> dict) {

        Trie trie = new Trie();
        for(String word:dict) {
            trie.addWord(word);
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0; i<str.length(); ++i) {
            res.add(new ArrayList<Integer>());
        }
        Set<Integer> segIdx = new HashSet<Integer>();
        segIdx.add(0);
        for(int i=0; i<str.length(); ++i) {
            if(!segIdx.contains(i)) continue;
            for(int j=i+1; j<=str.length(); ++j) {
//                if(dict.contains(str.substring(i, j))) {
//                    segIdx.add(j);
//                    res.get(i).add(j);
//                }
                if(trie.isWord(str.substring(i, j))) {
                    segIdx.add(j);
                    res.get(i).add(j);
                } else if (!trie.matchPrefix(str.substring(i, j))) {
                    break;
                }
            }
        }
        return res;
    }

    public List<List<String>> segment(String str, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(str == null || dict == null) return res;
        List<String> segs = new ArrayList<String>();
        List<List<Integer>> wordIdx = getWordIdx(str, dict);
        segOnPosition(res, segs, str, wordIdx, 0);
        return res;
    }


    public List<String> wordBreak(String str, Set<String> dict) {
        List<String> finalRes = new ArrayList<String>();
        List<List<String>> res = new ArrayList<List<String>>();
        if(str == null || dict == null) return finalRes;
        List<String> segs = new ArrayList<String>();
        List<List<Integer>> wordIdx = getWordIdx(str, dict);
        segOnPosition(res, segs, str, wordIdx, 0);


        for(List<String> sentence: res) {
            StringBuilder sb = new StringBuilder();
            for(String word:sentence) {
                sb.append(word+" ");
            }
            sb.delete(sb.length()-1, sb.length());
            finalRes.add(sb.toString());
        }
        return finalRes;
    }

    public static void main(String[] args) {
        String str = "ilikeicecream";
        HashSet<String> dict = new HashSet<String>();
        dict.add("i");
        dict.add("like");
        dict.add("ice");
        dict.add("cream");
        dict.add("icecream");
        /*
        LC_140_WordBreakII inst = new LC_140_WordBreakII();
        List<List<String>> res = inst.segment(str, dict);
        for(int i=0; i<res.size(); ++i) {
            for(String seg:res.get(i)) {
                System.out.print(seg+" ");
            }
            System.out.println();
        }
        */
        LC_140_WordBreakII inst = new LC_140_WordBreakII();
        List<String> res = inst.wordBreak(str, dict);
        for(String sent:res) {
            System.out.println(sent);
        }
     //   StringBuilder sb = new StringBuilder();

    }
}
