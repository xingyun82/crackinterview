package backtracking;

import java.util.*;
/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]

 * Created by xingyun on 15/8/19.
 */
public class LC_131_PalindromePartitioning {

    private void backtracing(List<List<String>> res, List<String> tmpRes, String s,
                             List<List<Integer>> palindromMap, int start) {

        if(start > s.length()) return;
        if(start == s.length()) {
            List<String> newTmp = new ArrayList<String>(tmpRes);
            res.add(newTmp);
            return;
        }
        for(int end:palindromMap.get(start)) {
            tmpRes.add(s.substring(start, end));
            backtracing(res, tmpRes, s, palindromMap, end);
            tmpRes.remove(tmpRes.size()-1);
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        // sub palindrome map (start => ends)
        List<List<Integer>> palindromeMap = new ArrayList<List<Integer>>();
        for(int i=0; i<s.length(); ++i) {
            palindromeMap.add(new ArrayList<Integer>());
        }
        // 1. get all the sub palindromes of string s
        // even sub palindromes
        for(int i=1; i<s.length(); ++i) {
            for (int j = 1; j <= i && j <= s.length() - i; ++j) {
                if (s.charAt(i - j) == s.charAt(i + j - 1)) {
                    palindromeMap.get(i - j).add(i + j);
                } else {
                    break;
                }
            }
        }
        // odd sub palindromes
        for(int i=0; i<s.length(); ++i) {
            for (int j = 0; j <= i && j < s.length() - i; ++j) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    palindromeMap.get(i - j).add(i + j + 1);
                } else {
                    break;
                }
            }
        }
        // 2. find all the possible partitions by back tracing
        List<String> tmpRes = new ArrayList<String>();
        backtracing(res, tmpRes, s, palindromeMap, 0);
        return res;
    }
}
