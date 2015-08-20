package string;

/**
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 * Created by xingyun on 15/7/10.
 */
public class LC_125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if( s.isEmpty()) return true;

        int i = 0, j = s.length()-1;
        while(i<j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(ci <= 'Z' && ci >= 'A') {
                ci = (char)(ci - 'A' + 'a');
            }
            if(cj <= 'Z' && cj >= 'A') {
                cj = (char)(cj - 'A' + 'a');
            }
            if(!(ci >= 'a' && ci <= 'z') && !(ci >= '0' && ci <= '9')) { i++; continue; }
            if(!(cj >= 'a' && cj <= 'z') && !(cj >= '0' && cj <= '9' )){ j--; continue; }
            if(ci == cj) {
                i++;
                j--;
            } else {
                break;
            }
        }

        if(i==j || i-1 == j) return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "1a2";
        LC_125_ValidPalindrome inst = new LC_125_ValidPalindrome();
        System.out.println(inst.isPalindrome(s));
    }
}
