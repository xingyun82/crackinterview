package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by xingyun on 9/19/15.
 */
public class Intuit_SegString {
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
    public void segOnPosition(List<List<String>> res, List<String> segs, String str, HashSet<String> dict, int i) {

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
        List<Integer> candidates = new ArrayList<Integer>();
        for(int j=i+1; j<=str.length(); ++j) {
            String seg = str.substring(i, j);
            if(dict.contains(seg)) {
                candidates.add(j);
            }
        }

        // for each possible end position, we move forward to seg rest string
        // then, we back track to try next possible end position
        for(int j:candidates) {
            String seg = str.substring(i, j);
            segs.add(seg);
            segOnPosition(res, segs, str, dict, j);
            segs.remove(segs.size()-1);  // back track
        }
    }

    public List<List<String>> segment(String str, HashSet<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(str == null || dict == null) return res;
        List<String> segs = new ArrayList<String>();
        segOnPosition(res, segs, str, dict, 0);
        return res;
    }

    public static void main(String[] args) {
        String str = "ilikeicecream";
        HashSet<String> dict = new HashSet<String>();
        dict.add("i");
        dict.add("like");
        dict.add("ice");
        dict.add("cream");
        dict.add("icecream");

        Intuit_SegString inst = new Intuit_SegString();
        List<List<String>> res = inst.segment(str, dict);
        for(int i=0; i<res.size(); ++i) {
            for(String seg:res.get(i)) {
                System.out.print(seg+" ");
            }
            System.out.println();
        }
    }
}
