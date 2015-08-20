package math;

/**
 *
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 * Created by xingyun on 15/2/7.
 */
public class LC_7_ReverseInt {

    public int reverse(int x) {

        int res = 0;

        boolean lessThanZero = x < 0;
        int a = Math.abs(x);
        int maxDivide10 = Integer.MAX_VALUE/10;
        while (a!=0) {
            if (res>maxDivide10) return 0; // 防止越界
            res = res*10;
            if (res>Integer.MAX_VALUE - a%10) return 0; // 防止越界
            res += a%10;
            a = a/10;
        }

        if(lessThanZero) {
            res = -res;
        }
        return res;
    }

    public static void main(String[] args) {
        LC_7_ReverseInt inst = new LC_7_ReverseInt();
        System.out.println(inst.reverse(1000000009));
    }

}
