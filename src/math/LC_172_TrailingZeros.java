package math;

/**
 * Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.

 * Created by xingyun on 15/6/4.
 */
public class LC_172_TrailingZeros {

    public int trailingZeroes(int n) {
        int res = 0;
        while(n!=0) {
            n = n/5;
            res += n;
        }
        return res;
    }

    public static void main(String[] args) {
        LC_172_TrailingZeros inst = new LC_172_TrailingZeros();
        System.out.println(inst.trailingZeroes(126));
    }

}
