package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.

 A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

 Example:
 Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

 Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

 Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 Note:
 The number of elements of the given array will not exceed 10,000
 The length sum of elements in the given array will not exceed 600,000.
 All the input string will only include lower case letters.
 The returned elements order does not matter.

 */

public class LC_472_ConcatWords {

    // idea: recursive method
    // build hash map for all words
    // for each words, if word startWith another word, then try the rest part
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words, (str1, str2) -> (str1.length() - str2.length()));
        Set<String> preWords = new HashSet<>();
        Set<String> concatWords = new HashSet<>();
        for (String word : words) {
            if (isConcatenatedWord(word, preWords, concatWords)) {
                result.add(word);
            }
            preWords.add(word);
        }
        return result;
    }

    private boolean isConcatenatedWord(String word, Set<String> preWords, Set<String> concatWords) {
        if (concatWords.contains(word)) return true;
        if (preWords.contains(word)) return true;
        for (int i=1; i<=word.length(); ++i) {
            if (preWords.contains(word.substring(0, i))) {
                if (isConcatenatedWord(word.substring(i), preWords, concatWords)) {
                    concatWords.add(word);
                    return true;
                }
            }
        }
        return false;
    }
//    private static boolean canForm(String word, Set<String> dict) {
//        if (dict.isEmpty()) return false;
//        boolean[] dp = new boolean[word.length() + 1];
//        dp[0] = true;
//        for (int i = 1; i <= word.length(); i++) {
//            for (int j = 0; j < i; j++) {
//                if (!dp[j]) continue;
//                if (dict.contains(word.substring(j, i))) {
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
//        return dp[word.length()];
//    }


    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        LC_472_ConcatWords inst = new LC_472_ConcatWords();
        System.out.println(inst.findAllConcatenatedWordsInADict(words));
    }
}
