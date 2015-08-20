package math;

/**
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Created by xingyun on 15/8/20.
 */
public class LC_231_PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return (n&(n-1)) == 0;
    }

}
