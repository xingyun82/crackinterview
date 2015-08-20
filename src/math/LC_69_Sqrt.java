package math;

/**
 * Created by xingyun on 15/8/17.
 */
public class LC_69_Sqrt {

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

    public static void main(String[] args) {
        LC_69_Sqrt inst = new LC_69_Sqrt();
        System.out.println(inst.sqrt(15));


    }
}
