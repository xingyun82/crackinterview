package string;

import java.util.*;
/**
 * Created by xingyun on 10/5/15.
 */
public class WordPattern {

    // main idea:
    // 1. create a hashmap for each character in pattern, char->word
    // 2. if find a char,word pair not match return false
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> chwordMap = new HashMap<Character, String>();
        Map<String, Character> wordchMap = new HashMap<String, Character>();
        int k = 0; // kth character in pattern
        int i = 0, j = 0; // start and end of a word
        while(k<pattern.length() && i<str.length()) {
            char c = pattern.charAt(k);
            while(j<str.length() && str.charAt(j) != ' ') j++;
            if(i==j) return false;
            String word = str.substring(i, j);
            if(chwordMap.containsKey(c)) {
                if(!chwordMap.get(c).equals(word)) return false;
            } else {
                if(wordchMap.containsKey(word)) return false;
                chwordMap.put(c, word);
                wordchMap.put(word, c);
            }
            i = Math.min(j+1, str.length());
            j = i;
            k++;
        }
        return k == pattern.length() && i == str.length();
    }

    public static void main(String[] args) {
        WordPattern inst = new WordPattern();
        System.out.println(inst.wordPattern("abba","a dog dog a"));
    }
}
