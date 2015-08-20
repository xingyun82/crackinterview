package string;

/**
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 * Created by xingyun on 15/7/26.
 */
public class LC_58_LastWordLength {

    public int lengthOfLastWord(String s) {
        if(s == null) return 0;
        int end = s.length();
        int start = end-1;
        while(start>=0 && s.charAt(start) == ' ') {
            start--;
        }
        end = start+1;
        while(start>=0 && s.charAt(start) != ' ') {
            start--;
        }
        return (end - (start+1));
    }

    public static void main(String[] args) {
        LC_58_LastWordLength inst = new LC_58_LastWordLength();
        System.out.println(inst.lengthOfLastWord(""));
    }
}
