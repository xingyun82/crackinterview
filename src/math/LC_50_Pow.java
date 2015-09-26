package math;

/**
 *
 * Implement pow(x, n).
 * Created by xingyun on 15/8/20.
 */
public class LC_50_Pow {

    /*
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
    */

    /*
    // P[n] = P[n/2]P[n/2] if n%2 == 0
    //      = P[n/2]P[n/2]*x  if n%2 == 1
    public double pow(double x, int n) {
        if(x == 0 || x == 1) return x;
        if(n < 0) return 1/pow(x, -n);
        if(n == 0) return 1;

        double[] P = new double[n]; // 数组大小设为n，为了不超过Integer.MAX_VALUE
        P[0] = 1;
        for(int i=1; i<n; ++i) {
            P[i] = P[i/2]*P[i/2];
            if(i%2 == 1) {
                P[i] *= x;
            }
        }
        return P[n-1]*x;
    }
    */

    public double pow(double x, int n) {
        if(n < 0){ n = -n; x = 1 / x; }
        double result = 1;
        while(n > 0){
            if((n & 1) == 1) result *= x;
            x *= x;
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        LC_50_Pow inst = new LC_50_Pow();
        System.out.println(inst.pow(2,10));
    }

}
