package string;

/**
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 * Created by xingyun on 15/8/20.
 */
public class LC_242_ValidAnagram {

    // main idea: hash table
// construct char frequency table for s
// traverse each char of t, and minus related frequence
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        int[] freqs = new int[26];
        for(int i=0;i<s.length(); ++i) {
            freqs[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length(); ++i) {
            freqs[t.charAt(i)-'a']--;
        }
        for(int freq:freqs) {
            if(freq != 0) return false;
        }
        return true;
    }

}
