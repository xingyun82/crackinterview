package string;

public class LC_647_PalindromicSubstrings {

    int count = 0;

    public int countSubstrings(String s) {

        for (int i = 0; i < s.length(); ++i) {
            countExtendPalindrom(s, i, i);
            countExtendPalindrom(s, i, i+1);
        }
        return count;
    }

    private void countExtendPalindrom(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        LC_647_PalindromicSubstrings inst = new LC_647_PalindromicSubstrings();
        System.out.println(inst.countSubstrings(""));
    }
}
