package bitmagic;

import java.util.*;
/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].

 * Created by xingyun on 9/26/15.
 */
public class LC_187_RepeatDNA {

    // 注意到题目中只要找长度为10的重复子串，且词典只有4个字符，相当于2个bit
    // 可以把每个长度为10的子串(20个bit)转化成一个整数，然后用这个整数hash
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> words = new HashSet<Integer>();
        Set<Integer> doubleWords = new HashSet<Integer>();
        List<String> rv = new ArrayList<String>();
        char[] map = new char[26];
        //map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        for(int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for(int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if(!words.add(v) && doubleWords.add(v)) {
                rv.add(s.substring(i, i + 10));
            }
        }
        return rv;
    }
}
