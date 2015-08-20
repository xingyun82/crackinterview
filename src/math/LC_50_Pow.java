package math;

/**
 *
 * Implement pow(x, n).
 * Created by xingyun on 15/8/20.
 */
public class LC_50_Pow {

    public double pow(double x, int n) {

        if (x == 0) return 0;
        if (x == 1) return 1;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (x == -1) return (n % 2) == 0 ? 1 : -1;
        if (n < 0 ) return 1/ pow (x, -n);
        if (n == 2) return x * x;

        int halfPow = n/2;

        return pow(pow(x,halfPow),2) * pow(x, n%2);
    }

}
