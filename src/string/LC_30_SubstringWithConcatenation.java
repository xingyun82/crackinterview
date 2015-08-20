package string;


import java.util.*;
/**
 *
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).

 * Created by xingyun on 15/8/20.
 */
public class LC_30_SubstringWithConcatenation {


    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if (L.length == 0) return result;
        int size = L[0].length();
        if (L[0].isEmpty() || L[0].length() > S.length())
            return result;
        Map<String, Integer> hist = new HashMap<String, Integer>();
        for (String w : L) {
            hist.put(w, !hist.containsKey(w) ? 1 : hist.get(w)+1);
        }
        for (int i = 0; i+size*L.length <= S.length(); i++) {
            if (hist.containsKey(S.substring(i, i+size))) {
                Map<String, Integer> currHist = new HashMap<String, Integer>();
                for (int j = 0; j < L.length; j++) {
                    String word = S.substring(i+j*size, i+(j+1)*size);
                    currHist.put(word, !currHist.containsKey(word) ?
                            1 : currHist.get(word)+1);
                }
                if (currHist.equals(hist)) result.add(i);
            }
        }
        return result;
    }
}
