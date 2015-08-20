package string;

/**
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Created by xingyun on 15/8/20.
 */
public class LC_14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";
        String str0 = strs[0];
        if (str0 == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<str0.length(); ++i) {
            char c = str0.charAt(i);
            for (int j=1; j<strs.length; ++j) {
                if (strs[j] == null) return "";
                if (i>=strs[j].length() || strs[j].charAt(i) != c) return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }

}
