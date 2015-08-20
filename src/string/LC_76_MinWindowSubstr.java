package string;

import java.util.*;
/**
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the emtpy string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

 * Created by xingyun on 15/8/1.
 */
public class LC_76_MinWindowSubstr {

    /*
    public String minWindow(String s, String t) {
        // build char set of t: St
        // iter s to find char and position in St
        // A -> 0,10
        // B -> 3,9
        // C -> 5,12
        // then, set three pointer to the postings, iter postings to find the min window
        // the time complexity is O(m*n)

        // charMap: c -> count of c in t
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for(int i=0;i<t.length(); ++i) {
            if(!charMap.containsKey(t.charAt(i))) {
                charMap.put(t.charAt(i), 1);
            } else {
                charMap.put(t.charAt(i), charMap.get(t.charAt(i))+1);
            }
        }
        // charIndex: c -> index posting
        Map<Character, List<Integer>> charIndex = new HashMap<Character, List<Integer>>();
        for(int i=0; i<s.length(); ++i) {
            if(!charMap.containsKey(s.charAt(i))) continue;
            if(!charIndex.containsKey(s.charAt(i))) {
                List<Integer> posting = new ArrayList<Integer>();
                posting.add(i);
                charIndex.put(s.charAt(i), posting);
            } else {
                charIndex.get(s.charAt(i)).add(i);
            }
        }
        // pointerMap: c -> index pointer
        Map<Character, Integer> pointerMap = new HashMap<Character, Integer>();
        for(Character c:charMap.keySet()) {
            // if c is not in s
            if(!charIndex.containsKey(c)) return "";
            // if count of c in s is less than the count of c in t
            if(charMap.get(c) > charIndex.get(c).size()) return "";
            // initialize the index pointer of c
            pointerMap.put(c, 0);
        }
        int pointerEnd = 0;
        int minFinalStartIdx = Integer.MAX_VALUE;
        int minFinalEndIdx = Integer.MIN_VALUE;
        int minLen = Integer.MAX_VALUE;
        while(pointerEnd < charMap.size()) {
            char minChar = ' ';
            int minStartIdx = Integer.MAX_VALUE;
            int maxEndIdx = Integer.MIN_VALUE;

            // get minStartIdx, maxEndIdx
            for(Character c:charMap.keySet()) {
                int startIdx = charIndex.get(c).get(pointerMap.get(c));
                int endIdx = charIndex.get(c).get(pointerMap.get(c) + charMap.get(c) - 1);
                if(startIdx < minStartIdx) {
                    minChar = c;
                    minStartIdx = startIdx;
                }
                if(endIdx > maxEndIdx) {
                    maxEndIdx = endIdx;
                }
            }
            // update minLen, minFinalStartIdx, minFinalEndIdx
            if((maxEndIdx - minStartIdx) < minLen) {
                minLen = maxEndIdx - minStartIdx;
                minFinalStartIdx = minStartIdx;
                minFinalEndIdx = maxEndIdx;
            }
            // move pointer of c
            if(pointerMap.get(minChar)+charMap.get(minChar) >= charIndex.get(minChar).size()) {
                pointerEnd++;
            } else {
                pointerMap.put(minChar, pointerMap.get(minChar)+1);
            }
        }
        return s.substring(minFinalStartIdx, minFinalEndIdx + 1);
    }
    */

    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        // two pointer methods
        //     i
        // ACBBACA
        // j
        //       i
        // ACBBACA
        //   j
        //       i
        // ACBBACA
        //    j
        // charCountMapT: c -> count of c in t
        Map<Character, Integer> charCountMapT = new HashMap<Character, Integer>();
        for(int i=0;i<t.length(); ++i) {
            if(!charCountMapT.containsKey(t.charAt(i))) {
                charCountMapT.put(t.charAt(i), 1);
            } else {
                charCountMapT.put(t.charAt(i), charCountMapT.get(t.charAt(i))+1);
            }
        }
        Map<Character, Integer> charCountMapS = new HashMap<Character, Integer>();
        for(char c : charCountMapT.keySet()) {
            charCountMapS.put(c, 0);
        }

        int i=-1, j=0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int count = 0; // chars are found in t
        while(i<s.length() && j<s.length()) {
            // move i
            if (count < charCountMapT.size()) {
                i++;
                if (i<s.length() && charCountMapS.containsKey(s.charAt(i))) {
                    int charCount = charCountMapS.get(s.charAt(i)) + 1;
                    charCountMapS.put(s.charAt(i), charCount);
                    if (charCount == charCountMapT.get(s.charAt(i))) {
                        count++;
                    }
                }
            }
            // move j
            else {
                if (charCountMapS.containsKey(s.charAt(j))) {
                    int charCount = charCountMapS.get(s.charAt(j)) - 1;
                    charCountMapS.put(s.charAt(j), charCount);
                    if (charCount < charCountMapT.get(s.charAt(j))) {
                        count--;

                        if (i - j + 1 < minLen) {
                            minLen = i - j + 1;
                            minStart = j;
                        }
                    }
                }
                j++;
            }
        }
        if(minLen != Integer.MAX_VALUE) {
            return s.substring(minStart, minStart+minLen);
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "ACBBACA";
        String t = "ABA";
        LC_76_MinWindowSubstr inst = new LC_76_MinWindowSubstr();
        System.out.println(inst.minWindow(s, t));
    }
}
