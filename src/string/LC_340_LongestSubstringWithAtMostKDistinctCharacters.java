package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 For example, Given s = “eceba” and k = 2,
 T is "ece" which its length is 3.

 */
public class LC_340_LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        int i = 0, j = 0;
        int maxLength = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c)+1);
            } else if (charMap.size() < k){
                charMap.put(c, 1);
            } else {
                maxLength = Math.max((j - i), maxLength);
                charMap.put(c, 1);
                // remove from char map until char set size is k
                while (charMap.size() > k) {
                    char ci = s.charAt(i);
                    int count = charMap.get(ci);
                    if (count > 1) {
                        charMap.put(ci, charMap.get(ci) - 1);
                    } else {
                        charMap.remove(ci);
                    }
                    i++;
                }
            }
            j++;
        }
        maxLength = Math.max((j - i), maxLength);
        return maxLength;
    }

    public static void main(String[] args) {
        LC_340_LongestSubstringWithAtMostKDistinctCharacters inst = new LC_340_LongestSubstringWithAtMostKDistinctCharacters();
        String s = "eceb";
        int k = 2;
        System.out.println(inst.lengthOfLongestSubstringKDistinct(s, k));

    }


}
