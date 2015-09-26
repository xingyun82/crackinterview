package math;

/**
 * Created by xingyun on 15/8/17.
 */
public class LC_69_Sqrt {


    public double sqrt(double x) {
        double ACCURACY = 0.000001;
        double res, l, h;
        if(x < 1) {
            l = x;
            h = 1;
        } else {
            l = 1;
            h = x;
        }
        while((h-l)>ACCURACY) {
            res = (h+l)/2;
            if(res*res > x) {
                h = res;
            } else {
                l = res;
            }
        }
        return (h+l)/2;

    }


    /*
    public int sqrt(int x) {
        long ans = 0;
        long bit = 1l << 16;
        while(bit > 0) {
            ans |= bit;
            if (ans * ans > x) {
                ans ^= bit;
            }
            bit >>= 1;
        }
        return (int)ans;
    }
    */

    public int sqrt(int x) {
        int l=0, h=x, res;
        while((h-l)>1) {
            res = l+(h-l)/2;
            if(res>x/res) {
                h = res;
            } else {
                l = res;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        LC_69_Sqrt inst = new LC_69_Sqrt();
//        System.out.println(inst.sqrt(15));
        System.out.println(inst.sqrt(16));

    }
}
