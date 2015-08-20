package math;

/**
 * Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.

 * Created by xingyun on 15/8/20.
 */
public class LC_29_DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        long res = 0;
        if (divisor == 0) return Integer.MAX_VALUE;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int sign = ((a == dividend) == (b == divisor))?1:-1;


        int i = 0;
        while(a >= b) {
            i = 0;
            long c = b;
            while(a >= c) {
                a -= c;
                res += 1<<i;
                i++;
                c = c<<1;
            }
        }
        /*
    	while(a>=b) {
    		long x = b;
    		long m = 1;
    		while (x << 1 < a) {
    			x <<=1;
    			m <<=1;
    		}
    		res+=m;
    		a = a-x;
    	}
    	*/
        res = res*sign;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) res = Integer.MAX_VALUE;
        return (int)res;
    }

}
