package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingyun on 15/7/5.
 */
public class LC_132_PalindromePartitionII {


    public int minCut(String s) {

        // palindrome map (end => starts)
        List<List<Integer>> palindromeMap = new ArrayList<List<Integer>>();
        for(int i=0; i<=s.length(); ++i) {
            palindromeMap.add(new ArrayList<Integer>());
        }
        // even palindromes
        for(int i=1; i<s.length(); ++i) {
            for (int j=1; j <= i && j <= s.length() - i; ++j) {
                if (s.charAt(i - j) == s.charAt(i + j - 1)) {
                    palindromeMap.get(i+j).add(i-j);
                } else {
                    break;
                }
            }
        }
        // odd palindromes
        for(int i=0; i<s.length(); ++i) {
            for (int j=0; j <= i && j < s.length() - i; ++j) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    palindromeMap.get(i+j+1).add(i-j);
                } else {
                    break;
                }
            }
        }
        int[] minCut = new int[s.length()+1]; // minCut[k] means min cut for Kth position
        for (int i=0; i<=s.length(); ++i) {
            minCut[i] = i-1;
            for(int j: palindromeMap.get(i)) {
                minCut[i] = Math.min(minCut[i], minCut[j]+1);
            }
        }
        return minCut[s.length()];
    }


    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        LC_132_PalindromePartitionII inst = new LC_132_PalindromePartitionII();
        System.out.println(inst.minCut(s));
    }
}
