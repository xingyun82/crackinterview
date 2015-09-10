package math;

/**
 * Created by xingyun on 15/9/9.
 */
public class CountOneOfBinary {

    public int count(int a) {
        int res = 0;
        while(a!= 0) {
            a &= a-1; // 去掉最后面的1
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        CountOneOfBinary inst = new CountOneOfBinary();
        System.out.println(inst.count(Integer.MIN_VALUE));
    }
}
