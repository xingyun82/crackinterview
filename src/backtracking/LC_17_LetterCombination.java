package backtracking;

import java.util.*;
/**
 *
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.



 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.

 * Created by xingyun on 15/8/19.
 */
public class LC_17_LetterCombination {

    HashMap<Character, List<Character>> charMap = new HashMap<Character, List<Character>>();

    public List<String> letterCombinations2(String digits, int n) {
        List<String> res = new ArrayList<String>();
        if (n == -1) {
            res.add("");
            return res;
        }
        if (n>=digits.length()) return letterCombinations2(digits, digits.length()-1);
        List<String> strs = letterCombinations2(digits, n-1);
        char c = digits.charAt(n);
        if(!charMap.containsKey(c)) return strs;

        List<Character> chars = charMap.get(c);
        for (int i=0; i<strs.size(); ++i) {
            for(int j=0; j<chars.size(); ++j) {
                StringBuilder sb = new StringBuilder();
                sb.append(strs.get(i));
                sb.append(chars.get(j));
                res.add(sb.toString());
            }
        }
        return res;
    }


    public List<String> letterCombinations(String digits) {
        Character[] char2 = {'a','b','c'};
        Character[] char3 = {'d','e','f'};
        Character[] char4 = {'g','h','i'};
        Character[] char5 = {'j','k','l'};
        Character[] char6 = {'m','n','o'};
        Character[] char7 = {'p','q','r','s'};
        Character[] char8 = {'t','u','v'};
        Character[] char9 = {'w','x','y','z'};
        Character[] char0 = {' '};
        charMap.put('2', Arrays.asList(char2));
        charMap.put('3', Arrays.asList(char3));
        charMap.put('4', Arrays.asList(char4));
        charMap.put('5', Arrays.asList(char5));
        charMap.put('6', Arrays.asList(char6));
        charMap.put('7', Arrays.asList(char7));
        charMap.put('8', Arrays.asList(char8));
        charMap.put('9', Arrays.asList(char9));
        charMap.put('0', Arrays.asList(char0));
        return letterCombinations2(digits, digits.length()-1);
    }

}
