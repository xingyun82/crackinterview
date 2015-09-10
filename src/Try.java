import java.io.BufferedReader;

import java.io.*;
/**
 * Created by xingyun on 15/9/4.
 */
class Test1 {

    public Test1() { System.out.println("t1 constructor called.");};
    public Test1(int x) {
        System.out.println("t1 constructor called "+x);
    }
}

class Test2 extends Test1 {

    public Test2(int y) {
        System.out.println("t2 constructor called " + y);
    }
}

public class Try {

    Test1 t1 = new Test1(10);

    public Try(int i) { t1 = new Test1(i);};

    /**
     * A number starting from 1 can be got by either multiplying 3 or adding 5 to it.
     * Given a number, find the sequence of operations to get it or say it’s not possible.
     */
    public boolean isPossible(int a, int target) {
        if(a == target) return true;
        if(a > target) return false;
        boolean p1 = isPossible(a*3, target);
        if(p1) return true;
        boolean p2 = isPossible(a+5, target);
        return p2;
    }

    /**
     * suppose array A is 1, 2, 3, 4, ...
     * return the array B, where b[i] is product of all the element in A without a[i]
     *
     */
    public int[] prod(int[] a) {
        int[] prod1 = new int[a.length];
        int[] prod2 = new int[a.length];
        prod1[0] = 1;
        prod2[a.length-1] = 1;
        // 1 2 3 4
        //   1     1  1*2 1*2*3
        // 2*3*4  3*4  4    1
        for(int i=1; i<a.length; ++i) {
            prod1[i] = prod1[i-1]*a[i-1];
        }
        for(int j=a.length-2; j>=0; --j) {
            prod2[j] = prod2[j+1]*a[j+1];
        }
        int[] prod = new int[a.length];
        for(int i=0; i<a.length; ++i) {
            prod[i] = prod1[i]*prod2[i];
        }
        return prod;
    }

    /**
     * when does hour hand and minute hand will overlap
     * suppose the house is x, minute is y, and second is z
     * then, if hour hand and minute hand overlap, we have
     * one hour is 30 angles
     * our minute is 6 angles
     * 30*(x+(y+z/60)/60) = 6*(y+z/60)
     * if minute hand and second hand overlaps, we have
     * 6*(y+z/60) = 6*z
     */

    public void clock() {
        for(int x=0; x<24; x++) {
            for(int y=0; y<60; y++) {
                for(int z=0; z<60; z++) {
                    /*
                    if(60*y == 59*z) {
                        System.out.println("m:" + y + ", s:" + z);
                    }
                    */
                    if((3600*(x%12) - 660*y)/11 == z) {
                        System.out.println("h:" + x + ", m:" + y + ", s:" + z);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Try inst = new Try(1);
        //System.out.println(inst.isPossible(1, 13));
//        int[] a = {1,2,3,4};
//        int[] prod = inst.prod(a);
//        for(int i:prod) {
//            System.out.print(i+" ");
//        }
        inst.clock();
    }
}
