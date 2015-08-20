package math;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Created by xingyun on 15/2/7.
 */
public class LC_9_PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x%10 == 0) return false;
        int x2 = x;
        int y = 0;
        int maxDivide10 = Integer.MAX_VALUE/10;
        while (x2!=0) {
            int v = x2%10;
            if (y > maxDivide10) return false;
            y = y*10;
            if (y > Integer.MAX_VALUE - v) return false;
            y += v;
            x2 = x2/10;
            if (x2 == y || (x2/10 == y)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        LC_9_PalindromeNumber inst = new LC_9_PalindromeNumber();
        System.out.println(inst.isPalindrome(-1));
        System.out.println(inst.isPalindrome(0));
        System.out.println(inst.isPalindrome(11));
        System.out.println(inst.isPalindrome(10));
        System.out.println(inst.isPalindrome(1001));
        System.out.println(inst.isPalindrome(110));
        System.out.println(inst.isPalindrome(121));
        System.out.println(inst.isPalindrome(1234));
        System.out.println(inst.isPalindrome(1234567899));
    }

}
