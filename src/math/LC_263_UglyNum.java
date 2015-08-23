package math;

/**
 *
 * Write a program to check whether a given number is an ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

 Note that 1 is typically treated as an ugly number.


 * Created by xingyun on 15/8/20.
 */
public class LC_263_UglyNum {

    public boolean isUgly(int num) {
        if(num <= 0) return false;
        int[] primes = new int[]{2,3,5};
        for(int i:primes) {
            while(num%i==0) { num /= i;}
        }
        return num==1;
    }

    public static void main(String[] args) {
        LC_263_UglyNum inst = new LC_263_UglyNum();
        System.out.println(inst.isUgly(-1));
        System.out.println(inst.isUgly(0));
        System.out.println(inst.isUgly(1));
        System.out.println(inst.isUgly(2));
        System.out.println(inst.isUgly(10));
        System.out.println(inst.isUgly(14));
    }

}
